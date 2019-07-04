package com.sosimplebox.distribute_lock_001;

import java.util.List;
import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

public class RedisDistributeLock {
	
	private final JedisPool jedisPool;
	
	public RedisDistributeLock(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	public String lockWithTimeout(String lockName, long acquireTimeout, long timeout) {
		Jedis conn = null;
		String retIdentifier = null;
		
		try {
			conn = this.jedisPool.getResource();
			String identifier = UUID.randomUUID().toString();
			String lockKey = "lock: " + lockName;
			
			int lockExpire = (int)(timeout/1000);
			
			long end = System.currentTimeMillis() + acquireTimeout;
			
			while (System.currentTimeMillis() < end) {
				if (conn.setnx(lockKey, identifier) == 1) {
					conn.expire(lockKey, lockExpire);
					retIdentifier = identifier;
					return retIdentifier;
				}
				
				if (conn.ttl(lockKey) == -1) {
					conn.expire(lockKey, lockExpire);
				}
				
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return retIdentifier;
	}
	
	public boolean releaseLock(String lockName, String identifier) {
		Jedis conn = null;
		String lockKey = "lock: " + lockName;
		boolean retFlag = false;
		
		try {
			conn = this.jedisPool.getResource();
			
			while(true) {
				conn.watch(lockKey);
				
				if (identifier.equals(conn.get(lockKey))) {
					Transaction transaction = conn.multi();
					transaction.del(lockKey);
					List<Object> results = transaction.exec();
					if (results == null) {
						continue;
					}
					retFlag = true;
				}
				conn.unwatch();
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
		return retFlag;
	}

}

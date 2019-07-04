package com.sosimplebox.distribute_lock_001;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisDistributeService {
	
	private static JedisPool jedisPool = null;
	
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(200);
		config.setMaxIdle(8);
		config.setMaxWaitMillis(1000*100);
		config.setTestOnBorrow(false);
		jedisPool = new JedisPool(config, "127.0.0.1", 6379, 3000, "123456");
	}
	
	RedisDistributeLock lock = new RedisDistributeLock(jedisPool);
	
	int n = 500;
	
	public void seckill() {
		String identifier = lock.lockWithTimeout("resource", 5000, 1000000);
		System.out.println(String.format("线程%s获得了锁%s, n = %d", Thread.currentThread().getName(), identifier, --n));
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.releaseLock("resource", identifier);
		System.out.println(String.format("线程%s释放了锁%s", Thread.currentThread().getName(), identifier));
		
	}

}

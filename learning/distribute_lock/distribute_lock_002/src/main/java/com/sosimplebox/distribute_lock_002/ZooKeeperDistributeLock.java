package com.sosimplebox.distribute_lock_002;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZooKeeperDistributeLock implements Lock, Watcher {
	
	private ZooKeeper zk = null;
	
	private String ROOT_LOCK = "/locks";
	
	private String lockName;
	
	private String WAIT_LOCK;
	
	private String CURRENT_LOCK;
	
	private CountDownLatch countDownLatch;
	
	private int sessionTimeout = 30 * 1000;
	
	private List<Exception> exceptionList = new ArrayList<Exception>();
	
	public ZooKeeperDistributeLock(String config, String lockName) {
		this.lockName = lockName;
		
		try {
			zk = new ZooKeeper(config, sessionTimeout, this);
			Stat stat = zk.exists(ROOT_LOCK, false);
			if (stat == null) {
				zk.create(ROOT_LOCK, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		if (this.countDownLatch != null) {
			this.countDownLatch.countDown();
		}
	}

	public void lock() {
		// TODO Auto-generated method stub
		if (exceptionList.size() > 0) {
			throw new LockException(exceptionList.get(0));
		}
		
		try {
			if (this.tryLock()) {
				System.out.println(String.format("%s 获得了锁 %s", Thread.currentThread().getName(), lockName));
				return;
			}else {
				waitForLock(WAIT_LOCK, sessionTimeout);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean tryLock() {
		try {
			String splitStr = "_lock_";
			if (lockName.contains(splitStr)) {
				throw new LockException("锁名有误");
			}
			CURRENT_LOCK = zk.create(ROOT_LOCK + "/" + lockName + splitStr, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

			System.out.println(String.format("%s已经创建", CURRENT_LOCK));
			
			List<String> subNodes = zk.getChildren(ROOT_LOCK, false);
			
			List<String> lockObjects = new ArrayList<String>();
			
			for (String node : subNodes) {
				String _node = node.split(splitStr)[0];
				if (_node.equals(lockName)) {
					lockObjects.add(node);
				}
			}
			Collections.sort(lockObjects);
			System.out.println(String.format("%s的锁是%s", Thread.currentThread().getName(), CURRENT_LOCK));
			if (CURRENT_LOCK.equals(ROOT_LOCK + "/" + lockObjects.get(0))) {
				return true;
			}
			String prevNode = CURRENT_LOCK.substring(CURRENT_LOCK.lastIndexOf("/") + 1);
			WAIT_LOCK = lockObjects.get(Collections.binarySearch(lockObjects, prevNode) - 1);
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean tryLock(long timeout, TimeUnit unit){
		try {
			if (this.tryLock()) {
				return true;
			}
			return waitForLock(WAIT_LOCK, timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void unlock() {
		// TODO Auto-generated method stub
		try {
			System.out.println(String.format("%s 释放锁 %s", Thread.currentThread().getName(), CURRENT_LOCK));
			zk.delete(CURRENT_LOCK, -1);
			CURRENT_LOCK = null;
			zk.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author huangww
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 *
	 */
	private boolean waitForLock(String prev, long waitTime) throws InterruptedException, KeeperException {
		Stat stat = zk.exists(ROOT_LOCK + "/" + prev, true);
		
		if (stat != null) {
			System.out.println(String.format("%s 等待锁  %s", Thread.currentThread().getName(), ROOT_LOCK + "/" + prev));
			this.countDownLatch = new CountDownLatch(1);
			this.countDownLatch.await(waitTime, TimeUnit.MICROSECONDS);
			this.countDownLatch = null;
			System.out.println(String.format("%s 等到了锁", Thread.currentThread().getName()));
		}
		return true;
	}
	
	public class LockException extends RuntimeException {
		public LockException(String e) {
			super(e);
		}
		
		public LockException(Exception e) {
			super(e);
		}
	}
}

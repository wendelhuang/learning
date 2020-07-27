package com.sklink.learning.juc.juc001;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadInterruptExample {
	
	
	static class ReentrantLockTask implements Runnable {
		ReentrantLock lock1;
		ReentrantLock lock2;
		
		public ReentrantLockTask(ReentrantLock lock1, ReentrantLock lock2) {
			this.lock1 = lock1;
			this.lock2 = lock2;
		}

		@Override
		public void run() {
			try {
				lock1.lockInterruptibly();
				TimeUnit.MILLISECONDS.sleep(200);
				lock2.lockInterruptibly();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock1.unlock();
				lock2.unlock();
				System.out.println(String.format("线程%s正常结束", Thread.currentThread().getName()));
			}
		}
		
	}
	
	static class SynchronizedTask implements Runnable {
		Object lock1;
		Object lock2;
		
		public SynchronizedTask(Object lock1, Object lock2) {
			this.lock1 = lock1;
			this.lock2 = lock2;
		}
		
		@Override
		public void run() {
			try {
				synchronized (lock1) {
					TimeUnit.MILLISECONDS.sleep(200);
					synchronized (lock2) {
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println(String.format("线程%s正常结束", Thread.currentThread().getName()));
			}
		}
	}
	
	public void reentrantLockInterrupt() throws Exception {

		ReentrantLock lock1 = new ReentrantLock();
		ReentrantLock lock2 = new ReentrantLock();
		
		Thread t1 = new Thread(new ReentrantLockTask(lock1, lock2));
		Thread t2 = new Thread(new ReentrantLockTask(lock2, lock1));
		
		t1.start();
		t2.start();
		
		System.out.println(String.format("%s中断", t1.getName()));
		Thread.sleep(1000);
		t1.interrupt();
		Thread.sleep(10000);
	}
	
	public void synchronizedInterrupt() throws Exception {

		Object lock1 = new Object();
		Object lock2 = new Object();
		
		Thread t1 = new Thread(new SynchronizedTask(lock1, lock2));
		Thread t2 = new Thread(new SynchronizedTask(lock2, lock1));
		
		t1.start();
		t2.start();
		
		System.out.println(String.format("%s中断", t1.getName()));
		Thread.sleep(1000);
		t1.interrupt();
		Thread.sleep(10000);
	}
	
	public static void main(String[] args) throws Exception {
		ThreadInterruptExample e1 = new ThreadInterruptExample();
		ThreadInterruptExample e2 = new ThreadInterruptExample();
		e1.reentrantLockInterrupt();
		e2.synchronizedInterrupt();
	}
}

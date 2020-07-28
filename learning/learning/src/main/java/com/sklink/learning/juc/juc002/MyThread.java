package com.sklink.learning.juc.juc002;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
	
	public void test3() throws Exception {
		final Lock lock = new ReentrantLock();
		
		lock.lock();
		
		Thread.sleep(1000);
		
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			//lock.lock();
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		});
		
		t1.start();
		Thread.sleep(1000);
		t1.interrupt();
		Thread.sleep(5000);
	}
	
	public static void main(String[] args) throws Exception {
		new MyThread().test3();
	}
}

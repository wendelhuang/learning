package com.sklink.learning.juc.threadPoolExecutor_001_rejectedExecutionHandler_001;

public class MyThread implements Runnable {

	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(String.format("%s start in %s", this.name, Thread.currentThread().getName()));
			Thread.sleep(2000);
			System.out.println(String.format("%s end", this.name, Thread.currentThread().getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

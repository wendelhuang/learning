package com.sklink.learning.lang.threadlocal.threadlocal001;

public class ThreadLocal001_001 {
	public static void main(String[] args) {
		ThreadLocal<String> local = new ThreadLocal<>();
		local.set("我是主线程");
		Thread thread = new Thread(() -> {
			System.out.println(local.get());
		});
		thread.start();
	}
}

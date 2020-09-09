package com.sklink.learning.lang.threadlocal.threadlocal001;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocal001_004 {
	public static void main(String[] args) throws InterruptedException {
		ThreadLocal<String> local = new InheritableThreadLocal<>();

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		CountDownLatch countDownLatch1 = new CountDownLatch(1);
		CountDownLatch countDownLatch2 = new CountDownLatch(1);

		local.set("我是主线程1");
		executorService.submit(() -> {
			System.out.println(String.format("1Thread-%s", local.get()));
			countDownLatch1.countDown();
		});

		countDownLatch1.await();
		System.out.println(String.format("%s", local.get()));

		System.out.println("----------------");

		local.set("我是主线程2");
		executorService.submit(() -> {
			System.out.println(String.format("2Thread-%s", local.get()));
			countDownLatch2.countDown();
		});

		countDownLatch2.await();
		System.out.println(String.format("%s", local.get()));

		executorService.shutdown();
	}
}

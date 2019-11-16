package com.sklink.learning.juc.threadPoolExecutor_001_rejectedExecutionHandler_001;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PolicyDiscardPolicy extends PolicyAbstractPolicy {
	public void test() {
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(1));

		poolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

		for (int i = 0; i < 10; i++) {
			Runnable r = new MyThread("task-" + i);
			poolExecutor.execute(r);
		}
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		poolExecutor.shutdown();
	}
}

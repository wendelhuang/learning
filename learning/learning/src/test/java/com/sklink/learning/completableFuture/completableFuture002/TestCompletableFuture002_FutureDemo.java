package com.sklink.learning.completableFuture.completableFuture002;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class TestCompletableFuture002_FutureDemo {

	static class CallableTask implements Callable<Integer> {
		Integer i;
		public CallableTask(Integer i) {
			super();
			this.i = i;
		}
		@Override
		public Integer call() throws Exception {
			Thread.sleep(this.i == 1 ? 3000 : (this.i == 5 ? 5000 : 1000));
			System.out.println(String.format("%s - task线程: %s, 任务i = %d完成", new Date(), Thread.currentThread().getName(), this.i));
			return this.i;
		}
	}
	
	@Test
	public void test() {
		Long start = System.currentTimeMillis();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		try {
			List<Integer> list = new ArrayList<>();
			List<Future<Integer>> futureList = new ArrayList<>();
			
			for(int i = 0; i < 10; i++) {
				futureList.add(executorService.submit(new CallableTask(i)));
			}
			Long getResultStart = System.currentTimeMillis();
			System.out.println(String.format("结果归集开始时间: %s", new Date()));
			
			while (futureList.size() > 0) {
				Iterator<Future<Integer>> iterable = futureList.iterator();
				
				while(iterable.hasNext()) {
					Future<Integer> future = iterable.next();
					
					if (future.isDone() && !future.isCancelled()) {
						Integer i = future.get();
						System.out.println(String.format("%s - 任务i=%d获取完成, 移出任务队列", new Date(), i));
						list.add(i);
						iterable.remove();
					}else {
						Thread.sleep(1);
					}
				}
			}
			System.out.println("list = " + list);
			System.out.println(String.format("总耗时: %d, 获取结果归集耗时: %d", (System.currentTimeMillis() - start), System.currentTimeMillis() - getResultStart));
		}catch (Exception e) {
			e.printStackTrace();
			executorService.shutdown();
		}
	}
}

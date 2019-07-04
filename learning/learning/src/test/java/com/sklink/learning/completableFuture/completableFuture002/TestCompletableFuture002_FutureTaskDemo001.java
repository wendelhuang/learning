package com.sklink.learning.completableFuture.completableFuture002;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class TestCompletableFuture002_FutureTaskDemo001 {

	static class CallableTask implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			System.out.println(String.format("%s - 查询分公司利润开始", new Date()));
			Thread.sleep(10000);
			System.out.println(String.format("%s - 查询分公司利润结束", new Date()));
			return 10;
		}
	}
	
	@Test
	public void test() {
		try {

			System.out.println("======例如一个统计公司总部和分布的总利润是否达标100万==========");
			
			Integer count = 0;
			
			FutureTask<Integer> futureTask = new FutureTask<>(new CallableTask());
			
			Thread futureTaskThread = new Thread(futureTask);
			futureTaskThread.start();
			System.out.println(String.format("%s - futureTaskThread start", new Date()));
			
			System.out.println(String.format("%s - 主线程查询总部公司利润开始", new Date()));
			Thread.sleep(5000);
			System.out.println(String.format("%s - 主线程查询总部公司利润结束", new Date()));
			
			if (count >= 100) {
				System.out.println(String.format("%s - 总部利润达标，取消futureTask", new Date()));
				futureTask.cancel(true);
			}else {
				System.out.println(String.format("%s - 总部公司利润未达标, 进入阻塞查询分公司利润", new Date()));
				Integer i = futureTask.get();
				System.out.println(String.format("%s - 获取到结果i = %d", new Date(), i));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

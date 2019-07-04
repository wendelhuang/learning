package com.sklink.learning.completableFuture.completableFuture001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestCompletedFuture001 {
	
	@Test
	public void test() {
		Long start = System.currentTimeMillis();
		
		List<String> list = new ArrayList<>();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		List<Integer> taskList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		CompletableFuture[] cfs = taskList.stream().map(
					i -> CompletableFuture.supplyAsync(() -> calc(i), executorService)
											.thenApply(h -> Integer.toString(h))
											.whenComplete((s, e) -> {
												System.out.println("任务" + s + "完成, result = " + s + ", 异常e = " + e + ", " + new Date());
												list.add(s);
											})
				)
				.toArray(CompletableFuture[]::new);
		CompletableFuture.allOf(cfs).join();
		System.out.println("list = " + list + ", 耗时 = " + (System.currentTimeMillis() - start));
	}
	
	public int calc(Integer num) {
		try {
			if (num == 1) {
				Thread.sleep(3000);
			}else if (num == 5) {
				Thread.sleep(5000);
			}else {
				Thread.sleep(1000);
			}
			System.out.println(String.format("线程%s, 任务i=%d执行完成%s", Thread.currentThread().getName(), num, new Date()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}

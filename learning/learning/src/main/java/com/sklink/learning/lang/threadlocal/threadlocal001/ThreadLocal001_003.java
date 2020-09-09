package com.sklink.learning.lang.threadlocal.threadlocal001;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadLocal001_003 {
	public static void main(String[] args) {
		ThreadLocal<String> local = new InheritableThreadLocal<>();
		local.set("我是主线程");

		Thread thread = new Thread(() -> {
			System.out.println(String.format("Thread-%s", local.get()));
		});
		thread.start();

		List<Integer> ids = IntStream.range(1, 10).boxed().collect(Collectors.toList());
		ids.parallelStream().forEach(id -> {
			System.out.println(String.format("parallemStream-%s-%s", id, local.get()));
		});
	}
}

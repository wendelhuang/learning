package com.sklink.learning.lang.threadlocal.threadlocal001;

import java.util.stream.IntStream;

public class ThreadLocal001_002 {
	public static void main(String[] args) {
		ThreadLocal<String> local = new ThreadLocal<>();
		local.set("我是主线程");

		IntStream.range(1, 10).parallel().forEach(id -> {
			System.out.println(String.format("%s-%s", id, local.get()));
		});
	}
}

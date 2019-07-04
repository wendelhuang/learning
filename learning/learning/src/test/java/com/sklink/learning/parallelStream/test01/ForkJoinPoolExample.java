package com.sklink.learning.parallelStream.test01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class ForkJoinPoolExample {
	List<Integer> numbers = new ArrayList<Integer>();

	@Before
	public void setup() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		numbers = Collections.unmodifiableList(list);
	}

	@Test
	public void test() {
		ForkJoinPool forkJoinPool1 = new ForkJoinPool(4);
		Thread t1 = new Thread(() -> forkJoinPool1.submit(() -> {
			numbers.parallelStream().forEach(n -> {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Loop 1: " + Thread.currentThread());
			});
		}).invoke());

		ForkJoinPool forkJoinPool2 = new ForkJoinPool(4);
		Thread t2 = new Thread(() -> forkJoinPool2.submit(() -> {
			numbers.parallelStream().forEach(n -> {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Loop 2: " + Thread.currentThread());
			});
		}).invoke());

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

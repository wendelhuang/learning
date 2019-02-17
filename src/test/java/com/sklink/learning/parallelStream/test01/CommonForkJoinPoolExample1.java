package com.sklink.learning.parallelStream.test01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class CommonForkJoinPoolExample1 {
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
		numbers.parallelStream().forEach(n -> {
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Loop 1: " + Thread.currentThread());
		});
	}

}

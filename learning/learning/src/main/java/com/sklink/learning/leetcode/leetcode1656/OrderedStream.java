package com.sklink.learning.leetcode.leetcode1656;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {

	int pointer;
	int[] arr;
	String[] srr;

	public OrderedStream(int n) {
		this.pointer = 1;
		this.arr = new int[n+1];
		this.srr = new String[n+1];
	}

	public List<String> insert(int id, String value) {
		arr[id] = id;
		srr[id] = value;
		List<String> res = new ArrayList<>();
		if (pointer < arr.length && arr[pointer] != 0) {
			while(pointer < arr.length && arr[pointer] != 0) {
				res.add(srr[pointer]);
				pointer++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		OrderedStream orderedStream = new OrderedStream(5);

		List<String> res = orderedStream.insert(3, "ccccc");
		System.out.println("3");
		res.stream().forEach(System.out::println);

		res = orderedStream.insert(1, "aaaaa");
		System.out.println("1");
		res.stream().forEach(System.out::println);

		res = orderedStream.insert(2, "bbbbb");
		System.out.println("2");
		res.stream().forEach(System.out::println);

		res = orderedStream.insert(5, "eeeee");
		System.out.println("5");
		res.stream().forEach(System.out::println);

		res = orderedStream.insert(4, "ddddd");
		System.out.println("4");
		res.stream().forEach(System.out::println);
	}
}


package com.sklink.learning.leetcode.leetcode1414;

public class Solution {
	public int findMinFibonacciNumbers(int k) {
		int max = maxFibonacci(k);
		if (max == k) {
			return 1;
		} else {
			return findMinFibonacciNumbers(k - max) + 1;
		}
	}

	public int maxFibonacci(int num) {
		// System.out.println("num: " + num);
		if (num == 1 || num == 2) {
			return num;
		}
		int f1 = 1;
		int f2 = 2;
		while (f2 < num) {
			int temp = f2;
			f2 += f1;
			f1 = temp;
		}
		// System.out.println("f1, f2" + Arrays.toString(new int[] { f1, f2 }));
		return f2 == num ? f2 : f1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMinFibonacciNumbers(19));
	}
}

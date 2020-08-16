package com.sklink.learning.leetcode.weekly_contest_202.problem02;

class Solution {
	public int minOperations(int n) {
		if ((n & 1) == 1) {
			int len = n / 2 + 1;
			return len * (0 + 2 * (len - 1)) / 2;
		} else {
			int len = n / 2;
			return len + len * (0 + 2 * (len - 1)) / 2;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1 };
		Solution solution = new Solution();
		System.out.println(solution.minOperations(5));
		;

	}
}
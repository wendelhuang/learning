package com.sklink.learning.leetcode.weekly_contest_188.problem02;

class Solution {
	public int countTriplets(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				a ^= arr[j];
				int b = arr[j];
				for (int k = j; k < arr.length; k++) {
					b ^= arr[k];
					if (a == b) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1 };
		Solution solution = new Solution();
		System.out.println(solution.countTriplets(arr));
		;

	}
}
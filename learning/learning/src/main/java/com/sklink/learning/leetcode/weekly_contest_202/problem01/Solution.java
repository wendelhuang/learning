package com.sklink.learning.leetcode.weekly_contest_202.problem01;

class Solution {
	public boolean threeConsecutiveOdds(int[] arr) {
		if (arr == null || arr.length < 3) {
			return false;
		}
		for (int i = 0; i < arr.length - 2; i++) {
			if ((arr[i] & 1 == 1) && (arr[i + 1] & 1 == 1) && (arr[i + 2] & 1 == 1)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = { 1, 3 };
		System.out.println(solution.buildArray(arr, 3));
	}
}
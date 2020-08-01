package com.sklink.learning.leetcode.leetcode209;

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		while (end < nums.length) {
			sum += nums[end];
			while (sum >= s) {
				res = Math.min(res, end - start + 1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int s = 7;
		int[] nums = new int[] { 19, 3, 1, 2, 4, 3 };
		System.out.println(solution.minSubArrayLen(s, nums));
	}
}

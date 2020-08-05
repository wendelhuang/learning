package com.sklink.learning.leetcode.leetcode300;

import java.util.Arrays;

public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int res = 1;
		for(int i = 1; i < nums.length; i++) {
			dp[i]=1;
			for(int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		//System.out.println(Arrays.toString(dp));
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {10,9,2,5,3,7,101,18};
		System.out.println(solution.lengthOfLIS(nums));
	}
}

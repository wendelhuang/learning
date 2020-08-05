package com.sklink.learning.leetcode.leetcode279;

import java.util.Arrays;

class Solution {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= n; j++) {
				if (i < j * j) {
					break;
				} else {
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int res = new Solution().numSquares(12);
		System.out.println(res);
	}
}
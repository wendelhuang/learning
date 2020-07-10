package com.sklink.learning.leetcode.leetcode309;

class Solution {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1) {
			return 0;
		}
		int dp[][] = new int[len][3];
		dp[0][0] = -prices[0];
		for(int i = 1; i < len; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
			dp[i][1] = dp[i-1][0] + prices[i];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
		}
		return Math.max(dp[len-1][1], dp[len-1][2]);
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,0,2};
		Solution solution = new Solution();
		int res = solution.maxProfit(arr);
		System.out.println(res);
	}
}
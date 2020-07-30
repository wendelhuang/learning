package com.sklink.learning.leetcode.leetcode64;

class Solution {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m+1][n+1];
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) {
					dp[i][j] = grid[i-1][j-1];
				}else if (i == 1) {
					dp[i][j] = dp[i][j-1] + grid[i-1][j-1];
				}else if (j == 1) {
					dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
				}else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
				}
			}
		}
		return dp[m][n];
    }
	
	public static void main(String[] args) {
		int[][] intervals = new int[][] {
			new int[] {1,3,1},
			new int[] {1,5,1},
			new int[] {4,2,1}
		};
		System.out.println(new Solution().minPathSum(intervals));
	}
}
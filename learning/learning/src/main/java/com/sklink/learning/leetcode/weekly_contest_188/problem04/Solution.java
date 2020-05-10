package com.sklink.learning.leetcode.weekly_contest_188.problem04;

class Solution {
	public int ways(String[] pizza, int k) {
		int[][][] dp = new int[55][55][15];
		int[][] count = new int[55][55];
		int row = pizza.length;
		int col = pizza[0].length();
		int MOD = 1_000_000_000 + 7;

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				count[i][j] = count[i + 1][j] + count[i][j + 1] - count[i + 1][j + 1];
				if (pizza[i].charAt(j) == 'A') {
					count[i][j]++;
				}
				if (count[i][j] > 0) {
					dp[i][j][1] = 1;
				}
			}
		}
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				for (int n = 2; n <= k; n++) {
					int c = 0;
					if (count[i][j] < n) {
						dp[i][j][n] = 0;
					} else {
						for (int kk = i + 1; kk < row; kk++) {
							if (count[i][j] - count[kk][j] > 0) {
								c += dp[kk][j][n - 1];
								c %= MOD;
							}
						}
						for (int kk = j + 1; kk < col; kk++) {
							if (count[i][j] - count[i][kk] > 0) {
								c += dp[i][kk][n - 1];
								c %= MOD;
							}
						}
					}
					dp[i][j][n] = c;
				}
			}
		}
		return dp[0][0][k];
	}

	public static void main(String[] args) {
		// int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, {
		// 2, 6 } };
		// List<Boolean> hasApple = Arrays.asList(false, false, true, false,
		// true, true, false);
		// int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, {
		// 2, 6 } };
		// List<Boolean> hasApple = Arrays.asList(false, false, true, false,
		// false, true, false);
		// String[] pizza = { "A..", "AAA", "..." };
		// String[] pizza = { "A..", "AA.", "..." };
		String[] pizza = { "A..", "A..", "..." };
		int k = 1;
		Solution solution = new Solution();
		System.out.println(solution.ways(pizza, k));

	}
}
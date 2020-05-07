package com.sklink.learning.leetcode.leetcode221.leetcode221_01;

class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		boolean debug = false;
		if (debug) {
			System.out
					.println(String.format("matrix.length: %d, matrix[0].length=%d", matrix.length, matrix[0].length));
		}
		int[][] dp = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					}
				}
				max = Math.max(max, dp[i][j]);
				if (debug) {
				}
			}
		}

		return max * max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(solution.maximalSquare(matrix));
	}
}
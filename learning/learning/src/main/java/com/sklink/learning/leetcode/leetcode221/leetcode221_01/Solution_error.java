package com.sklink.learning.leetcode.leetcode221.leetcode221_01;

/**
 * 错在理解错误，行列上都是1不代表矩阵内容都为1
 * 
 * @author wendel
 *
 */
class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		boolean debug = true;
		if (debug) {
			System.out
					.println(String.format("matrix.length: %d, matrix[0].length=%d", matrix.length, matrix[0].length));
		}
		int[][] inRow = new int[matrix.length][matrix[0].length];
		int[][] inCol = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					inRow[i][j] = matrix[i][j] == '1' ? 1 : 0;
					inCol[i][j] = matrix[i][j] == '1' ? 1 : 0;
				} else if (i == 0) {
					inRow[i][j] = matrix[i][j] == '1' ? 1 : 0;
					inCol[i][j] = matrix[i][j] == '1' ? inCol[i][j - 1] + 1 : 0;
				} else if (j == 0) {
					inRow[i][j] = matrix[i][j] == '1' ? inRow[i - 1][j] + 1 : 0;
					inCol[i][j] = matrix[i][j] == '1' ? 1 : 0;
				} else {
					inRow[i][j] = matrix[i][j] == '1' ? inRow[i - 1][j] + 1 : 0;
					inCol[i][j] = matrix[i][j] == '1' ? inCol[i][j - 1] + 1 : 0;
				}
				max = Math.max(max, Math.min(inRow[i][j], inCol[i][j]));
				if (debug) {
					System.out.println(String.format("i = %d, j = %d, inRow[i][j] = %d, inCol[i][j]=%d, max = %d", i, j,
							inRow[i][j], inCol[i][j], max));
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
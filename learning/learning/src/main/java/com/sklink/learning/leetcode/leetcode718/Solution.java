package com.sklink.learning.leetcode.leetcode718;

import java.util.Arrays;

public class Solution {
	public int findLength(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int[][] dp = new int[m][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 0);
		}
		for(int i = 0; i < m; i++) {
			if (A[i] == B[0]) {
				dp[i][0] = 1;
			}
		}
		for(int i = 0; i < n; i++) {
			if (A[0] == B[i]) {
				dp[0][i] = 1;
			}
		}
		int res = 0;
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if (A[i] == B[j]) {
					dp[i][j] = dp[i-1][j-1]+1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,2,1};
		int[] B = new int[] {3,2,1,4,7};
		System.out.println(new Solution().findLength(A, B));
	}
}

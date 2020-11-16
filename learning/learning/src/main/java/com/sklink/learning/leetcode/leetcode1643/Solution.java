package com.sklink.learning.leetcode.leetcode1643;

public class Solution {
	public String kthSmallestPath(int[] destination, int k) {
		int m = destination[0];
		int n = destination[1];

		int[][] dp = new int[m+2][n+2];
		dp[m][n] = 1;
		for(int i = m; i >= 0; i--) {
			for(int j = n; j >= 0; j--) {
				dp[i][j] += dp[i+1][j] + dp[i][j+1];
			}
		}
		int x = 0, y = 0;
		String ans = "";
		for (int i = 0; i < m + n; ++i) {
			if (x < m) {
				if (y < n) {
					if (dp[x][y + 1] >= k) {
						ans += "H";
						y++;
					}
					else {
						ans += "V";
						k -= dp[x][y + 1];
						x++;
					}
				}
				else ans += "V";
			}
			else ans += "H";
		}
		return ans;
	}

	public void print(int num) {
		for(int i = 31; i >= 0; i--) {
			System.out.print((num&(1<<i)) == 0 ? 0 : 1);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] destination = new int[] {2,3};
		int k = 1;
		System.out.println(solution.kthSmallestPath(destination, k));
	}
}


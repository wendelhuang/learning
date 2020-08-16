package com.sklink.learning.leetcode.leetcode546;

public class Solution {

	public int removeBoxes(int[] boxes) {
		int[][][] dp = new int[100][100][100];
		return dfs(boxes, dp, 0, boxes.length - 1, 0);
	}

	public int dfs(int[] boxes, int[][][] dp, int left, int right, int k) {
		if (left > right) {
			return 0;
		}
		if (dp[left][right][k] != 0) {
			return dp[left][right][k];
		}
		while (right > left && boxes[right] == boxes[right - 1]) {
			right--;
			k++;
		}
		dp[left][right][k] = dfs(boxes, dp, left, right - 1, 0) + (k + 1) * (k + 1);
		for (int i = left; i < right; i++) {
			if (boxes[i] == boxes[right]) {
				dp[left][right][k] = Math.max(dp[left][right][k],
						dfs(boxes, dp, left, i, k + 1) + dfs(boxes, dp, i + 1, right - 1, 0));
			}
		}
		return dp[left][right][k];
	}

	public static void main(String[] args) {
		int[] boxes = new int[] { 1, 2, 1 };
		System.out.println(new Solution().removeBoxes(boxes));
	}
}

package com.sklink.learning.leetcode.leetcode60;

import java.util.Arrays;

class Solution {
	public String getPermutation(int n, int k) {
		int N = n + 1;
		int K = k - 1;
		boolean[] visited = new boolean[N];
		int p = 1;
		for (int i = 1; i <= n; i++) {
			p = p * i;
		}
		StringBuffer res = new StringBuffer();
		for (int i = n; i > 0; i--) {
			System.out.println("p, i = " + Arrays.toString(new int[] { p, i }));
			p = p / i;
			int seg = K / p + 1;
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					cnt++;
					if (cnt == seg) {
						visited[j] = true;
						res.append("" + j);
					}
				}
			}
			K %= p;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().getPermutation(4, 9));
	}
}
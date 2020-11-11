package com.sklink.learning.leetcode.leetcode514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int findRotateSteps(String ring, String key) {
		List<Integer>[] list = new List[26];
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < ring.length(); i++) {
			list[ring.charAt(i) - 'a'].add(i);
		}
		int[][] dp = new int[ring.length()][key.length()];
		for(int i = 0; i < ring.length(); i++) {
			for(int j = 0; j < key.length(); j++) {
				dp[i][j] = 0x3f3f3f;
			}
		}
		for(int i = 0; i < list[key.charAt(0)-'a'].size(); i++) {
			int n = list[key.charAt(0)-'a'].get(i);
			dp[n][0] = Math.min(n, ring.length()-n) + 1;
		}
		for(int i = 1; i < key.length(); i++) {
			for(int j = 0; j < list[key.charAt(i)-'a'].size(); j++) {
				int n = list[key.charAt(i)-'a'].get(j);
				for(int k = 0; k < list[key.charAt(i-1)-'a'].size(); k++) {
					int m = list[key.charAt(i-1)-'a'].get(k);
					//System.out.println(Arrays.toString(new int[] {j, i, m, n, dp[m][i-1]}));
					int v = dp[m][i-1] + Math.min(Math.abs(m-n), ring.length()-Math.abs((m-n))) + 1;
					dp[n][i] = Math.min(dp[n][i], v);
				}
				//print(dp);
			}
		}
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < ring.length(); i++) {
			if (res > dp[i][key.length()-1]) {
				res = dp[i][key.length()-1];
			}
		}
		return res;
    }
	
	public void print(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println("----------------------------");
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String ring = "abcde";
		String key = "ade";
		int res = solution.findRotateSteps(ring, key);
		System.out.println(res);
	}
}

package com.sklink.learning.leetcode.leetcode647;

import java.util.Arrays;

class Solution {
	public int countSubstrings(String s) {
		if (s == null || s.length() < 1) {
			return 0;
		}
		int sLen = s.length();
		int[][] dp = new int[sLen][sLen];
		for(int len = 0; len < s.length(); len++) {
			for(int i = 0; i + len < s.length(); i++) {
				int begin = i;
				int end = i+len;
				int cBegin = s.charAt(begin);
				int cEnd = s.charAt(end);
				if (begin == end || 
						(end == begin+1 && cBegin == cEnd) || 
						(dp[begin+1][end-1] == 1 && cBegin == cEnd)) {
					dp[begin][end] = 1;
				}
			}
		}
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			//System.out.println(Arrays.toString(dp[i]));
			for(int j = 0; j < s.length(); j++) {
				if (dp[i][j] == 1) {
					res ++;
				}
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().countSubstrings("aaa"));
	}
}
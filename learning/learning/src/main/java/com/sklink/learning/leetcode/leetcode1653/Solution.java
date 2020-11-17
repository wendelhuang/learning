package com.sklink.learning.leetcode.leetcode1653;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Solution {
	public int minimumDeletions(String s) {
		int[] aPrefix = new int[s.length()];
		int[] bSuffix = new int[s.length()];
		aPrefix[0] = s.charAt(0) == 'a' ? 1 : 0;
		bSuffix[s.length()-1] = s.charAt(s.length()-1) == 'b' ? 1 : 0;
		for(int i = 1; i < s.length(); i++) {
			aPrefix[i] = aPrefix[i-1] + (s.charAt(i) == 'a' ? 1 : 0);
			bSuffix[s.length()-i-1] =  bSuffix[s.length()-i] + (s.charAt(s.length()-i-1) == 'b' ? 1 : 0);
		}

		int longest = 0;
		for(int i = 0; i < s.length(); i++) {
			longest = Math.max(longest, aPrefix[i] + bSuffix[i]);
		}

		return s.length()-longest;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "aababbab";
		int res = solution.minimumDeletions(s);
		System.out.println(res);
	}
}

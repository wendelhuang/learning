package com.sklink.learning.leetcode.leetcode459;

class Solution {
	public boolean repeatedSubstringPattern(String s) {
		int len = s.length();
		for(int step = 1; step <= len/2; step++) {
			if (len%step == 0) {
				boolean match = true;
				for(int i = step; i < len; i++) {
					if (s.charAt(i) != s.charAt(i-step)) {
						match = false;
						break;
					}
				}
				if (match) {
					return true;
				}
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().repeatedSubstringPattern("abab"));
	}
}
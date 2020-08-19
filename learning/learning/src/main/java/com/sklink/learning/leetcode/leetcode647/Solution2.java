package com.sklink.learning.leetcode.leetcode647;

class Solution2 {
	public int countSubstrings(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			int len = 0;
			while (true) {
				int begin = i -len;
				int end = i + len;
				if (begin < 0 || end >= s.length() || s.charAt(begin) != s.charAt(end)) {
					break;
				}
				res++;
				len++;
			}
			if (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
				len = 0;
				while (true) {
					int begin = i -len;
					int end = i + 1 + len;
					if (begin < 0 || end >= s.length() || s.charAt(begin) != s.charAt(end)) {
						break;
					}
					res++;
					len++;
				}
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution2().countSubstrings("aaa"));
	}
}
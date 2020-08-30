package com.sklink.learning.leetcode.leetcode557;

public class Solution {
	public String reverseWords(String s) {
		StringBuilder builder = new StringBuilder();
		int fast = 0;
		int slow = 0;
		while (fast < s.length()) {
			if (s.charAt(fast) == ' ') {
				for (int i = fast - 1; i >= slow; i--) {
					builder.append(s.charAt(i));
				}
				builder.append(' ');
				fast++;
				slow = fast;
			} else {
				fast++;
			}
		}
		for (int i = fast - 1; i >= slow; i--) {
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		String res = new Solution().reverseWords("Let's take LeetCode contest");
		System.out.println(res);
	}
}

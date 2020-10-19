package com.sklink.learning.leetcode.leetcode844;

import java.util.Stack;

class Solution {
	public boolean backspaceCompare(String S, String T) {

		Stack<Character> s = new Stack<>();
		for(int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#') {
				if (!s.isEmpty()) {
					s.pop();
				}
			}else {
				s.push(S.charAt(i));
			}
		}
		
		Stack<Character> t = new Stack<>();
		for(int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '#') {
				if (!t.isEmpty()) {
					t.pop();
				}
			}else {
				t.push(T.charAt(i));
			}
		}
		if (s.size() != t.size()) {
			return false;
		}
		while(!s.isEmpty()) {
			if (s.pop() != t.pop()) {
				return false;
			}
		}
		return true;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		// int[] arr = { 2, 1, 5, 6, 2, 3 };
		String S = "ab#c";
		String T = "ad#c";
		System.out.println(solution.backspaceCompare(S, T));
	}
}
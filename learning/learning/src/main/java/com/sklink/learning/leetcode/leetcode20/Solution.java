package com.sklink.learning.leetcode.leetcode20;

import java.util.Stack;

class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			}else {
				if (stack.isEmpty()) {
					return false;
				}
				char ch2 = stack.pop();
				if (!((ch == ')' && ch2 == '(') || (ch == ']' && ch2 == '[') || (ch == '}' && ch2 == '{'))) {
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isValid("]"));
	}
}
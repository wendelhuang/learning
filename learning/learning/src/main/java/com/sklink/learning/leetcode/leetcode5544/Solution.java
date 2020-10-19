package com.sklink.learning.leetcode.leetcode5544;

import java.util.Stack;
import java.util.TreeSet;

public class Solution {
	public String findLexSmallestString(String s, int a, int b) {
		TreeSet<String> treeSet = new TreeSet<>();
		Stack<String> stack = new Stack<>();
		stack.push(s);
		while (!stack.isEmpty()) {
			String str = stack.pop();
			if (!treeSet.contains(str)) {
				treeSet.add(str);
			}
			String aa = A(str, a);
			String bb = B(str, b);
			if (!treeSet.contains(aa)) {
				stack.push(aa);
				treeSet.add(aa);
			}
			if (!treeSet.contains(bb)) {
				stack.push(bb);
				treeSet.add(bb);
			}
		}
		return treeSet.pollFirst();
    }
	
	public String A(String s, int a) {
		StringBuffer trans = new StringBuffer(s);
		for(int i = 0; i < trans.length(); i++) {
			if ((i&1) == 1) {
				int tmp = trans.charAt(i)-'0';
				tmp = (tmp+a)%10;
				trans.setCharAt(i, (char)(tmp+'0'));
			}
		}
		return trans.toString();
	}
	
	public String B(String s, int b) {
		StringBuffer trans = new StringBuffer();
		trans.append(s.substring(s.length()-b));
		trans.append(s.substring(0, s.length()-b));
		return trans.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("5525".substring("5525".length()-1));
		System.out.println("5525".substring(0, "5525".length()-1+1));
		Solution solution = new Solution();
		String s = "5525";
		int a = 9;
		int b = 2;
		System.out.println(solution.findLexSmallestString(s, a, b));
	}
}

package com.sklink.learning.leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<String> res = new ArrayList<>();
	
	public List<String> generateParenthesis(int n) {
		dfs("", n, n);
		return res;
    }
	
	public void dfs(String s, int left, int right) {
		if (left < 0 || right < 0) {
			return;
		}
		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}
		if (left == right) {
			dfs(s+ "(", left-1, right);
		}
		if (left < right) {
			dfs(s + ")", left, right-1);
			dfs(s + "(", left-1, right);
		}
	}
	
	public static void main(String[] args) {
		List<String> res = new Solution().generateParenthesis(3);
		res.stream().forEach(System.out::println);
	}
}
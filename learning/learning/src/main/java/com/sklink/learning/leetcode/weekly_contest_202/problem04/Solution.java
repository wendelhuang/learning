package com.sklink.learning.leetcode.weekly_contest_202.problem04;

import java.util.HashMap;

class Solution {

	public HashMap<Integer, Integer> map = new HashMap<>();

	public int minDays(int n) {
		return dfs(n);
	}

	public int dfs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int res = Math.min(dfs(n / 2) + n % 2 + 1, dfs(n / 3) + n % 3 + 1);
		map.put(n, res);
		return res;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minDays(673));

	}
}
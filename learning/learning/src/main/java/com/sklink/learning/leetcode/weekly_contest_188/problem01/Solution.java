package com.sklink.learning.leetcode.weekly_contest_188.problem01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
	public List<String> buildArray(int[] target, int n) {
		HashMap<Integer, Boolean> left = new HashMap<>();
		for (int v : target) {
			left.put(v, true);
		}
		List<String> result = new ArrayList<>();
		int index = 0;
		for (int i = 1; i <= n; i++) {
			if (left.get(i) == null) {
				result.add("Push");
				result.add("Pop");
			} else {
				result.add("Push");
				index++;
			}
			if (index == target.length) {
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = { 1, 3 };
		System.out.println(solution.buildArray(arr, 3));
	}
}
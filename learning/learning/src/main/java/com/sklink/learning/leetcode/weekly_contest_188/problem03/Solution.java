package com.sklink.learning.leetcode.weekly_contest_188.problem03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	private int count = 0;

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		int has = 0;
		Map<Integer, Boolean> hashas = new HashMap<Integer, Boolean>();
		Map<Integer, List<Integer>> tree = new HashMap<>();
		for (int i = 0; i < hasApple.size(); i++) {
			hashas.put(i, hasApple.get(i));
			if (hasApple.get(i)) {
				has++;
			}
		}
		if (has == 0) {
			return 0;
		}
		for (int[] arr : edges) {
			int from = arr[0];
			int to = arr[1];
			if (tree.get(from) == null) {
				tree.put(from, new ArrayList<>());
			}
			tree.get(from).add(to);
		}
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < n; i++) {
			visited.put(i, false);
		}
		dfs(0, visited, tree, hashas);
		return (count - 1) * 2;
	}

	public boolean dfs(int index, Map<Integer, Boolean> visited, Map<Integer, List<Integer>> tree,
			Map<Integer, Boolean> hashas) {
		List<Integer> to = tree.get(index);
		visited.put(index, true);
		boolean res = false;
		if (to != null && to.size() > 0) {
			for (int v : to) {
				if (!visited.get(v)) {
					if (dfs(v, visited, tree, hashas)) {
						res = true;
					}
				}
			}
		}
		if (res) {
			count++;
			return true;
		} else if (hashas.get(index) != null && hashas.get(index)) {
			count++;
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, {
		// 2, 6 } };
		// List<Boolean> hasApple = Arrays.asList(false, false, true, false,
		// true, true, false);
		// int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, {
		// 2, 6 } };
		// List<Boolean> hasApple = Arrays.asList(false, false, true, false,
		// false, true, false);
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple = Arrays.asList(false, false, false, false, false, false, false);
		Solution solution = new Solution();
		System.out.println(solution.minTime(7, edges, hasApple));
		;

	}
}
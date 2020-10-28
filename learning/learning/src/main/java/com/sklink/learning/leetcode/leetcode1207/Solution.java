package com.sklink.learning.leetcode.leetcode1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public boolean uniqueOccurrences(int[] arr) {
		return unique(countNumber(arr));
	}

	public Map<Integer, Integer> countNumber(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		return map;
	}

	public boolean unique(Map<Integer, Integer> map) {
		Set<Integer> set = new HashSet();
		for (Integer num : map.keySet()) {
			if (set.contains(map.get(num))) {
				return false;
			}
			set.add(map.get(num));
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
		System.out.println(solution.uniqueOccurrences(arr));
	}
}

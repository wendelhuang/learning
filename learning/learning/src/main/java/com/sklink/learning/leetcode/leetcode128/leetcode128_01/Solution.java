package com.sklink.learning.leetcode.leetcode128.leetcode128_01;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int v : nums) {
			map.put(v, 1);
		}
		int max = -1;
		for (int v : nums) {
			int t = 0;
			int vv = v;
			while (map.get(vv) != null && map.get(vv) == 1) {
				map.put(vv, -1);
				t++;
				vv--;
			}
			vv = v + 1;
			while (map.get(vv) != null && map.get(vv) == 1) {
				map.put(vv, -1);
				t++;
				vv++;
			}
			if (max < t) {
				max = t;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int res = solution.longestConsecutive(nums);
		System.out.println(res);
	}
}
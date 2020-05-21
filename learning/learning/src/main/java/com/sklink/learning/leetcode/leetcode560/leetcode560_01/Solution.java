package com.sklink.learning.leetcode.leetcode560.leetcode560_01;

import java.util.HashMap;

class Solution {
	
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		int pre = 0;
		HashMap<Integer, Integer> mp = new HashMap<>();
		mp.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			pre += nums[i];
			if (mp.containsKey(pre - k)) {
				count += mp.get(pre - k);
			}
			mp.put(pre, mp.getOrDefault(pre, 0) + 1);
		}
		return count;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-1, -1, 1};
		int k = 0;
		System.out.println(solution.subarraySum(nums, k));
	}
}
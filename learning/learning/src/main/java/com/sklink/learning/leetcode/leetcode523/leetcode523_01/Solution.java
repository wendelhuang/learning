package com.sklink.learning.leetcode.leetcode523.leetcode523_01;

import java.util.HashMap;

class Solution {
	
	public boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
		HashMap<Integer, Integer> mp = new HashMap<>();
		mp.put(0, -1);
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) {
				sum = sum%k;
			}
			if (mp.containsKey(sum)) {
				if (i - mp.get(sum) > 1) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {23, 2, 4, 6, 7};
		int k = 6;
		System.out.println(solution.checkSubarraySum(nums, k));
	}
}
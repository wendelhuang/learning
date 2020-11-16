package com.sklink.learning.leetcode.leetcode1658;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int minOperations(int[] nums, int x) {
		Map<Integer, Integer> prefixMap = new HashMap<Integer, Integer>();
		int res = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefixMap.put(sum, i+1);
			if (sum == x) {
				res = Math.min(res, i+1);
			}
		}
		sum = 0;
		for(int j=nums.length-1; j >= 0; j--) {
			sum+=nums[j];
			if (sum == x) {
				res = Math.min(res, nums.length-1-j+1);
			}
			if (prefixMap.containsKey(x - sum)) {
				int len = nums.length-1-j+1;
				if (len + prefixMap.get(x-sum) > nums.length) {
					continue;
				}
				res = Math.min(res, prefixMap.get(x - sum) + len);
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {3,2,20,1,1,3};
		int x = 10;
		System.out.println(solution.minOperations(nums, x));
	}
}

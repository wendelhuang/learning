package com.sklink.learning.leetcode.leetcode152;

class Solution {
    public int maxProduct(int[] nums) {
    	int min = nums[0];
    	int max = nums[0];
    	int res = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		int mx = max;
    		int mn = min;
    		max = Math.max(mx*nums[i], Math.max(mn*nums[i], nums[i]));
    		min = Math.min(mn*nums[i], Math.min(mx*nums[i], nums[i]));
    		res = Math.max(max, res);
    	}
    	return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {2, 3, -2, 4};
		System.out.println(solution.maxProduct(arr));
	}
}
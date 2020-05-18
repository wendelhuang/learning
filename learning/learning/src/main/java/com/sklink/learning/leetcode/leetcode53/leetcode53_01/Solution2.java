package com.sklink.learning.leetcode.leetcode53.leetcode53_01;

class Solution {
    public int maxSubArray(int[] nums) {
    	int pre = 0;
    	int res = nums[0];
    	for(int i = 0; i < nums.length; i++) {
    		pre = Math.max(pre+ nums[i], nums[i]);
    		res = Math.max(res, pre);
    	}
    	return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(arr));
	}
}
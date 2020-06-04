package com.sklink.learning.leetcode.leetcode238;

class Solution {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] prefix = new int[len];
		int[] suffix = new int[len];
		int[] res = new int[len];
		
		for(int i = 0; i < len; i++) {
			if (i == 0) {
				prefix[i] = nums[i];
				suffix[len-i-1] = nums[len-i-1];
			}else {
				prefix[i] = prefix[i-1]*nums[i];
				suffix[len-i-1] = suffix[len-i] * nums[len-i-1];
			}
		}
		for(int i= 0; i < len; i++) {
			int p = i-1>=0 ? prefix[i-1] : 1;
			int s = i+1<=len-1 ? suffix[i+1] : 1;
			res[i] = p*s;
		}
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3,4};
		int[] res = solution.productExceptSelf(nums);
		for(int i = 0; i < res.length; i++) {
			System.out.println(String.format("[%d]=%d", i, res[i]));
		}
		System.out.println(solution.productExceptSelf(nums));
	}

}
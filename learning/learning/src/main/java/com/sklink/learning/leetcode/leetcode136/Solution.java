package com.sklink.learning.leetcode.leetcode136;

class Solution {
	public int singleNumber(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			nums[0] = nums[0] ^ nums[i];
		}
		return nums[0];
    }

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3, 2};
		Solution solution = new Solution();
		System.out.println(solution.singleNumber(arr));
	}
}
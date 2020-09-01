package com.sklink.learning.leetcode.leetcode35;

class Solution {
	public int searchInsert(int[] nums, int target) {
		int index = 0;
		while(index < nums.length && nums[index] < target) {
			index++;
		}
		return index;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,6};
		int target = 0;
		System.out.println(new Solution().searchInsert(nums, target));
	}
}
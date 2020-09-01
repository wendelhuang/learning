package com.sklink.learning.leetcode.leetcode486;

import java.util.Arrays;

public class Solution {
	public boolean PredictTheWinner(int[] nums) {
		return dfs(nums, 0, nums.length-1) >= 0;
    }
	
	public int dfs(int[] nums, int begin, int end) {
		//System.out.println("begin, end" + Arrays.toString(new int[] {begin, end}));
		if (begin == end) {
			return nums[begin];
		}
		if (end == begin+1) {
			return Math.max(nums[begin], nums[end]) - Math.min(nums[begin], nums[end]);
		}
		int v1 = dfs(nums, begin+1, end);
		int v2 = dfs(nums, begin, end-1);
		//System.out.println("begin, end, v1, v2: " + Arrays.toString(new int[] {begin, end, v1, v2}));
		return Math.max(nums[begin] - v1, nums[end] - v2);
	}
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {1,5,233,7};
		System.out.println(solution.PredictTheWinner(nums));
	}
}

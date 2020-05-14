package com.sklink.learning.algorithm.leetcode.leetcode136.leetcode136_001;

class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
        	nums[i+1] = nums[i] ^ nums[i+1];
        }
        return nums[nums.length-1];
    }
}
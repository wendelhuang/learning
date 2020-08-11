package com.sklink.learning.leetcode.offer51;

import java.util.Arrays;

public class Solution {
	
	public int reversePairs(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int res = mergeSort(nums, 0, nums.length-1, new int[nums.length]);
		//System.out.println(Arrays.toString(nums));
		return res;
    }
	
	public int mergeSort(int[] nums, int left, int right, int[] target) {
		//System.out.println("left, right" + Arrays.toString(new int[] {left, right}));
		if (left == right) {
			return 0;
		}
		int mid = (left+right)/2;
		int leftCount = mergeSort(nums, left, mid, target);
		int rightCount = mergeSort(nums, mid+1, right, target);
		
		int tLeft = left;
		int tRight = mid+1;
		int loc = left;
		int count = 0;
		//System.out.println("tLeft, tRight, loc" + Arrays.toString(new int[] {tLeft, tRight, loc}));
		while(tLeft <= mid && tRight <= right) {
			if (nums[tLeft] <= nums[tRight]) {
				target[loc++] = nums[tLeft++];
			}else {
				count += ((mid-tLeft)+1);
				target[loc++] = nums[tRight++];
			}
		}
		while(tLeft <= mid) {
			target[loc++] = nums[tLeft++];
		}
		while(tRight <= right) {
			target[loc++] = nums[tRight++];
		}
		//System.out.println(Arrays.toString(target));
		for(int i = left; i <= right; i++) {
			nums[i] = target[i];
		}
		///System.out.println("leftCount, rightCount, count" + Arrays.toString(new int[] {leftCount, rightCount, count}));
		return leftCount + rightCount + count;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {7,5,6,4};
		System.out.println(new Solution().reversePairs(nums));
	}
}

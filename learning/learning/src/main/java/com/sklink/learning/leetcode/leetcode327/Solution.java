package com.sklink.learning.leetcode.leetcode327;

import java.util.Arrays;

class Solution {
	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] prefix = new long[nums.length+1];
		long sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefix[i+1] = sum;
		}
		long[] target = new long[nums.length+1];
		
		return mergeSort(prefix, target, 0, nums.length, lower, upper);
    }
	
	public int mergeSort(long[] nums, long[] target, int begin, int end, int lower, int upper) {
		if (begin == end) {
			return 0;
		}
		int mid = (begin+end)/2;
		int m1 = mergeSort(nums, target, begin, mid, lower, upper);
		int m2 = mergeSort(nums, target, mid+1, end, lower, upper);

		int res = 0;
		int left = mid+1, right = mid+1;
		int index = begin;
		while(index <= mid) {
			while(left <= end && nums[left] - nums[index] < lower) {
				left++;
			}
			while(right <= end && nums[right] - nums[index] <= upper) {
				right++;
			}
			res += (right-left);
			index++;
		}
		
		int l1 = begin;
		int l2 = mid+1;
		int loc = begin;
		while(l1 <= mid && l2 <= end) {
			if (nums[l1] <= nums[l2]) {
				target[loc++] = nums[l1++];
			}else {
				target[loc++] = nums[l2++];
			}
		}
		while(l1 <= mid) {
			target[loc++] = nums[l1++];
		}
		while(l2 <= end) {
			target[loc++] = nums[l2++];
		}
		for(int i = begin; i <= end; i++) {
			nums[i] = target[i];
		}
		return m1 + m2 + res;
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {-2, 5, -1};
		int lower = -2;
		int upper = 2;
		int res = solution.countRangeSum(nums, lower, upper);
		System.out.println(res);
	}
}
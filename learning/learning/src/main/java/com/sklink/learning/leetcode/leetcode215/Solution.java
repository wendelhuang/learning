package com.sklink.learning.leetcode.leetcode215;

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		return find(nums, k, 0, nums.length - 1);
	}

	public int find(int[] nums, int k, int begin, int end) {
		int loc = partition(nums, begin, end);
		if (loc == k - 1) {
			return nums[loc];
		} else if (loc > k - 1) {
			return find(nums, k, begin, loc - 1);
		} else {
			return find(nums, k, loc + 1, end);
		}
	}

	public int partition(int[] nums, int begin, int end) {
		int pivot = nums[begin];
		while (begin < end) {
			while (begin < end && nums[end] < pivot) {
				end--;
			}
			nums[begin] = nums[end];
			while (begin < end && nums[begin] >= pivot) {
				begin++;
			}
			nums[end] = nums[begin];
		}
		nums[begin] = pivot;
		return begin;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		System.out.println(solution.findKthLargest(nums, k));
	}
}

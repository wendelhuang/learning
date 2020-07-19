package com.sklink.learning.leetcode.leetcode167;

import java.util.Arrays;

class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int begin = 0, end = numbers.length - 1;
		while (begin < end) {
			if (numbers[begin] + numbers[end] == target) {
				return new int[] { begin + 1, end + 1 };
			} else if (numbers[begin] + numbers[end] > target) {
				end--;
			} else {
				begin++;
			}
		}
		return new int[] { 1, 1 };
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = new int[] { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(Arrays.toString(solution.twoSum(arr, target)));
	}
}
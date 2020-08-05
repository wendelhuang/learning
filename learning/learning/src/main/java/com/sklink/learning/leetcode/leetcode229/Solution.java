package com.sklink.learning.leetcode.leetcode229;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int num1 = 0;
		int num2 = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1) {
				cnt1++;
				continue;
			}
			if (nums[i] == num2) {
				cnt2++;
				continue;
			}
			if (cnt1 == 0) {
				num1 = nums[i];
				cnt1 = 1;
				continue;
			}
			if (cnt2 == 0) {
				num2 = nums[i];
				cnt2 = 1;
				continue;
			}
			cnt1--;
			cnt2--;
		}

		cnt1 = 0;
		cnt2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1) {
				cnt1++;
			} else if (nums[i] == num2) {
				cnt2++;
			}
		}
		if (cnt1 > nums.length / 3) {
			res.add(num1);
		}
		if (cnt2 > nums.length / 3) {
			res.add(num2);
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> res = new Solution().majorityElement(new int[] { 1, 2 });
		res.stream().forEach(System.out::println);
	}
}
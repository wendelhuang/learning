package com.sklink.learning.leetcode.leetcode128.leetcode128_01;

import org.junit.Test;

class TestSolution {

	Solution solution = new Solution();

	@Test
	public void test() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int res = solution.longestConsecutive(nums);
		System.out.println(res);
	}
}
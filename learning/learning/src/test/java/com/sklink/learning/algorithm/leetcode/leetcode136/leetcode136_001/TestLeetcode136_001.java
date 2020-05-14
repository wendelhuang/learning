package com.sklink.learning.algorithm.leetcode.leetcode136.leetcode136_001;

import org.junit.Test;

public class TestLeetcode136_001 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int[] arr = {2, 2, 1};
		int[] brr = {4, 1, 2, 1, 2};
		System.out.println(solution.singleNumber(arr));
		System.out.println(solution.singleNumber(brr));
	}
}

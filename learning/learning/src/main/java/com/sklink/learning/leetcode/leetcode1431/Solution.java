package com.sklink.learning.leetcode.leetcode1431;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < candies.length; i++) {
			max = Math.max(candies[i], max);
		}
		List<Boolean> res = new ArrayList<Boolean>();
		for(int i = 0; i < candies.length; i++) {
			res.add(candies[i] >= max-extraCandies);
		}
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {2,3,5,1,3};
		int ext = 3;
		System.out.println(solution.kidsWithCandies(arr, ext));
	}
}
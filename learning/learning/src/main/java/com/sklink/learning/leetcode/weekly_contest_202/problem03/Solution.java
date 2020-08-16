package com.sklink.learning.leetcode.weekly_contest_202.problem03;

import java.util.Arrays;

class Solution {
	public int maxDistance(int[] position, int m) {
		Arrays.sort(position);
		int left = 1;
		int right = position[position.length - 1] - position[0];
		int res = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(position, m, mid)) {
				left = mid + 1;
				res = mid;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}

	public boolean check(int[] position, int m, int step) {
		int lastVal = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < position.length; i++) {
			if (lastVal == Integer.MIN_VALUE || position[i] - lastVal >= step) {
				count++;
				lastVal = position[i];
			}
		}
		return count >= m;
	}

	public static void main(String[] args) {
		int[] position = new int[] { 5, 4, 3, 2, 1, 1000000000 };
		Solution solution = new Solution();
		System.out.println(solution.maxDistance(position, 2));
		;

	}
}
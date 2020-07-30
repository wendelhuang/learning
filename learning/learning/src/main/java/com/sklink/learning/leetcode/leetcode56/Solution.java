package com.sklink.learning.leetcode.leetcode56;

import java.util.Arrays;

class Solution {
	public int[][] merge(int[][] intervals) {
		int[][] res = new int[intervals.length][2];
		int index = 0;
		
		Arrays.sort(intervals, (v1, v2) -> v1[0]-v2[0]);
		
		for(int i = 0; i < intervals.length; i++) {
			if (index == 0 || res[index-1][1] < intervals[i][0]) {
				if (index > 1) {
					System.out.println(res[index-1][0]);
				}
				res[index] = new int[] {intervals[i][0], intervals[i][1]};
				index++;
			}else {
				res[index-1][1] = Math.max(res[index-1][1], intervals[i][1]);
			}
		}
		return Arrays.copyOf(res, index);
    }
	
	public static void main(String[] args) {
		int[][] intervals = new int[][] {
			new int[] {1,4},
			new int[] {2,3}
		};
		System.out.println(Arrays.toString(new Solution().merge(intervals)));
	}
}
package com.sklink.learning.leetcode.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] == o2[1] ? 0 : (o1[1] < o2[1] ? -1 : 1);
			}
			
		});
		
		int res = 1;
		int currRight = points[0][1];
		for(int i = 1; i < points.length; i++) {
			if (points[i][0] > currRight) {
				res++;
				currRight = points[i][1];
			}
		}
		return res;
    }
	
	/*
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] points = new int[][] {
			new int[] {-2147483646,-2147483645},
			new int[] {2147483646,2147483647}
		};
		int res = solution.findMinArrowShots(points);
		System.out.println(res);
	}
	*/
}

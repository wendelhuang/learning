package com.sklink.learning.leetcode.leetcode5555;

import java.util.Stack;
import java.util.TreeSet;

public class Solution {
	public int countVowelStrings(int n) {
		int[][] arr = new int[55][6];
		arr[1][1] = 5;
		arr[1][2] = 4;
		arr[1][3] = 3;
		arr[1][4] = 2;
		arr[1][5] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= 5; j++) {
				for(int k = j; k <= 5; k++) {
					//System.out.println(Arrays.toString(new int[] {i, j, k, arr[i][j], arr[i-1][k]}));
					arr[i][j] += arr[i-1][k];
				}
			}
		}
		return arr[n][1];
    }
}

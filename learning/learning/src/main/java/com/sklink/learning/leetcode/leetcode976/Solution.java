package com.sklink.learning.leetcode.leetcode976;

import java.util.Arrays;

class Solution {
	public int largestPerimeter(int[] A) {
		Arrays.sort(A);
		
		for(int i = A.length-1; i >= 2; i--) {
			if (A[i-1] + A[i-2] > A[i]) {
				return A[i-1] + A[i-2] + A[i];
			}
		}
		
		return 0;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {3,2,3,4};
		int res = solution.largestPerimeter(A);
		System.out.println(res);
	}
}

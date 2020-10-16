package com.sklink.learning.leetcode.leetcode977;

import java.util.Arrays;

class Solution {
	public int[] sortedSquares(int[] A) {
		int begin = 0, end = A.length-1;
		int[] res = new int[A.length];
		int index = A.length-1;
		while(begin <= end) {
			if (Math.abs(A[begin]) <= Math.abs(A[end])) {
				res[index--] = A[end]*A[end];
				end--;
			}else {
				res[index--] = A[begin]*A[begin];
				begin++;
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = new int[] {-7, -3, 2, 3, 11};
		int[] res = solution.sortedSquares(A);
		System.out.println(Arrays.toString(res));
	}
}
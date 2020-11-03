package com.sklink.learning.leetcode.leetcode941;

class Solution {
	public boolean validMountainArray(int[] A) {
		if (A.length < 3) {
			return false;
		}
		int change = 0;
		int lastDelta = 0;
		for(int i = 1; i < A.length; i++) {
			int delta = A[i] - A[i-1];
			if (delta == 0) {
				return false;
			}
			if (i == 1) {
				lastDelta = delta;
				if (delta<0) {
					return false;
				}
				continue;
			}
			if (delta<0 && lastDelta>0) {
				change=1;
				continue;
			}
			if (!(change == 0 && delta>0 || change== 1 && delta<0)) {
				return false;
			}
		}
		return change==1;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = new int[] {0,1,2,3,4,5,6,7,8,9};
		System.out.println(solution.validMountainArray(A));
	}
}
package com.sklink.learning.leetcode.leetcode922;

import java.util.Arrays;

class Solution {
	public int[] sortArrayByParityII(int[] A) {
		int begin = 0, end = A.length-1;
		while(begin < end) {
			while(begin < end) {
				int m = A[begin] & 1;
				if (m == 0) {
					break;
				}
				begin++;
			}
			while(begin < end) {
				int m = A[end] & 1;
				if (m == 1) {
					break;
				}
				end--;
			}
			if (begin < end) {
				int t = A[begin];
				A[begin] = A[end];
				A[end] = t;
				begin++;
				end--;
			}
		}
		//System.out.println(Arrays.toString(A));
		begin = 0; end = A.length-1;
		while(begin < end) {
			int t = A[begin];
			A[begin] = A[end];
			A[end] = t;
			begin+=2;
			end-=2;
		}
		//System.out.println(Arrays.toString(A));
		return A;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = new int[] {4,2,5,7};
		int[] res = solution.sortArrayByParityII(A);
	}
}
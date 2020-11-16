package com.sklink.learning.leetcode.leetcode1652;

import java.util.Arrays;

public class Solution {
	public int[] decrypt(int[] code, int k) {
		int[] res = new int[code.length];
		for(int i = 0; i < res.length; i++) {
			if (k == 0) {
				res[i] = 0;
			}else if (k > 0) {
				for(int j = 1; j <= k; j++) {
					res[i] += code[(i+j)%code.length];
				}
			}else {
				for(int j = 1; j <= -k; j++) {
					res[i] += code[(code.length + (i-j)%code.length)%code.length];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] code = new int[] {2,4,9,3};
		int k = -2;
		int[] res = solution.decrypt(code, k);
		System.out.println(Arrays.toString(res));
	}
}


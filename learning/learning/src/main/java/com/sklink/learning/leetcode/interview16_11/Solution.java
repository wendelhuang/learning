package com.sklink.learning.leetcode.interview16_11;

import java.util.Arrays;

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
    	if (k == 0) {
    		return new int[0];
    	}
    	if (shorter == longer) {
    		return new int[] {shorter*k};
    	}
    	int[] res = new int[k+1];
    	for(int i = 0; i <= k; i++) {
    		res[i] = shorter*(k-i) + longer*i;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.divingBoard(1, 2, 3)));
	}
}

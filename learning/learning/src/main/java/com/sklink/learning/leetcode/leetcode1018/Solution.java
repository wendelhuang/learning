package com.sklink.learning.leetcode.leetcode1018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
    	List<Boolean> res = new ArrayList<Boolean>();
    	int prefix = 0;
    	for(int i = 0; i < A.length; i++) {
    		prefix = (prefix*2 + A[i])%5;
    		res.add(prefix == 0);
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = new int[] {0, 1, 1};
		List<Boolean> res = solution.prefixesDivBy5(A);
		System.out.println(Arrays.toString(res.toArray()));
	}
}
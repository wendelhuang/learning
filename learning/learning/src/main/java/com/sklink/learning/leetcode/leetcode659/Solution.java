package com.sklink.learning.leetcode.leetcode659;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> endNumCntMap = new HashMap<>();
		Map<Integer, Integer> numLeftCntMap = new HashMap<>();
		
		for(int n : nums) {
			numLeftCntMap.put(n, numLeftCntMap.getOrDefault(n, 0) + 1);
		}
		
		for(int n : nums) {
			//System.out.println(n);
			if (numLeftCntMap.get(n) > 0) {
				int previewEndNum = endNumCntMap.getOrDefault(n-1, 0);
				if (previewEndNum == 0) {
					int nPlusOneCnt = numLeftCntMap.getOrDefault(n+1, 0);
					int nPlusTwoCnt = numLeftCntMap.getOrDefault(n+2, 0);
					if (nPlusOneCnt < 1 || nPlusTwoCnt < 1) {
						return false;
					}
					endNumCntMap.put(n+2, endNumCntMap.getOrDefault(n+2, 0)+1);
					numLeftCntMap.put(n, numLeftCntMap.get(n)-1);
					numLeftCntMap.put(n+1, numLeftCntMap.get(n+1)-1);
					numLeftCntMap.put(n+2, numLeftCntMap.get(n+2)-1);
				}else {
					endNumCntMap.put(n-1, endNumCntMap.get(n-1)-1);
					endNumCntMap.put(n, endNumCntMap.getOrDefault(n, 0) + 1);
					numLeftCntMap.put(n, numLeftCntMap.get(n)-1);
				}
			}
		}
		return true;
    }
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = new int[] {1,2,3,4,4,5};
    	boolean res = solution.isPossible(nums);
		System.out.println(res);
	}
}
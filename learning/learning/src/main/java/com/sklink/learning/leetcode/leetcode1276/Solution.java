package com.sklink.learning.leetcode.leetcode1276;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		if (tomatoSlices == 0 && cheeseSlices == 0) {
			return new ArrayList<Integer>(Arrays.asList(0, 0));
		}
		if (tomatoSlices == 0 || cheeseSlices == 0 || (tomatoSlices & 1) == 1 || tomatoSlices/2 < cheeseSlices || tomatoSlices/2 > 2*cheeseSlices) {
			return new ArrayList<>();
		}
		return new ArrayList<>(Arrays.asList(tomatoSlices/2-cheeseSlices, 2*cheeseSlices-tomatoSlices/2));
		
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().numOfBurgers(16, 7).toArray()));
	}
}
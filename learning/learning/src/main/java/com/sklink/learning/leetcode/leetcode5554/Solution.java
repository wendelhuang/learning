package com.sklink.learning.leetcode.leetcode5554;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {
	public boolean canFormArray(int[] arr, int[][] pieces) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		for(int i = 0; i < pieces.length; i++) {
			for(int j = 0; j < pieces[i].length; j++) {
				if (!map.containsKey(pieces[i][j])) {
					return false;
				}
				if (j > 0 && map.get(pieces[i][j]) != map.get(pieces[i][j-1]) +1) {
					return false;
				}
			}
		}
		return true;
    }
}

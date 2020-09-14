package com.sklink.learning.leetcode.leetcode5512;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for(int i = 0; i < pairs.length; i++) {
			for(int j = 0; j < pairs[i].length; j++) {
				if (map.get(pairs[i][j]) == null) {
					map.put(pairs[i][j], new HashSet<>());
				}
				for(int k = 0; k < preferences[pairs[i][j]].length; k++) {
					if (preferences[pairs[i][j]][k] == pairs[i][1-j]) {
						break;
					}
					map.get(pairs[i][j]).add(preferences[pairs[i][j]][k]);
				}
			}
		}
		
		int c = 0;
		
		for(Integer k : map.keySet()) {
			for(Integer v : map.get(k)) {
				if (map.get(v).contains(k)) {
					c++;
					break;
				}
			}
		}
		return c;
		
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 4;
		int[][] preferences = new int[][] {
			new int[] {1,3,2},
			new int[] {2,3,0},
			new int[] {1,3,0},
			new int[] {0,2,1},
		};
		int[][] pairs = new int[][] {
			new int[] {1,3},
			new int[] {0,2},
		};
		System.out.println(solution.unhappyFriends(n, preferences, pairs));
	}
}
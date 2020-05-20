package com.sklink.learning.leetcode.leetcode1371;

import java.util.HashMap;
import java.util.Map;


class Solution_TLE {
	public int findTheLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 0);
		map.put('e', 1);
		map.put('i', 2);
		map.put('o', 3);
		map.put('u', 4);
		
		int[][] prefix = new int[s.length()+1][5];
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 0; j < 5; j++) {
				prefix[i][j] = prefix[i-1][j];
			}
			char ch = s.charAt(i-1);
			if (map.containsKey(ch)) {
				prefix[i][map.get(ch)] = i == 0 ? 1 : prefix[i-1][map.get(ch)] + 1;
			}
		}
		
		/*
		for(int i = 0; i <= s.length(); i++) {
			System.out.print(i + ": ");
			for(int j = 0; j < 5; j++) {
				System.out.print(prefix[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		int maxLength = 0;
		for(int begin = 0; begin < s.length(); begin++) {
			for(int end = begin+1; end <= s.length(); end++) {
				boolean match = true;
				int odd = 1;
				for(int i = 0; i < 5; i++) {
					if ((prefix[end][i] & 1) != 0) {
						odd = 0;
					}
					if (((prefix[end][i] - prefix[begin][i]) & 1) != 0) {
						match = false;
						break;
					}
				}
				if (begin == 0) {
					odd = 0;
				}
				if (match && maxLength < end-begin + odd) {
					//System.out.println(String.format("begin: %d, end: %d, maxLength: %d", begin, end, maxLength));
					maxLength = end - begin + odd;
				}
			}
		}
		return maxLength;
    }

	public static void main(String[] args) {
		Solution_TLE solution = new Solution_TLE();
		String s = "eleetminicoworoep";
		solution.findTheLongestSubstring(s);
	}
}
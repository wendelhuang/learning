package com.sklink.learning.leetcode.leetcode1371;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int findTheLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 0);
		map.put('e', 1);
		map.put('i', 2);
		map.put('o', 3);
		map.put('u', 4);
		
		int[] hash = new int[1<<5];
		hash[0] = 0;
		for(int i = 1; i < hash.length; i++) {
			hash[i] = -1;
		}
		int status = 0;
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				status ^= 1 << map.get(ch);
			}
			if (hash[status] == -1) {
				hash[status] = i+1;
			}else {
				res = Math.max(res, i+1- hash[status]);
			}
		}

		return res;
    }

	public static void main(String[] args) {
		Solution_TLE solution = new Solution_TLE();
		String s = "eleetminicoworoep";
		System.out.println(solution.findTheLongestSubstring(s));
	}
}
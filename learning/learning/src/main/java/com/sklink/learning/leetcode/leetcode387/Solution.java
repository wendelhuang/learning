package com.sklink.learning.leetcode.leetcode387;

import java.util.Arrays;

class Solution {
	public int firstUniqChar(String s) {
		int[] map = new int[26];
		Arrays.fill(map, -1);
		
		for(int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (map[index] == -1) {
				map[index] = i;
			}else {
				if (map[index] >= 0) {
					map[index] = -2;
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < map.length; i++) {
			if (map[i] >= 0 && map[i] < result) {
				result = map[i];
			}
		}
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		return result;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "loveleetcode";
		int result = solution.firstUniqChar(s);
		System.out.println(result);
	}
}
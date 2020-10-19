package com.sklink.learning.leetcode.leetcode5543;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int maxLengthBetweenEqualCharacters(String s) {
		Map<Character, Integer> map = new HashMap<>(128);
		int max = -1;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, i);
			}else {
				max = Math.max(max, i - map.get(ch)-1);
			}
		}
		return max;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "cabbac";
		System.out.println(solution.maxLengthBetweenEqualCharacters(s));
	}
}

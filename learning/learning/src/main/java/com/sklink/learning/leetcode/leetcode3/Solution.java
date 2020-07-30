package com.sklink.learning.leetcode.leetcode3;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int res = 0;
		int begin = 0;
		int end = 0;
		while(begin < s.length() && end < s.length()) {
			while(end < s.length() && !map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), end);
				end++;
			}
			map.remove(s.charAt(begin));
			res = Math.max(res, end-begin);

			begin++;
		}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
	}
}
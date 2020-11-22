package com.sklink.learning.leetcode.leetcode242;

class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() == t.length()) {
			int[] cnt1 = new int[26];
			int[] cnt2 = new int[26];
			
			for(int i = 0; i < s.length(); i++) {
				cnt1[s.charAt(i) - 'a']++;
			}
			
			for(int i = 0; i < t.length(); i++) {
				cnt2[t.charAt(i) - 'a']++;
			}
			
			for(int i = 0; i < 26; i++) {
				if (cnt1[i] != cnt2[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "anagram";
		String t = "nagaram";
		boolean res = solution.isAnagram(s, t);
		System.out.println(res);
	}

}
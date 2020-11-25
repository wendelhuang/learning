package com.sklink.learning.leetcode.leetcode1370;

class Solution {
	public String sortString(String s) {
		int[] alphabet = new int[26];
		for(int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}
		char[] crr = new char[s.length()];
		int index = 0;
		while(index < s.length()) {
			for(int i = 0; i < 26; i++) {
				if (alphabet[i] > 0) {
					crr[index++] = (char)('a' + i);
					alphabet[i]--;
				}
			}
			for(int i = 25; i >= 0; i--) {
				if (alphabet[i] > 0) {
					crr[index++] = (char)('a' + i);
					alphabet[i]--;
				}
			}
		}
		return new String(crr);
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "aaaabbbbcccc";
		String res = solution.sortString(s);
		System.out.println(res);
	}
}
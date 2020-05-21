package com.sklink.learning.leetcode.leetcode5;

class Solution {
    public String longestPalindrome(String s) {
    	String res = "";
    	for(int i = 0; i < s.length(); i++) {
    		int len1 = expand(s, i, i);
    		int len2 = len1;
    		if (i < s.length() -1) {
    			len2 = expand(s, i, i+1);
    		}
    		int len = Math.max(len1, len2);
    		if (len > res.length()) {
    			res = s.substring(i - (len-1)/2, i-(len-1)/2+len);
    		}
    	}
    	return res;
    }
    
    public int expand(String s, int begin, int end) {
    	while(s.charAt(begin) == s.charAt(end)) {
    		begin--;
    		end++;
    		if (begin < 0 || end > s.length()-1) {
    			break;
    		}
    	}
    	return end - 1 - begin - 1 + 1;
    }
    public static void main(String[] args) {
		String s = "cbbd";
		Solution solution = new Solution();
		System.out.println(solution.longestPalindrome(s));
	}
}
package com.sklink.learning.leetcode.leetcode5;

class Solution1 {
    public String longestPalindrome(String s) {
    	int n = s.length();
    	int[][] dp = new int[n][n];
    	String res = "";
    	for(int length = 0; length < s.length(); length++) {
    		for(int i = 0; i < s.length() - length; i++) {
    			int j = i + length;
    			if (length == 0) {
    				dp[i][j] = 1;
    			}else if (length == 1) {
    				dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
    			}else {
        			dp[i][j] = (dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)) ? 1 : 0;
    			}
    			
    			res = (dp[i][j] == 1 && (j - i + 1) > res.length()) ? s.substring(i, j+1) : res;
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		String s = "cbbd";
		Solution solution = new Solution();
		System.out.println(solution.longestPalindrome(s));
	}
}
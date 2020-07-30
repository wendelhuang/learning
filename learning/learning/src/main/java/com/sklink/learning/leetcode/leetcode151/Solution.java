package com.sklink.learning.leetcode.leetcode151;

class Solution {
	public String reverseWords(String s) {
		return dfs("", s); 
    }
	
	public String dfs(String res, String source) {
		if (source.length() == 0) {
			return res;
		}
		while(source.charAt(0) == ' ') {
			return dfs(res, source.substring(1));
		}
		int i;
		for(i = 0; i < source.length(); i++) {
			if (source.charAt(i) == ' ') {
				break;
			}
		}
		if (i == source.length()) {
			return dfs(source + (res.equals("") ? "" : " ") + res, "");
		}else {
			return dfs(source.substring(0, i) + (res.equals("") ? "" : " ") + res , source.substring(i+1));
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverseWords("a good   example"));
	}
}
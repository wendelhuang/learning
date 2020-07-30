package com.sklink.learning.leetcode.leetcode93;

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<String> res = new ArrayList<String>();
	
	public List<String> restoreIpAddresses(String s) {
        dfs(s, "", 0, 3);
        return res;
    }
	
	public void dfs(String s, String cur, int pos, int left) {
		// 已经插入3个.
		if (left == 0) {
			String suffix = s.substring(pos);
			if (suffix.length() > 0 && suffix.length() <= 3 && Integer.valueOf(suffix) <= 255) {
				if (!(suffix.charAt(0) == '0' && suffix.length()>1)) {
					res.add(cur + suffix);
				}
			}
			return;
		}
		if (pos > s.length()) {
			return;
		}
		String suffix = s.substring(pos);
		if (suffix.length() >= 2) {
			dfs(s, cur + s.substring(pos, pos+1) + ".", pos+1, left-1);
		}
		if (suffix.length() >= 3 && suffix.charAt(0) != '0') {
			dfs(s, cur + s.substring(pos, pos+2) + ".", pos+2, left-1);
		}
		if (suffix.length() >= 4 && suffix.charAt(0) != '0') {
			String ss = s.substring(pos, pos+3);
			if (Integer.valueOf(ss) <= 255) {
				dfs(s, cur + s.substring(pos, pos+3) + ".", pos+3, left-1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Solution().restoreIpAddresses("010010").stream().forEach(System.out::println);
	}
}
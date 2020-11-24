package com.sklink.learning.leetcode.leetcode1663;

public class Solution {
	public String getSmallestString(int n, int k) {
        k -= n;
		int zNum = k/25;
		int mod = k%25;
		StringBuilder str = new StringBuilder(n);
		for(int i = 0; i < (n-zNum-1); i++) {
			str.append('a');
		}
		str.append((char)('a'+mod));
		for(int i = 0; i < zNum; i++) {
			str.append('z');
		}
		return str.toString();
    }
}

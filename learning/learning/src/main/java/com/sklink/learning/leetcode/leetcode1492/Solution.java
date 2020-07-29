package com.sklink.learning.leetcode.leetcode1492;

public class Solution {
	public int kthFactor(int n, int k) {
		int c = 0;
		int i;
		for(i = 1; i*i <= n; i++) {
			if (n%i == 0) {
				c++;
				if (c == k) {
					return i;
				}
			}
		}
		i--;
		if (i*i == n) {
			i--;
		}
		for(; i>0; i--) {
			if (n%i == 0) {
				c++;
				if (c == k) {
					return n/i;
				}
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().kthFactor(24, 6));
	}
}

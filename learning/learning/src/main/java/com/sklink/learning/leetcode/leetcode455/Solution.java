package com.sklink.learning.leetcode.leetcode455;

import java.util.Arrays;

class Solution {
	public int findContentChildren(int[] g, int[] s) {
		int res = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		int a = 0, b = 0;
		while(a < g.length && b < s.length) {
			if (s[b] < g[a]) {
				b++;
			}else {
				a++;
				b++;
				res++;
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] g = new int[] {1, 2};
		int[] s = new int[] {1, 2, 3};
		int res = solution.findContentChildren(g, s);
		System.out.println(res);
	}
}

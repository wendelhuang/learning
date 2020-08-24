package com.sklink.learning.leetcode.leetcode201;

public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		while(m < n) {
			n = n & (n-1);
		}
		return n;
    }
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rangeBitwiseAnd(3,4));
	}
}

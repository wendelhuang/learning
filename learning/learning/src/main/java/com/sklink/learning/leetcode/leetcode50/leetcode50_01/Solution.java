package com.sklink.learning.leetcode.leetcode50.leetcode50_01;

class Solution {
	public double myPow(double x, int n) {
		long realN = n;
		return realMyPow(x, realN);
    }
	
	public double realMyPow(double x, long n) {
		if (n < 0) {
			/**
			 * 取负可能导致整形溢出
			 */
			return 1.0/realMyPow(x, -n);
		}
		if (n == 0) {
			return 1.0;
		}
		double res = 1.0;
		double t = x;
		while(n > 0) {
			if ((n & 1) == 1) {
				res *= t;
			}
			t = t*t;
			n/=2;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		double x = 1.0;
		int n = -2147483648;
		System.out.println(solution.myPow(x, n));
	}
}
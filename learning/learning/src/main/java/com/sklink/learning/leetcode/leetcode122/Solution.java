package com.sklink.learning.leetcode.leetcode122;

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
        int res = 0;
        int n1 = -prices[0];
        int n2 = 0;
        for(int i = 1; i < prices.length; i++) {
        	int v1 = Math.max(n1, n2 - prices[i]);
        	int v2 = Math.max(n2, n1 + prices[i]);
        	n1 = v1;
        	n2 = v2;
        	res = Math.max(res, n1);
        	res = Math.max(res, n2);
        }
        return res; 
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = new int[] {1,2,3,4,5};
		System.out.println(solution.maxProfit(prices));
	}
}

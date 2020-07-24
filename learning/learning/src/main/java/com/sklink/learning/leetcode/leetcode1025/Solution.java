package com.sklink.learning.leetcode.leetcode1025;

class Solution {
	
	public boolean divisorGame(int N) {
		return (N&1) == 0;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().divisorGame(2));
	}
}
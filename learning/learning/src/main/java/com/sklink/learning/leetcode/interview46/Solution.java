package com.sklink.learning.leetcode.interview46;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int translateNum(int num) {
		if (num<10) {
			return 1;
		}
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		for(int i = 0; i <= 'z'-'a'; i++) {
			map.put(i, (char) ('a'+i));
		}
		int len = 0;
		int[] numbit = new int[32];
		int[] count = new int[32];
		int tmp = num;
		numbit[len++] = 0;
		while(tmp > 0) {
			numbit[len++] = tmp%10;
			tmp /= 10;
		}
		for(int i = 0;tmp>0; i++) {
			numbit[i] = tmp%10;
			tmp /= 10;
			if (len == 0 && tmp ==0) {
				len = i;
			}
		}
		count[0] = 1;
		count[1] = 1;
		for(int i = 2; i < len; i++) {
			count[i] = count[i-1];
			if (numbit[i] != 0 && map.containsKey(10*numbit[i] + numbit[i-1])) {
				count[i] += count[i-2]; 
			}
		}
		return count[len-1];
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().translateNum(12258));
	}
}

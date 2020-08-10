package com.sklink.learning.leetcode.leetcode696;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public int countBinarySubstrings(String s) {
		int res = 0;
		List<Integer> count = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			if (i == 0) {
				count.add(s.charAt(i) == '0' ? -1 : 1);
			}else {
				int u = count.get(count.size()-1);
				boolean b = s.charAt(i) == '0';
				if (u > 0) {
					if (b) {
						count.add(-1);
					}else {
						count.set(count.size()-1, count.get(count.size()-1) + 1);
					}
				}else {
					if (b) {
						count.set(count.size()-1, count.get(count.size()-1) - 1);
					}else {
						count.add(1);
					}
				}
			}
		}
		//System.out.println(Arrays.toString(count.toArray()));
		for(int i = 1; i < count.size(); i++) {
			res += Math.min(Math.abs(count.get(i)), Math.abs(count.get(i-1)));
		}
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countBinarySubstrings("10101"));
	}
}

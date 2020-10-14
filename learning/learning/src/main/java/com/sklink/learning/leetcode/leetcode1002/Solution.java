package com.sklink.learning.leetcode.leetcode1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
	public List<String> commonChars(String[] A) {
		int[] res = new int[26];
		Arrays.fill(res, Integer.MAX_VALUE);
		
		for(int i = 0; i < A.length; i++) {
			int[] t = new int[26];
			for(int j = 0; j < A[i].length(); j++) {
				t[A[i].charAt(j) - 'a']++;
			}
			for(int j = 0; j < 26; j++) {
				res[j] = Math.min(res[j], t[j]);
			}
		}
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 26; i++) {
			while(res[i] > 0) {
				list.add("" + (char)('a'+i));
				res[i]--;
			}
		}
		return list;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] A = new String[] {"bella", "label", "roller"};
		List<String> res = solution.commonChars(A);
		res.forEach(System.out::println);
	}
}
package com.sklink.learning.leetcode.leetcode179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public String largestNumber(int[] nums) {
		List<String> strs = new ArrayList<String>();
		for(int i = 0; i < nums.length; i++) {
			strs.add(intToString(nums[i]));
		}
		Collections.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s2.compareTo(s1);
			}
		});
		strs.stream().forEach(System.out::println);
		String ss = strs.stream().collect(Collectors.joining());
		if (ss.charAt(0) == '0') {
			ss = "0";
		}
		return ss;
    }
	
	public String intToString(int num) {
		if (num == 0) {
			return "0";
		}
		String res = new String();
		while (num > 0 ) {
			int d = num%10;
			res = "" + d + res;
			num/=10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().largestNumber(new int[] {0}));
	}
}

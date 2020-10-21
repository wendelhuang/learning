package com.sklink.learning.leetcode.leetcode925;

class Solution {
	public boolean isLongPressedName(String name, String typed) {
		return is(name, typed, 0, 0);
    }
	
	public boolean is(String name, String typed, int index1, int index2) {
		if (index1 >= name.length() && index2 >= typed.length()) {
			return true;
		}
		if (index1 >= name.length() || index2 >= typed.length() || name.charAt(index1) != typed.charAt(index2)) {
			return false;
		}
		int len1 = 1;
		int len2 = 1;
		while(index1 + len1 < name.length() && name.charAt(index1) == name.charAt(index1 + len1)) {
			len1++;
		}
		while(index2 + len2 < typed.length() && typed.charAt(index2) == typed.charAt(index2 + len2)) {
			len2++;
		}
		if (len1 > len2) {
			return false;
		}
		return is(name, typed, index1+len1, index2+len2);
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String name = "laiden";
		String typed = "laiden";
		System.out.println(solution.isLongPressedName(name, typed));
	}
}
package com.sklink.learning.leetcode.leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<String> res = new ArrayList<String>();
	public Map<Character, String> map = new HashMap<>();
	
	public void initMap() {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}
	public List<String> letterCombinations(String digits) {
		initMap();
		dfs("", digits);
		return res;
    }
	
	public void dfs(String current, String digits) {
		if (digits.equals("")) {
			if (!current.equals("")) {
				res.add(current);
			}
			return;
		}
		Character ch = digits.charAt(0);
		String str = map.get(ch);
		for(int i = 0; i < str.length(); i++) {
			dfs(current + str.charAt(i), digits.substring(1));
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		List<String> list = solution.letterCombinations("");
		
		list.stream().forEach(e -> {
			System.out.println(e);
		});
	}
}
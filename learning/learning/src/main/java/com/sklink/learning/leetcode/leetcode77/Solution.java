package com.sklink.learning.leetcode.leetcode77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combine(int n, int k) {
		backtrace(new ArrayList<>(), 1, n, k);
		return res;
    }
	
	public void backtrace(List<Integer> currentList, int current, int n, int k) {
		if (currentList.size() == k) {
			List<Integer> t = new ArrayList<>();
			for(int i = 0; i < currentList.size(); i++) {
				t.add(currentList.get(i));
			}
			res.add(t);
			return;
		}
		if (current > n) {
			return;
		}
		currentList.add(current);
		backtrace(currentList, current+1, n, k);
		currentList.remove(currentList.size()-1);
		backtrace(currentList, current+1, n, k);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 4;
		int k = 2;
		
		List<List<Integer>> res = solution.combine(n, k);
		res.stream().forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}
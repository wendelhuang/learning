package com.sklink.learning.leetcode.leetcode216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<List<Integer>> res;
	public List<List<Integer>> combinationSum3(int k, int n) {
		res = new ArrayList<List<Integer>>();
		dfs(new ArrayList<>(), n, k, 1);
		return res;
    }
	
	public void dfs(List<Integer> l, int n, int k, int from) {
		if (l.size() == k) {
			if(n == 0) {
				List<Integer> t = new ArrayList<>();
				for(int i = 0; i < l.size(); i++) {
					t.add(l.get(i));
				}
				res.add(t);
			}
			return;
		}
		if (from > 9) {
			return;
		}
		l.add(from);
		dfs(l, n-from, k, from+1);
		l.remove(l.size()-1);
		dfs(l, n, k, from+1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> list = solution.combinationSum3(3, 9);
		list.stream().forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}

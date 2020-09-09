package com.sklink.learning.leetcode.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		backtrace(new ArrayList<>(), 0, candidates, target);
		return res;
    }
	
	public void backtrace(List<Integer> currentList, int currentIndex, int[] candidates, int target) {
		if (target == 0) {
			List<Integer> t = new ArrayList<>();
			for(int i = 0; i < currentList.size(); i++) {
				t.add(currentList.get(i));
			}
			res.add(t);
			return;
		}
		if (currentIndex >= candidates.length) {
			return;
		}
		if (candidates[currentIndex] <= target) {
			currentList.add(candidates[currentIndex]);
			backtrace(currentList, currentIndex, candidates, target - candidates[currentIndex]);
			currentList.remove(currentList.size()-1);
			backtrace(currentList, currentIndex+1, candidates, target);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = new int[] {2,3,6,7};
		int target = 7;
		List<List<Integer>> ret = new Solution().combinationSum(candidates, target);
		ret.stream().forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}
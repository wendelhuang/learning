package com.sklink.learning.leetcode.leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Map<Integer, Integer> count= new TreeMap<Integer, Integer>();
		for(int i = 0; i < candidates.length; i++) {
			count.put(candidates[i], count.getOrDefault(candidates[i], 0) + 1);
		}
		List<List<Integer>> list = new ArrayList<>();
		for(int k : count.keySet()) {
			list.add(Arrays.asList(k, count.get(k)));
		}
		backtrace(new ArrayList<>(), 0, list, target);
		return res;
    }
	
	public void backtrace(List<Integer> currentList, int currentIndex, List<List<Integer>> candidates, int target) {
		//System.out.println(Arrays.toString(currentList.toArray()) + " -> " + target);
		if (target == 0) {
			List<Integer> t = new ArrayList<>();
			for(int i = 0; i < currentList.size(); i++) {
				t.add(currentList.get(i));
			}
			res.add(t);
			return;
		}
		if (currentIndex >= candidates.size()) {
			return;
		}
		int num = candidates.get(currentIndex).get(0);
		int cnt = candidates.get(currentIndex).get(1);
		if (num > target) {
			return;
		}
		if (cnt == 0) {
			backtrace(currentList, currentIndex+1, candidates, target);
			return;
		}
		currentList.add(num);
		candidates.get(currentIndex).set(1, cnt-1);
		backtrace(currentList, currentIndex, candidates, target - num);
		currentList.remove(currentList.size()-1);
		candidates.get(currentIndex).set(1, cnt);
		backtrace(currentList, currentIndex+1, candidates, target);
	}
	
	public static void main(String[] args) {
		int[] candidates = new int[] {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> ret = new Solution().combinationSum2(candidates, target);
		ret.stream().forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}
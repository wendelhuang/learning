package com.sklink.learning.leetcode.leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		Arrays.fill(visited, false);
		backtrace(new ArrayList<>(), nums, visited);
		return res;
    }
	
	public void backtrace(List<Integer> currentList, int[] nums, boolean[] visited) {
		//System.out.println(Arrays.toString(currentList.toArray()));
		//System.out.println(Arrays.toString(visited));
		if (currentList.size() == nums.length) {
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < currentList.size(); i++) {
				list.add(currentList.get(i));
			}
			res.add(list);
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if (!visited[i] && ( (i == 0 ) ||!(i > 0 && (nums[i] == nums[i-1]) && !visited[i-1]))) {
				visited[i] = true;
				currentList.add(nums[i]);
				backtrace(currentList, nums, visited);
				visited[i] = false;
				currentList.remove(currentList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,2,2};
		List<List<Integer>> ret = new Solution().permuteUnique(nums);
		ret.stream().forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}
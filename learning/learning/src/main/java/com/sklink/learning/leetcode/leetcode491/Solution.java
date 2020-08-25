package com.sklink.learning.leetcode.leetcode491;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	public List<List<Integer>> list = new ArrayList<>();
	
	public List<List<Integer>> findSubsequences(int[] nums) {
		dfs(nums, 0, new ArrayList<>(), -1);
		return list;
    }
	
	public void dfs(int[] nums, int index, List<Integer> current, int last) {
		//System.out.println(index + " - " + Arrays.toString(current.toArray()));
		if (nums == null || nums.length < 1) {
			return;
		}
		if (index > nums.length-1) {
			if (current.size() > 1) {
				List<Integer> tmp = new ArrayList<>();
				for(int i : current) {
					tmp.add(i);
				}
				list.add(tmp);
			}
			return;
		}
		if (current.size() == 0 || current.get(current.size()-1) <= nums[index]) {
			int count = 0;
			for(int i = last+1; i < index; i++) {
				if (nums[i] == nums[index]) {
					count++;
				}
			}
			if (count == 0) {
				current.add(nums[index]);
				dfs(nums, index+1, current, index);
				current.remove(current.size()-1);
			}
		}
		dfs(nums, index+1, current, last);
	}
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> res = solution.findSubsequences(new int[] {4,6,7,7});
		
		//String str1 = "1,1,1,2,2,2,3,3,3],[1,1,1,2,2,2,3,3],[1,1,1,2,2,2,3],[1,1,1,2,2,2],[1,1,1,2,2,3,3,3],[1,1,1,2,2,3,3],[1,1,1,2,2,3],[1,1,1,2,2],[1,1,1,2,3,3,3],[1,1,1,2,3,3],[1,1,1,2,3],[1,1,1,2],[1,1,1,3,3,3],[1,1,1,3,3],[1,1,1,3],[1,1,1],[1,1,2,2,2,3,3,3],[1,1,2,2,2,3,3],[1,1,2,2,2,3],[1,1,2,2,2],[1,1,2,2,3,3,3],[1,1,2,2,3,3],[1,1,2,2,3],[1,1,2,2],[1,1,2,3,3,3],[1,1,2,3,3],[1,1,2,3],[1,1,2],[1,1,3,3,3],[1,1,3,3],[1,1,3],[1,1],[1,2,2,2,3,3,3],[1,2,2,2,3,3],[1,2,2,2,3],[1,2,2,2],[1,2,2,3,3,3],[1,2,2,3,3],[1,2,2,3],[1,2,2],[1,2,3,3,3],[1,2,3,3],[1,2,3],[1,2],[1,3,3,3],[1,3,3],[1,3],[1,2,2,2,3,3,3],[1,2,2,2,3,3],[1,2,2,2,3],[1,2,2,2],[1,2,2,3,3,3],[1,2,2,3,3],[1,2,2,3],[1,2,2],[1,2,3,3,3],[1,2,3,3],[1,2,3],[1,2],[1,3,3,3],[1,3,3],[1,3],[1,2,2,2,3,3,3],[1,2,2,2,3,3],[1,2,2,2,3],[1,2,2,2],[1,2,2,3,3,3],[1,2,2,3,3],[1,2,2,3],[1,2,2],[1,2,3,3,3],[1,2,3,3],[1,2,3],[1,2],[1,3,3,3],[1,3,3],[1,3],[2,2,2,3,3,3],[2,2,2,3,3],[2,2,2,3],[2,2,2],[2,2,3,3,3],[2,2,3,3],[2,2,3],[2,2],[2,3,3,3],[2,3,3],[2,3],[2,3,3,3],[2,3,3],[2,3],[2,3,3,3],[2,3,3],[2,3],[3,3,3],[3,3";
		String str1 = "1,1,1,2,2,2,3,3,3][1,1,1,2,2,2,3,3][1,1,1,2,2,2,3][1,1,1,2,2,2][1,1,1,2,2,3,3,3][1,1,1,2,2,3,3][1,1,1,2,2,3][1,1,1,2,2][1,1,1,2,3,3,3][1,1,1,2,3,3][1,1,1,2,3][1,1,1,2][1,1,1,3,3,3][1,1,1,3,3][1,1,1,3][1,1,1][1,1,2,2,2,3,3,3][1,1,2,2,2,3,3][1,1,2,2,2,3][1,1,2,2,2][1,1,2,2,3,3,3][1,1,2,2,3,3][1,1,2,2,3][1,1,2,2][1,1,2,3,3,3][1,1,2,3,3][1,1,2,3][1,1,2][1,1,3,3,3][1,1,3,3][1,1,3][1,1][1,2,2,2,3,3,3][1,2,2,2,3,3][1,2,2,2,3][1,2,2,2][1,2,2,3,3,3][1,2,2,3,3][1,2,2,3][1,2,2][1,2,3,3,3][1,2,3,3][1,2,3][1,2][1,3,3,3][1,3,3][1,3][2,2,2,3,3,3][2,2,2,3,3][2,2,2,3][2,2,2][2,2,3,3,3][2,2,3,3][2,2,3][2,2][2,3,3,3][2,3,3][2,3][3,3,3][3,3";
		String str2 = "1,1],[1,1,1],[1,1,1,2],[1,1,1,2,2],[1,1,1,2,2,2],[1,1,1,2,2,2,3],[1,1,1,2,2,2,3,3],[1,1,1,2,2,2,3,3,3],[1,1,1,2,2,3],[1,1,1,2,2,3,3],[1,1,1,2,2,3,3,3],[1,1,1,2,3],[1,1,1,2,3,3],[1,1,1,2,3,3,3],[1,1,1,3],[1,1,1,3,3],[1,1,1,3,3,3],[1,1,2],[1,1,2,2],[1,1,2,2,2],[1,1,2,2,2,3],[1,1,2,2,2,3,3],[1,1,2,2,2,3,3,3],[1,1,2,2,3],[1,1,2,2,3,3],[1,1,2,2,3,3,3],[1,1,2,3],[1,1,2,3,3],[1,1,2,3,3,3],[1,1,3],[1,1,3,3],[1,1,3,3,3],[1,2],[1,2,2],[1,2,2,2],[1,2,2,2,3],[1,2,2,2,3,3],[1,2,2,2,3,3,3],[1,2,2,3],[1,2,2,3,3],[1,2,2,3,3,3],[1,2,3],[1,2,3,3],[1,2,3,3,3],[1,3],[1,3,3],[1,3,3,3],[2,2],[2,2,2],[2,2,2,3],[2,2,2,3,3],[2,2,2,3,3,3],[2,2,3],[2,2,3,3],[2,2,3,3,3],[2,3],[2,3,3],[2,3,3,3],[3,3],[3,3,3";
		
		String[] strr1 = str1.split("\\],\\[");
		String[] strr2 = str2.split("\\],\\[");
		
		System.out.println(strr1.length);
		System.out.println(strr2.length);
		
		List<String> t = new ArrayList<>();
		
		for(int i = 0; i < strr1.length; i++) {
			for(int j = i+1; j < strr1.length; j++) {
				if (strr1[j].equals(strr1[i])) {
					System.out.println(strr1[i]);
					t.add(strr1[i]);
				}
			}
		}
		System.out.println("-----------------------");
		
		Collections.sort(t);
		t.stream().forEach(System.out::println);

		System.out.println("-----------------------");
		
		for(int i = 0; i < strr1.length; i++) {
			boolean exist = false;
			for(int j = 0; j < strr2.length; j++) {
				if (strr2[j].equals(strr1[i])) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				System.out.println(strr1[i]);
			}
		}
		System.out.println("-----------------------");
		
		
		res.stream().forEach(e -> {
			System.out.print(Arrays.toString(e.toArray()).replace(" ", ""));
		});
	}
}

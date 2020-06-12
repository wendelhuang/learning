package com.sklink.learning.leetcode.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length-2; ) {
			int begin = i+1;
			int end = nums.length-1;
			while(begin < end) {
				if (false) {
					System.out.println(String.format("begin: %d, end: %d, i:%d, nums[begin]:%d, nums[end]:%d, nums[i]:%d", 
							begin, end, i, nums[begin], nums[end], nums[i]));
				}
				if (nums[begin] + nums[end] + nums[i] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[begin]);
					list.add(nums[end]);
					res.add(list);
					begin++;
					while(begin < end && nums[begin] == nums[begin-1]) {
						begin++;
					}
					end--;
					while(begin < end && nums[end] == nums[end+1]) {
						end--;
					}
				}else if (nums[begin] + nums[end] + nums[i] > 0) {
					end--;
				}else {
					begin++;
				}
			}
			i++;
			while(i < nums.length-2 && nums[i] == nums[i-1]) {
				i++;
			}
		}
		return res;
    }

	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		Solution solution = new Solution();
		System.out.println(solution.threeSum(arr));
		
		List<List<Integer>> list = solution.threeSum(arr);
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
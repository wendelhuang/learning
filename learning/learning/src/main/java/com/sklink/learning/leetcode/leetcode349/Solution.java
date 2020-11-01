package com.sklink.learning.leetcode.leetcode349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> res = new HashSet<Integer>();
		Set<Integer> n1 = new HashSet<>();
		for(int i = 0; i < nums1.length; i++) {
			n1.add(nums1[i]);
		}
		for(int i = 0; i < nums2.length; i++) {
			if (!res.contains(nums2[i]) && n1.contains(nums2[i])) {
				res.add(nums2[i]);
			}
		}
		List<Integer> list = new ArrayList<>(res);
		int[] rr = list.stream().mapToInt(Integer::valueOf).toArray();
		return rr;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = new int[] {1,2,2,1};
		int[] nums2 = new int[] {2,2};
		int[] res = solution.intersection(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}
}

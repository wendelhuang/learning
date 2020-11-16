package com.sklink.learning.leetcode.leetcode1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], i);
		}
		Map<Integer, Integer> cnt = new HashMap<>();
		List<Integer> left = new ArrayList<>();
		for(int i = 0; i < arr1.length; i++) {
			if (map.get(arr1[i]) != null) {
				cnt.put(arr1[i], cnt.getOrDefault(arr1[i], 0) + 1);
			}else {
				left.add(arr1[i]);
			}
		}
		Collections.sort(left);
		
		int[] res = new int[arr1.length];
		int index = 0;
		for(int i = 0; i < arr2.length; i++) {
			int num = cnt.get(arr2[i]);
			int c = 0;
			while(c < num) {
				res[index++] = arr2[i];
				c++;
			}
		}
		for(int i = 0; i < left.size(); i++) {
			res[index++] = left.get(i);
		}
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr1 = new int[] {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = new int[] {2,1,4,3,9,6};
		
		int[] res = solution.relativeSortArray(arr1, arr2);
		System.out.println(Arrays.toString(res));
	}
}

package com.sklink.learning.leetcode.leetcode347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
		}
		int[][] arr = new int[cntMap.size()][2];
		int index = 0;
		for(Integer i : cntMap.keySet()) {
			arr[index][0] = i;
			arr[index][1] = cntMap.get(i);
			index++;
		}
		int[] ret = new int[k];
		int retIndex = 0;
		qsort(arr, 0, index-1, ret, retIndex, k);
		return ret;
    }
	
	public void qsort(int[][] arr, int begin, int end, int[] ret, int retIndex, int k) {
		/*
		 * if (end <= begin) { return; }
		 */
		int pivot = arr[begin][0];
		int pivotCnt = arr[begin][1];
		int low = begin;
		int high = end;
		while(low < high) {
			while(low < high && arr[high][1] <= pivotCnt) {
				high--;
			}
			arr[low][0] = arr[high][0];
			arr[low][1] = arr[high][1];
			while(low < high && arr[low][1] >= pivotCnt) {
				low++;
			}
			arr[high][0] = arr[low][0];
			arr[high][1] = arr[low][1];
		}
		arr[low][0] = pivot;
		arr[low][1] = pivotCnt;
		if (k <= low-begin) {
			qsort(arr, begin, low-1, ret, retIndex, k);
		}else {
			for(int i = begin; i <= low; i++) {
				ret[retIndex++] = arr[i][0];
			}
			if (k > (low-begin+1)) {
				qsort(arr, low+1, end, ret, retIndex, k-(low-begin+1));
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().topKFrequent(new int[] {4, 1,-1,2,-1,2,3},2)));
	}
}

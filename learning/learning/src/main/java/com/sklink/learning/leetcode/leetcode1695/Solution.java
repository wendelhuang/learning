package com.sklink.learning.leetcode.leetcode1695;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int maximumUniqueSubarray(int[] nums) {
		int res = 0;
		int temp = 0;
		int slow = -1, fast = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(slow < nums.length && fast < nums.length) {
			while(fast < nums.length && !map.containsKey(nums[fast])) {
				map.put(nums[fast], 1);
				temp += nums[fast];
				res = Math.max(res, temp);
				fast++;
			}
			slow++;
			map.remove(nums[slow]);
			temp -= nums[slow];
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {5,2,1,2,5,2,1,2,5};
		int res = solution.maximumUniqueSubarray(nums);
		System.out.println(res);
	}
}

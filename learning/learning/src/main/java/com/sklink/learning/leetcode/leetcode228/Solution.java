package com.sklink.learning.leetcode.leetcode228;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public String transfer(int a, int b) {
		return a == b ? "" + a : String.format("%d->%d", a, b);
	}
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<String>();
    	if (nums.length == 0) {
    		return res;
    	}
    	int slow = 0, fast = 0;
    	while(fast < nums.length) {
    		while(fast + 1 < nums.length && nums[fast+1] == nums[fast]+1) {
    			fast++;
    		}
    		res.add(transfer(nums[slow], nums[fast]));
    		fast++;
    		slow = fast;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {-1};
		List<String> res = solution.summaryRanges(nums);
		res.forEach(System.out::println);
	}
}

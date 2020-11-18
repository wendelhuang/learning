package com.sklink.learning.leetcode.leetcode134;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int prefix = 0;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < gas.length; i++) {
			prefix += (gas[i] - cost[i]);
			if (min > prefix) {
				min = prefix;
				minIndex = i;
			}
		}

		return prefix >= 0 ? (minIndex+1)%gas.length : -1;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] gas = new int[] {5,1,2,3,4};
		int[] cost = new int[] {4,4,1,5,1};
		int res = solution.canCompleteCircuit(gas, cost);
		System.out.println(res);
	}
}


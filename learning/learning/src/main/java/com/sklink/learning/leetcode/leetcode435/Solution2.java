package com.sklink.learning.leetcode.leetcode435;

import java.util.Arrays;

class Solution {
	class Node implements Comparable<Node>{
		int left, right;
		Node(){}
		Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public int compareTo(Node o) {
			if (this.left < o.left) {
				return -1;
			}else if (this.left == o.left) {
				return Integer.compare(this.right, o.right);
			}else {
				return 1;
			}
		}
	}
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Node[] nodes = new Node[intervals.length];
		for(int i = 0; i < intervals.length; i++) {
			nodes[i] = new Node(intervals[i][0], intervals[i][1]);
		}
		Arrays.sort(nodes);
		
		int[] dp = new int[intervals.length];
		int max = 1;
		dp[0] = 1;
		for(int i = 0; i < intervals.length-1; i++) {
			for(int j = i+1; j < intervals.length; j++) {
				if (nodes[j].left >= nodes[i].right) {
					dp[j] = Math.max(dp[i]+1, dp[j]);
					max = Math.max(dp[j], max);
				}
			}
		}
		return intervals.length - max;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] intervals = new int[][] {
			new int[] {1,2},
			new int[] {2,3},
		};
		int res = solution.eraseOverlapIntervals(intervals);
		System.out.println(res);
	}
}
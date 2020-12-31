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
			return Integer.compare(this.right, o.right);
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
		
		int right = nodes[0].right;
		int count = 1;
		
		for(int i = 1; i < intervals.length; i++) {
			if (nodes[i].left >= right) {
				right = nodes[i].right;
				count++;
			}
		}
		return intervals.length - count;
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
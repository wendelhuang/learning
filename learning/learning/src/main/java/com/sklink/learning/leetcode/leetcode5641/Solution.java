package com.sklink.learning.leetcode.leetcode5641;

import java.util.Arrays;

public class Solution {
	class Node implements Comparable<Node> {
		public int x, y;
		Node() {}
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.y, this.y);
		};
		
	}
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Node[] nodes = new Node[boxTypes.length];
		for(int i = 0; i < boxTypes.length; i++) {
			nodes[i] = new Node(boxTypes[i][0], boxTypes[i][1]);
		}
		Arrays.sort(nodes);
		int res = 0;
		for(int i = 0; i < nodes.length; i++) {
			int c = Math.min(nodes[i].x, truckSize);
			res += c * nodes[i].y;
			truckSize -= c;
			if (truckSize == 0) {
				break;
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] boxTypes = new int[][] {
			new int[] {5, 10},
			new int[] {2, 5},
			new int[] {4, 7},
			new int[] {3, 9},
		};
		int truckSize = 10;
		int res = solution.maximumUnits(boxTypes, truckSize);
		System.out.println(res);
	}
}

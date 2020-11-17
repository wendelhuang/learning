package com.sklink.learning.leetcode.leetcode1030;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Solution {
	class Node implements Comparable<Node>{
		public int r, c, d;
		public Node() {}
		public Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
			public int compareTo(Node o) {
				return this.d - o.d;
			}
	}
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				pq.offer(new Node(i, j, Math.abs(i-r0) + Math.abs(j-c0)));
			}
		}
		int[][] res = new int[pq.size()][];
		int index = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			res[index++] = new int[] {n.r, n.c};
		}
		return res;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		int R = 2, C = 3, r0 = 1, c0 = 2;
		int[][] res = solution.allCellsDistOrder(R, C, r0, c0);
		Stream.of(res).forEach(e -> System.out.println(Arrays.toString(e)));
	}
}


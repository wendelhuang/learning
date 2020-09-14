package com.sklink.learning.leetcode.leetcode1584;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	class Edge implements Comparable<Edge> {
		public int a, b, dis;

		@Override
		public int compareTo(Edge o) {
			return this.dis - o.dis;
		}
	}
	public int[] parent;
	public int part;
	public int minCostConnectPoints(int[][] points) {
		if (points.length == 1) {
			return 0;
		}
		part = points.length;
		parent = new int[points.length];
		for(int i = 0; i < points.length; i++) {
			parent[i] = i;
		}
		Edge[] edges = new Edge[points.length*(points.length-1)/2];
		int index = 0;
		for(int i = 0; i < points.length; i++) {
			for(int j = i+1; j < points.length; j++) {
				Edge edge = new Edge();
				edge.a = i;
				edge.b = j;
				edge.dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
				edges[index++] = edge;
			}
		}
		Arrays.sort(edges);
		int res = 0;
		for(int i = 0; i < edges.length; i++) {
			if (find(edges[i].a) != find(edges[i].b)) {
				res += edges[i].dis;
				uni(edges[i].a, edges[i].b);
				if (part == 1) {
					return res;
				}
			}
		}
		return res;
    }
	
	public int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return find(parent[x]);
	}
	
	public void uni(int x, int y) {
		int px = find(x);
		int py = find(y);
		parent[py] = px;
		part--;
	}
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] points = new int[][] {
			new int[] {3,12},
			new int[] {-2,5},
			new int[] {-4,1},
		};
		System.out.println(solution.minCostConnectPoints(points));
	}
}
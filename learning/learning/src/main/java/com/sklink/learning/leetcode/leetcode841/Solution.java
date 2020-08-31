package com.sklink.learning.leetcode.leetcode841;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		if (rooms == null || rooms.size() == 0) {
			return true;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = rooms.size();
		boolean[] visited = new boolean[N];
		Arrays.fill(visited, false);
		queue.offer(0);
		visited[0] = true;
		int visitedCount = 1;
		while(!queue.isEmpty()) {
			int t = queue.poll();
			List<Integer> list = rooms.get(t);
			for(int i = 0; i < list.size(); i++) {
				int e = list.get(i);
				if (!visited[e]) {
					visitedCount++;
					queue.offer(e);
					visited[e] = true;
				}
			}
		}
		return visitedCount == N;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		List<Integer> l0 = Arrays.asList(1,3);
		List<Integer> l1 = Arrays.asList(3,0,1);
		List<Integer> l2 = Arrays.asList(2);
		List<Integer> l3 = Arrays.asList(0);
		rooms.add(l0);
		rooms.add(l1);
		rooms.add(l2);
		rooms.add(l3);
		System.out.println(solution.canVisitAllRooms(rooms));
	}
}
package com.sklink.learning.leetcode.leetcode207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] preCount = new int[numCourses];
		List[] map = new ArrayList[numCourses]; 
		for(int i = 0; i < map.length; i++) {
			map[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < prerequisites.length; i++) {
			map[prerequisites[i][1]].add(prerequisites[i][0]);
			preCount[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList();
		int left = numCourses;
		for(int i = 0; i < numCourses; i++) {
			if (preCount[i] == 0) {
				queue.offer(i);
				left--;
			}
		}
		while(!queue.isEmpty()) {
			int q = queue.poll();
			for(int i = 0; i < map[q].size(); i++) {
				int p = (int) map[q].get(i);
				preCount[p]--;
				if (preCount[p] == 0) {
					left--;
					queue.offer(p);
				}
			}
		}
		return left == 0;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] prerequisites = new int[][] {
			new int[] {1,0},
			new int[] {0,1}
		};
		System.out.println(solution.canFinish(2, prerequisites));
	}
}
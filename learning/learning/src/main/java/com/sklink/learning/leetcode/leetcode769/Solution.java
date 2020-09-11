package com.sklink.learning.leetcode.leetcode769;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int maxChunksToSorted(int[] arr) {
		boolean[] visited = new boolean[arr.length];
		Arrays.fill(visited, false);
		int ret = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.offer(i);
				visited[i] = true;
				while(!queue.isEmpty()) {
					int t = queue.poll();
					for(int j = t+1; j <= arr[t]; j++) {
						if (!visited[j]) {
							queue.offer(j);
							visited[j] = true;
						}
					}
				}
				ret++;
			}
		}
		return ret;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = new int[] {1,0,2,4,3};
		
		System.out.println(solution.maxChunksToSorted(arr));
	}
}
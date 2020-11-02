package com.sklink.learning.leetcode.leetcode5556;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int sumHeight = 0;
		for(int i = 1; i < heights.length; i++) {
			int deltaH = heights[i]-heights[i-1];
			System.out.println(Arrays.toString(new int[] {sumHeight, deltaH, bricks, ladders}));
			if (deltaH > 0) {
				pq.offer(deltaH);
				if (pq.size() > ladders) {
					int v = pq.poll();
					sumHeight += v;
				}
				if (sumHeight > bricks) {
					return i-1;
				}
			}
		}
		return heights.length-1;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] heights = new int[] {14,3,19,3};
		int bricks = 17;
		int ladders = 0;
		System.out.println(solution.furthestBuilding(heights, bricks, ladders));
	}
}

package com.sklink.learning.leetcode.leetcode84;

import java.util.Stack;

class Solution {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];

		for (int i = 0; i < right.length; i++) {
			right[i] = heights.length;
		}
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				right[stack.peek()] = i;
				stack.pop();
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		for (int i = 0; i < heights.length; i++) {
			System.out.println(String.format("height[%d]: %d, left[%d]: %d, right[%d]: %d", i, heights[i], i, left[i],
					i, right[i]));
		}
		int res = 0;
		for (int i = 0; i < heights.length; i++) {
			res = Math.max(res, (right[i] - (left[i] + 1)) * heights[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// int[] arr = { 2, 1, 5, 6, 2, 3 };
		int[] arr = { 4, 5, 3, 3, 4, 3, 4 };
		System.out.println(solution.largestRectangleArea(arr));
	}
}
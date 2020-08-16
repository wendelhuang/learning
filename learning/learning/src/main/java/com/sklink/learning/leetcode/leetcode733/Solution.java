package com.sklink.learning.leetcode.leetcode733;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	public int[] xOffset = { 1, 0, -1, 0 };
	public int[] yOffset = { 0, 1, 0, -1 };

	public boolean inBound(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length < 1 || image[0].length < 1) {
			return image;
		}
		int r = image.length;
		int c = image[0].length;
		if (!inBound(sr, sc, r, c)) {
			return image;
		}

		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			Arrays.fill(visited[i], false);
		}

		Stack<Integer[]> stack = new Stack<>();
		stack.push(new Integer[] { sr, sc });
		visited[sr][sc] = true;

		while (!stack.isEmpty()) {
			Integer[] curr = stack.pop();
			int currX = curr[0];
			int currY = curr[1];
			for (int i = 0; i < 4; i++) {
				int targetX = currX + xOffset[i];
				int targetY = currY + yOffset[i];
				if (inBound(targetX, targetY, r, c) && !visited[targetX][targetY]
						&& image[targetX][targetY] == image[currX][currY]) {
					stack.push(new Integer[] { targetX, targetY });
					visited[targetX][targetY] = true;
				}
			}
			image[currX][currY] = newColor;
		}
		return image;
	}

	public static void main(String[] args) {
		int[][] image = new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 1, 0 }, new int[] { 1, 0, 1 } };
		int[][] res = new Solution().floodFill(image, 1, 1, 2);
		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}

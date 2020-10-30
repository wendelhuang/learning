package com.sklink.learning.leetcode.leetcode463;

class Solution {
	int[] offsetX = new int[] { 0, 1, 0, -1 };
	int[] offsetY = new int[] { 1, 0, -1, 0 };

	public int islandPerimeter(int[][] grid) {
		int nodeNum = 0;
		int edgeNum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					nodeNum++;
					edgeNum += countSibing(grid, i, j);
				}
			}
		}
		return nodeNum * 4 - edgeNum;
	}

	public int countSibing(int[][] grid, int r, int c) {
		int res = 0;
		for (int i = 0; i < 4; i++) {
			int newX = r + offsetX[i];
			int newY = c + offsetY[i];
			if (inBound(grid, newX, newY) && grid[newX][newY] == 1) {
				res++;
			}
		}
		return res;
	}

	public boolean inBound(int[][] grid, int r, int c) {
		return grid.length > 0 && r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] grid = new int[][] { new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 1, 0 }, new int[] { 0, 1, 0, 0 },
				new int[] { 1, 1, 0, 0 }, };
		System.out.println(solution.islandPerimeter(grid));
	}
}
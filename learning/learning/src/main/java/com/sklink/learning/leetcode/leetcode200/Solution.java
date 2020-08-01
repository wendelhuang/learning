package com.sklink.learning.leetcode.leetcode200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	int[] x = { 1, 0, -1, 0 };
	int[] y = { 0, 1, 0, -1 };

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					res++;
					Queue<Integer[]> queue = new LinkedList<Integer[]>();
					queue.offer(new Integer[] { i, j });
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						Integer[] xy = queue.poll();
						for (int k = 0; k < 4; k++) {
							int newX = xy[0] + x[k];
							int newY = xy[1] + y[k];
							if (inBound(newX, newY, m, n) && !visited[newX][newY] && grid[newX][newY] == '1') {
								queue.offer(new Integer[] { newX, newY });
								visited[newX][newY] = true;
							}
						}
					}
				}
			}
		}
		return res;
	}

	public boolean inBound(int x, int y, int m, int n) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] grid = new char[][] { new char[] { '1', '1', '1' }, new char[] { '0', '1', '0' },
				new char[] { '1', '1', '1' } };
		System.out.println(solution.numIslands(grid));
	}
}

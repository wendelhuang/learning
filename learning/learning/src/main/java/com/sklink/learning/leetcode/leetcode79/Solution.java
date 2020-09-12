package com.sklink.learning.leetcode.leetcode79;

import java.util.Arrays;

class Solution {
	public int[] xOffset = new int[] { 1, 0, -1, 0 };
	public int[] yOffset = new int[] { 0, 1, 0, -1 };

	public boolean inBound(int r, int c, int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public boolean exist(char[][] board, String word) {
		int r = board.length;
		int c = board[0].length;

		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (dfs(board, visited, r, c, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, boolean[][] visited, int r, int c, int x, int y, String word, int index) {
		// System.out.println("x, y, index: " + Arrays.toString(new int[] { x,
		// y, index }));
		if (!inBound(r, c, x, y) || visited[x][y]) {
			return false;
		}
		if (index == word.length() - 1) {
			return board[x][y] == word.charAt(index);
		}
		char ch = word.charAt(index);
		if (ch == board[x][y]) {
			visited[x][y] = true;
			boolean ret = false;
			for (int i = 0; i < 4; i++) {
				int newX = x + xOffset[i];
				int newY = y + yOffset[i];
				if (inBound(r, c, newX, newY)) {
					boolean b = false;
					if (!visited[newX][newY]) {
						b = dfs(board, visited, r, c, newX, newY, word, index + 1);
					}
					if (b) {
						ret = true;
						break;
					}
				}
			}
			if (ret) {
				return true;
			} else {
				visited[x][y] = false;
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";

		String[] arr = new String[] { "ABCCED", "SEE", "ABCB" };

		for (String s : arr) {
			System.out.println(solution.exist(board, s));
		}

		board = new char[][] { new char[] { 'a' } };
		System.out.println(solution.exist(board, "a"));
	}
}
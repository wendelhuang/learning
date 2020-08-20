package com.sklink.learning.leetcode.leetcode529;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	
	public int[] xOffset = new int[] {1, 0, -1, 0, -1, -1, 1, 1};
	public int[] yOffset = new int[] {0, 1, 0, -1, -1, 1, -1, 1};
	
	public boolean inBound(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public char[][] updateBoard(char[][] board, int[] click) {
		if (board == null || board.length < 1 || board[0].length < 1) {
			return board;
		}
		int r = board.length;
		int c = board[0].length;
		
		int x = click[0];
		int y = click[1];
		if (board[x][y] == 'M') {
			board[x][y] = 'X';
			return board;
		}
		boolean[][] visited = new boolean[r][c];
		for(int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], false);
		}
		
		Stack<Integer[]> stack = new Stack<>();
		stack.push(new Integer[] {x, y});
		visited[x][y] = true;
		while(!stack.isEmpty()) {
			Integer[] tmp = stack.pop();
			int currentX = tmp[0];
			int currentY = tmp[1];
			int cnt = 0;
			for(int i = 0; i < xOffset.length; i++) {
				int targetX = currentX + xOffset[i];
				int targetY = currentY + yOffset[i];
				if (inBound(targetX, targetY, r, c) && board[targetX][targetY] == 'M') {
					cnt++;
				}
			}
			if (cnt == 0) {
				board[currentX][currentY] = 'B';
				for(int i = 0; i < xOffset.length; i++) {
					int targetX = currentX + xOffset[i];
					int targetY = currentY + yOffset[i];
					if (inBound(targetX, targetY, r, c) && !visited[targetX][targetY] && board[targetX][targetY] == 'E') {
						stack.push(new Integer[] {targetX, targetY});
						visited[targetX][targetY] = true;
					}
				}
			}else {
				board[currentX][currentY] = (char) ('0' + cnt);
			}
			for(int i = 0; i < xOffset.length; i++) {
				int targetX = currentX + xOffset[i];
				int targetY = currentY + yOffset[i];
				if (inBound(targetX, targetY, r, c) && board[targetX][targetY] == 'M') {
					cnt++;
				}
			}
		}
		return board;
    }

	public static void main(String[] args) {
		char[][] board = new char[][] {
			new char[] {'E', 'E', 'E', 'E', 'E'},
			new char[] {'E', 'E', 'M', 'E', 'E'},
			new char[] {'E', 'E', 'E', 'E', 'E'},
			new char[] {'E', 'E', 'E', 'E', 'E'}
		};
		int[] click = new int[] {3, 0};
		char[][] res = new Solution().updateBoard(board, click);
		for(char[] r : res) {
			System.out.println(Arrays.toString(r));
		}
	}
}

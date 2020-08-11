package com.sklink.learning.leetcode.leetcode130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
	public int[] xOffset = new int[] {0, 1, 0, -1};
	public int[] yOffset = new int[] {1, 0, -1, 0};
	
	public boolean inBound(int r, int c, int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}
	public void solve(char[][] board) {
		if (board == null || board.length < 1 || board[0].length < 1) {
			return;
		}
		int r = board.length;
		int c = board[0].length;
		boolean[][] visited = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			Arrays.fill(visited[i], false);
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if (!visited[i][j] && board[i][j] == 'O') {
					//System.out.println("i, j: " + Arrays.toString(new int[] {i ,j}));
					boolean groupInBound = true;
					Stack<Integer[]> stack = new Stack<>();
					List<Integer[]> list = new ArrayList<Integer[]>();
					stack.push(new Integer[] {i, j});
					list.add(new Integer[] {i, j});
					while (!stack.isEmpty()) {
						Integer[] xyt = stack.pop();
						int xt = xyt[0];
						int yt = xyt[1]; 
						if (!visited[xt][yt]) {
							visited[xt][yt] = true;
							for(int k = 0; k < 4; k++) {
								int targetX = xt+xOffset[k];
								int targetY = yt + yOffset[k];
								boolean isInBound = inBound(r, c, targetX, targetY);
								if (!isInBound) {
									//System.out.println("x, y: " + Arrays.toString(new int[] {targetX, targetY}));
									groupInBound = false;
								}else if (isInBound && !visited[targetX][targetY] && board[targetX][targetY] == 'O') {
									stack.add(new Integer[] {targetX, targetY});
									list.add(new Integer[] {targetX, targetY});
								}
							}
						}
					}
					if (groupInBound) {
						for(int k = 0; k < list.size(); k++) {
							board[list.get(k)[0]][list.get(k)[1]] = 'X';
						}
					}
				}
				visited[i][j] = true;
			}
		}
    }
	
	public static void main(String[] args) {
		char[][] board = new char[][] {
			new char[] {'X', 'O', 'X'},
			new char[] {'X', 'O', 'X'},
			new char[] {'X', 'O', 'X'}
		};
		Solution solution = new Solution();
		solution.solve(board);
		Arrays.asList(board).stream().forEach(e -> System.out.println(Arrays.toString(e)));
	}
}
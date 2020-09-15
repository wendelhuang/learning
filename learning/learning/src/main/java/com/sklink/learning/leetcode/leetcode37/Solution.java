package com.sklink.learning.leetcode.leetcode37;

import java.util.Arrays;

class Solution {
	public void solveSudoku(char[][] board) {
		int[] bitmap = new int[9];
		int slot = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int v = board[i][j] - '1';
					bitmap[i] |= 1 << (9 + 9 + v);
					bitmap[j] |= 1 << (9 + v);
					bitmap[(i / 3) * 3 + (j / 3)] |= 1 << (v);
				} else {
					slot++;
				}
			}
		}
		printBoard(board);
		printBitmap(bitmap);
		backtrace(board, bitmap, 0, 0, slot);
		printBoard(board);
		printBitmap(bitmap);
	}

	public boolean backtrace(char[][] board, int[] bitmap, int x, int y, int slot) {
		System.out.println(Arrays.asList(x, y, slot));
		if (slot == 0) {
			System.out.println("success");
			return true;
		}
		if (y == 9) {
			return backtrace(board, bitmap, x + 1, 0, slot);
		}
		if (x == 9) {
			return false;
		}
		if (board[x][y] != '.') {
			return backtrace(board, bitmap, x, y + 1, slot);
		}
		for (int i = 0; i < 9; i++) {
			boolean row = (bitmap[x] & 1 << (9 + 9 + i)) == 0;
			boolean col = (bitmap[y] & 1 << (9 + i)) == 0;
			boolean square = (bitmap[(x / 3) * 3 + (y / 3)] & 1 << (i)) == 0;
			if (row && col && square) {
				board[x][y] = (char) (i + '1');
				bitmap[x] ^= 1 << (9 + 9 + i);
				bitmap[y] ^= 1 << (9 + i);
				bitmap[(x / 3) * 3 + (y / 3)] ^= 1 << (i);
				if (backtrace(board, bitmap, x, y + 1, slot - 1)) {
					return true;
				}
				board[x][y] = '.';
				bitmap[x] ^= 1 << (9 + 9 + i);
				bitmap[y] ^= 1 << (9 + i);
				bitmap[(x / 3) * 3 + (y / 3)] ^= 1 << (i);
			}
		}
		return false;
	}

	public void printBitmap(int[] bitmap) {
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 31; j >= 0; j--) {
				System.out.print((bitmap[i] & (1 << j)) == 0 ? 0 : 1);
				if (j % 9 == 0) {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}

	public void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = new char[][] { new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' }, };
		solution.solveSudoku(board);
	}
}
package com.sklink.learning.leetcode.leetcode5511;

class Solution {
	public int numSpecial(int[][] mat) {
		int R = mat.length;
		int C = mat[0].length;
		int[] row = new int[R];
		int[] col = new int[C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if (mat[i][j] == 1) {
					row[i]++;
					col[j]++;
				}
			}
		}
		
		int r = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if (mat[i][j] == 1 && row[i] == 1 && col[j]==1) {
					r++;
				}
			}
		}
		return r;
    }

	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] mat = new int[][] {
			new int[] {1,0,0},
			new int[] {0,0,1},
			new int[] {1,0,0},
		};
		System.out.println(solution.numSpecial(mat));
	}
}
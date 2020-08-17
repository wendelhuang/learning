package com.sklink.learning.leetcode.leetcode240;

import java.util.Arrays;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
        	return false;
        }
        return dfs(matrix, 0, 0, matrix.length-1, matrix[0].length-1, target);
    }
	
	public boolean dfs(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
		if (x1 > x2 || y1 > y2) {
			return false;
		}
		if (x1 == x2 && y1 == y2) {
			return matrix[x1][y1] == target;
		}
		int midX = (x1+x2)/2;
		int midY = (y1+y2)/2;
		System.out.println(Arrays.toString(new int[] {x1, y1, x2, y2, midX, midY}));
		if (matrix[midX][midY] == target) {
			return true;
		}else if (matrix[midX][midY] < target) {
			boolean res = false;
			if (midX < x2) {
				res |= dfs(matrix, midX+1, y1, x2, y2, target);
			}
			if (midY < y2) {
				res |= dfs(matrix, x1, midY+1, x2, y2, target);
			}
			return res;
		}else {
			boolean res = false;
			if (midY > y1) {
				res |= dfs(matrix, x1, y1, x2, midY-1, target);
			}
			if (midX > x1) {
				res |= dfs(matrix, x1, y1, midX-1, y2, target);
			}
			return res;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = new int[][] {
			/*new int[] {1,   4,  7, 11, 15},
			new int[] {2,   5,  8, 12, 19},
			new int[] {3,   6,  9, 16, 22},
			new int[] {10, 13, 14, 17, 24},
			new int[] {18, 21, 23, 26, 30},*/
			new int[] {1,2,3,4,5},
			new int[] {6,7,8,9,10},
			new int[] {11,12,13,14,15},
			new int[] {16,17,18,19,20},
			new int[] {21,22,23,24,25},
		};
		System.out.println(solution.searchMatrix(matrix, 5));
	}

}
package com.sklink.learning.leetcode.leetcode74;

import java.util.Arrays;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		int left = 0;
		int right = r*c-1;
		while(left <= right) {
			//System.out.println("left, right" + Arrays.toString(new int[] {left, right}));
			int mid = (left+right)/2;
			int x = mid/c;
			int y = mid%c;
			//System.out.println("x, y" + Arrays.toString(new int[] {x, y}));
			if (target == matrix[x][y]) {
				System.out.println(Arrays.toString(new int[] {x, y}));
				return true;
			}else if (target > matrix[x][y]) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return false;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = new int[][] {
			new int[] {1, 3, 5, 7},
			new int[] {10, 11, 16, 20},
			new int[] {23, 30, 34, 50},
		};
		System.out.println(solution.searchMatrix(matrix, 3));
	}
}
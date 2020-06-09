package com.sklink.learning.leetcode.interview29;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] spiralOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}
		List<Integer> list = func(matrix, 0, 0, matrix.length, matrix[0].length);
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
    }
	
	public List<Integer> func(int[][]matrix, int i, int j, int row, int col) {
		if (true) {
			System.out.println(String.format("i=%d, j=%d, row=%d, col=%d", i, j, row, col));
		}
		List<Integer> res = new ArrayList<>();
		if (row == 0 || col==0) {
			return res;
		}
		if (row == 1) {
			for(int u = 0; u < col; u++) {
				res.add(matrix[i][j+u]);
			}
		}
		if (col == 1) {
			for(int u = 0; u < row; u++) {
				res.add(matrix[i+u][j]);
			}
			return res;
		}
		for(int u = 0; u < col; u++) {
			res.add(matrix[i][j+u]);
		}
		for(int u = 1; u < row; u++) {
			res.add(matrix[i+u][j+col-1]);
		}
		for(int u = col-1; u > 0; u--) {
			res.add(matrix[i+row-1][j+u-1]);
		}
		for(int u = row-1; u > 1; u--) {
			res.add(matrix[i+u-1][j]);
		}
		List<Integer> subRes = func(matrix, i+1, j+1, row-2, col-2);
		for(int u = 0; u < subRes.size(); u++) {
			res.add(subRes.get(u));
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				/*
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
				*/
				
				/*
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
				*/
				{3},
				{2}
		};
		for(int n : new Solution().spiralOrder(matrix)) {
			System.out.println(n);
		}
	}
}

package com.sklink.learning.leetcode.leetcode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<List<String>> res = new ArrayList<List<String>>();
	
	public List<List<String>> solveNQueens(int n) {
		int[][] currentMap = new int[n][n];
		int[] rowMap = new int[n];
		int[] colMap = new int[n];
		Arrays.fill(rowMap, -1);
		Arrays.fill(colMap, -1);
		dfs(currentMap, n, rowMap, colMap, 0, n);
		return res;
    }
	
	public void dfs(int[][] currentMap, int left, int[] rowMap, int[] colMap, int row, int n) {
		if (left == 0) {
			List<String> currRes = new ArrayList<>();
			for(int i = 0; i < currentMap.length; i++) {
				StringBuffer buffer = new StringBuffer();
				for(int j = 0; j < currentMap[0].length; j++) {
					buffer.append(currentMap[i][j] == 1 ? 'Q' : '.');
				}
				currRes.add(buffer.toString());
			}
			res.add(currRes);
			return;
		}
		if (row >= n) {
			return;
		}
		for(int i = 0; i < n; i++) {
			/**
			 * check col
			 */
			if (colMap[i] == -1) {
				/**
				 * check row+col
				 */
				boolean can = true;
				for(int j = 0; j < n; j++) {
					if (colMap[j] != -1 && !canPut(colMap[j], j, row, i)) {
						can = false;
						break;
					}
				}
				if (can) {
					colMap[i] = row;
					currentMap[row][i] = 1;
					dfs(currentMap, left-1, rowMap, colMap, row+1, n);
					colMap[i] = -1;
					currentMap[row][i] = 0;
				}
			}
		}
	}
	
	public boolean canPut(int r1, int c1, int r2, int c2) {
		int diff1 = Math.abs(r1-r2);
		int diff2 = Math.abs(c1-c2);
		return diff1 != diff2;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<String>> list = solution.solveNQueens(4);
		list.stream().forEach(e -> {
			e.stream().forEach(System.out::println);
			System.out.println("-------------");
		});
	}
}

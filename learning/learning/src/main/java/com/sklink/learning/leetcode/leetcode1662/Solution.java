package com.sklink.learning.leetcode.leetcode1662;

public class Solution {
	class Node {
		public int v1;
		public int v2;
		Node(){}
		Node(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		int i1 = 0, j1 = -1, i2 = 0, j2 = -1;
		while(true) {
			Node n1 = next(word1, i1, j1);
			Node n2 = next(word2, i2, j2);
			if (n1 == null || n2==null) {
				return true;
			}
			if (n1 != null && n2==null || n1==null&&n2!=null) {
				return false;
			}
			
			i1 = n1.v1;
			j1 = n1.v2;
			
			i2 = n2.v1;
			j2 = n2.v2;
			
			//System.out.println(Arrays.toString(new int[]{i1, j1, i2, j2}));

			Character ch1 = getChar(word1, i1, j1);
			Character ch2 = getChar(word2, i2, j2);
			if (ch1!=ch2) {
				return false;
			}
		}
    }

	public Node next(String[] word, int row, int col) {
		if (row >= word.length || col == word[row].length() && row==word.length-1) {
			return null;
		}
		if (row < word.length && col < word[row].length()-1) {
			return new Node(row, col+1);
		}
		return next(word, row+1, -1);
	}
	
	public Character getChar(String[] word, int row, int col) {
		if (row >= word.length || col >= word[row].length()) {
			return null;
		}
		return word[row].charAt(col);
	}
}

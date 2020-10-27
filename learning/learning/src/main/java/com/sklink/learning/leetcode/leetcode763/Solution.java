package com.sklink.learning.leetcode.leetcode763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	class Node implements Comparable<Node> {
		int left, right;
		Node(){}
		Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public int compareTo(Node o) {
			if (this.left < o.left) {
				return -1;
			}else if (this.left == o.left) {
				if (this.right < o.right) {
					return -1;
				}else if (this.right == o.right) {
					return 0;
				}else {
					return 1;
				}
			}else {
				return 1;
			}
		}
		public int getLeft() {
			return left;
		}
		public void setLeft(int left) {
			this.left = left;
		}
		public int getRight() {
			return right;
		}
		public void setRight(int right) {
			this.right = right;
		}
	}
	public List<Integer> partitionLabels(String S) {
		int[] leftStart = new int[26];
		int[] rightEnd = new int[26];
		Arrays.fill(leftStart, -1);
		Arrays.fill(rightEnd, -1);
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < S.length(); i++) {
			int index = S.charAt(i)-'a';
			set.add(index);
			if (leftStart[index] == -1) {
				leftStart[index] = i;
			}
			if (rightEnd[index] < i) {
				rightEnd[index] = i;
			}
		}
		Node[] nodes = new Node[set.size()];
		int index = 0;
		for(int i = 0; i < 26; i++) {
			if (leftStart[i] != -1) {
				nodes[index++] = new Node(leftStart[i], rightEnd[i]);
			}
		}
		Arrays.sort(nodes);
		List<Integer> res = new ArrayList<Integer>();
		int currentLeft = -1;
		int currentRight = -1;
		for(int i = 0; i < index; i++) {
			if (i == 0) {
				currentLeft = nodes[i].left;
				currentRight = nodes[i].right;
			}else {
				if (nodes[i].left > currentRight) {
					res.add(currentRight-currentLeft+1);
					currentLeft = nodes[i].left;
					currentRight = nodes[i].right;
				}else {
					currentRight = Math.max(currentRight, nodes[i].right);
				}
				if (i == index - 1) {
					res.add(currentRight-currentLeft+1);
				}
			}
		}
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String S = "ababcbacadefegdehijhklij";
		
		List<Integer> res = solution.partitionLabels(S);
		res.forEach(System.out::println);
	}
}
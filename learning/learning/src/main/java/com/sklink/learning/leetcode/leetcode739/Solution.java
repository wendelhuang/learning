package com.sklink.learning.leetcode.leetcode739;

import java.util.Stack;

class Solution {
	class Node {
		int k,v;
		public Node(int k, int v) {
			this.k = k;
			this.v = v;
		}
		public int getK() {
			return k;
		}
		public void setK(int k) {
			this.k = k;
		}
		public int getV() {
			return v;
		}
		public void setV(int v) {
			this.v = v;
		}
	}
	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		Stack<Node> stack = new Stack<>();
		for(int i = T.length-1; i >= 0; i--) {
			while(!stack.isEmpty()) {
				Node n = stack.peek();
				if (n.v > T[i]) {
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				res[i] = 0;
			}else {
				res[i] = stack.peek().k - i;
			}
			stack.push(new Node(i, T[i]));
		}
		return res;
    }

	public static void main(String[] args) {
		int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
		Solution solution = new Solution();
		int[] res = solution.dailyTemperatures(arr);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		System.out.println();
	}
}
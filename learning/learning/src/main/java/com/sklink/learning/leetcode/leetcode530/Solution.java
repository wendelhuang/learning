package com.sklink.learning.leetcode.leetcode530;

import java.util.Stack;

public class Solution {
	
	public int getMinimumDifference(TreeNode root) {
		int prev = Integer.MAX_VALUE;
		int res = Integer.MAX_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode t = root.left;
		while(t != null) {
			stack.push(t);
			t = t.left;
		}
		while(!stack.isEmpty()) {
			t = stack.pop();
			//System.out.println(t.val);
			res = Math.min(res, Math.abs(prev - t.val));
			prev = t.val;
			if (t.right != null) {
				t = t.right;
				while(t != null) {
					stack.push(t);
					t = t.left;
				}
			}
		}
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(2236);
		root.right.left = new TreeNode(1277);
		root.right.right = new TreeNode(2776);
		root.right.left.left = new TreeNode(519);
		System.out.println(solution.getMinimumDifference(root));
	}
}

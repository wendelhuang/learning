package com.sklink.learning.leetcode.leetcode144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);

			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				res.add(node.val);
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		List<Integer> list = solution.preorderTraversal(root);
		list.forEach(System.out::println);
	}
}
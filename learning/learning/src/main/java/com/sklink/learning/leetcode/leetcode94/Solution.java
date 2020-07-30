package com.sklink.learning.leetcode.leetcode94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	Stack<TreeNode> stack = new Stack<>();
	List<Integer> list = new ArrayList<Integer>();
	
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return list;
		}
		stack.push(root);
		leftMost(root);
		while(!stack.empty()) {
			TreeNode t = stack.pop();
			list.add(t.val);
			if (t.right!= null) {
				stack.push(t.right);
				leftMost(t.right);
			}
		}
		return list;
    }
	
	public void leftMost(TreeNode root) {
		TreeNode t = root.left;
		while(t != null) {
			stack.push(t);
			t = t.left;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		new Solution().inorderTraversal(root).stream().forEach(System.out::println);
	}
}
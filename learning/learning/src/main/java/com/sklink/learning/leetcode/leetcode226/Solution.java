package com.sklink.learning.leetcode.leetcode226;

public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode t1 = invertTree(root.left);
		TreeNode t2 = invertTree(root.right);
		root.left = t2;
		root.right = t1;
		return root;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		TreeNode ret = solution.invertTree(root);
		System.out.println(ret);
	}
}

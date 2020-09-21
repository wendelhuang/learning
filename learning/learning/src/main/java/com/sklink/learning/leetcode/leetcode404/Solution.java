package com.sklink.learning.leetcode.leetcode404;

class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		int ret = 0;
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.left.left == null && root.left.right == null) {
			ret += root.left.val;
		}
		ret += sumOfLeftLeaves(root.left);
		ret += sumOfLeftLeaves(root.right);
		return ret;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int ret = new Solution().sumOfLeftLeaves(root);
		System.out.println(ret);
	}
}
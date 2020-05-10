package com.sklink.learning.leetcode.leetcode236.leetcode236_01;

class Solution {
	private TreeNode ans = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root, p, q);
		return ans;
	}

	public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}
		boolean leftResult = dfs(root.left, p, q);
		boolean rightResult = dfs(root.right, p, q);
		if ((leftResult && rightResult) || ((root.val == p.val || root.val == q.val) && (leftResult || rightResult))) {
			ans = root;
		}
		return leftResult || rightResult || (root.val == p.val || root.val == q.val);
	}

}
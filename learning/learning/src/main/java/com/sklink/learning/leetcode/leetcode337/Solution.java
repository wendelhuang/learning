package com.sklink.learning.leetcode.leetcode337;

public class Solution {
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(rob(root, true), rob(root, false));
    }
	
	public int rob(TreeNode root, boolean rootIn) {
		if (root == null) {
			return 0;
		}
		if (rootIn) {
			return root.val + rob(root.left, false) + rob(root.right, false);
		}else {
			return Math.max(rob(root.left, true), rob(root.left, false)) + Math.max(rob(root.right, true), rob(root.right, false));
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		Solution solution = new Solution();
		System.out.println(solution.rob(root));
	}
}

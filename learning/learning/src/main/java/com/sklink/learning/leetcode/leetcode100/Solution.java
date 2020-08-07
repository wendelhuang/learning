package com.sklink.learning.leetcode.leetcode100;

class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if ((p == null && q == null)) {
			return true;
		}
		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
    }

	

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		System.out.println(solution.isSameTree(root1, root2));
	}
}
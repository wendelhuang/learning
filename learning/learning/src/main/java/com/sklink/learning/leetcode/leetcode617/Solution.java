package com.sklink.learning.leetcode.leetcode617;

class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 != null && t2 != null) {
			TreeNode t = new TreeNode(t1.val + t2.val);
			t.left = mergeTrees(t1.left, t2.left);
			t.right = mergeTrees(t1.right, t2.right);
			return t;
		}
		if (t1 == null && t2 == null) {
			return null;
		}
		if (t1 == null) {
			t1 = t2;
		}
		TreeNode t = new TreeNode(t1.val);
		t.left = mergeTrees(t1.left, null);
		t.right = mergeTrees(t1.right, null);
		return t;
    }

	public static void main(String[] args) {
	}
}
package com.sklink.learning.leetcode.leetcode101;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}

	public boolean check(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue1 = new LinkedList<>();
		queue1.add(p);
		queue1.add(q);
		while (!queue1.isEmpty()) {
			TreeNode u = queue1.poll();
			TreeNode v = queue1.poll();
			if (u == null && v == null) {
				continue;
			}
			if (u == null || v == null || u.val != v.val) {
				return false;
			}
			queue1.offer(u.left);
			queue1.offer(v.right);
			queue1.offer(u.right);
			queue1.offer(v.left);
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(solution.isSymmetric(root));
	}
}
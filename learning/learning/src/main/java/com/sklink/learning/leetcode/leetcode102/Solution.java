package com.sklink.learning.leetcode.leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			while(!q1.isEmpty()) {
				TreeNode e = q1.peek();
				if (e.left != null) {
					q2.offer(e.left);
				}
				if (e.right != null) {
					q2.offer(e.right);
				}
				list.add(e.val);
				q1.poll();
			}
			if (list.size() > 0) {
				res.add(list);
			}
			list = new ArrayList<>();
			while(!q2.isEmpty()) {
				TreeNode e = q2.peek();
				if (e.left != null) {
					q1.offer(e.left);
				}
				if (e.right != null) {
					q1.offer(e.right);
				}
				list.add(e.val);
				q2.poll();
			}
			if (list.size() > 0) {
				res.add(list);
			}
		}
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(solution.levelOrder(root));
	}
}
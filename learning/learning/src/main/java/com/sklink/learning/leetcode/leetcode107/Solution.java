package com.sklink.learning.leetcode.leetcode107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null) {
			return res;
		}
		queue.offer(root);
		queue.offer(new TreeNode(Integer.MAX_VALUE));

		dfs(res, queue);

		return res;
	}

	public void dfs(List<List<Integer>> currentResult, Queue<TreeNode> queue) {
		TreeNode curr = queue.peek();

		List<Integer> currQ = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			curr = queue.poll();
			if (curr.val == Integer.MAX_VALUE) {
				break;
			}
			currQ.add(curr.val);
			if (curr.left != null) {
				queue.offer(curr.left);
			}
			if (curr.right != null) {
				queue.offer(curr.right);
			}
		}
		queue.offer(new TreeNode(Integer.MAX_VALUE));

		if (currQ.isEmpty()) {
			return;
		}
		dfs(currentResult, queue);
		currentResult.add(currQ);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = solution.levelOrderBottom(root);
		res.forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}
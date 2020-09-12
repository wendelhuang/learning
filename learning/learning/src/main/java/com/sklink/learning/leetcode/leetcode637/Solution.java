package com.sklink.learning.leetcode.leetcode637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> ret = new ArrayList<Double>();
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(root);
		while (!(q1.isEmpty() && q2.isEmpty())) {
			long sum = 0;
			long cnt = 0;
			while (!q1.isEmpty()) {
				TreeNode treeNode = q1.poll();
				sum += treeNode.val;
				cnt++;
				if (treeNode.left != null) {
					q2.offer(treeNode.left);
				}
				if (treeNode.right != null) {
					q2.offer(treeNode.right);
				}
			}
			if (cnt > 0) {
				ret.add(sum * 1.0 / cnt);
				sum = 0;
				cnt = 0;
			}
			while (!q2.isEmpty()) {
				TreeNode treeNode = q2.poll();
				sum += treeNode.val;
				cnt++;
				if (treeNode.left != null) {
					q1.offer(treeNode.left);
				}
				if (treeNode.right != null) {
					q1.offer(treeNode.right);
				}
			}
			if (cnt > 0) {
				ret.add(sum * 1.0 / cnt);
				sum = 0;
				cnt = 0;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<Double> ret = new Solution().averageOfLevels(root);
		ret.stream().forEach(System.out::println);
	}
}
package com.sklink.learning.leetcode.leetcode257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<String> res = new ArrayList<String>();
	public List<String> binaryTreePaths(TreeNode root) {
		bfs("", root);
		return res;
    }
	
	public void bfs(String currStr, TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			currStr = currStr + (!currStr.equals("") ? "->" : "") + root.val;
			res.add(currStr);
			return;
		}
		currStr = currStr + (!currStr.equals("") ? "->" : "") + root.val;
		bfs(currStr, root.left);
		bfs(currStr, root.right);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		List<String> list = solution.binaryTreePaths(root.left.right);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
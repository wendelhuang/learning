package com.sklink.learning.leetcode.leetcode538;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public TreeNode convertBST(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode tmp = root;
			while(tmp != null) {
				stack.push(tmp);
				tmp = tmp.right;
			}
			int sum = 0;
			while(!stack.isEmpty()) {
				TreeNode t = stack.pop();
				sum += t.val;
				t.val = sum;
				if (t.left != null) {
					tmp = t.left;
					while(tmp != null) {
						stack.push(tmp);
						tmp = tmp.right;
					}
				}
			}
		}
		return root;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		TreeNode res = new Solution().convertBST(root);
		System.out.println(res);
	}
}

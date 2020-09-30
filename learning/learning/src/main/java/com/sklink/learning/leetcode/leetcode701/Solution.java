package com.sklink.learning.leetcode.leetcode701;

public class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode newNode = new TreeNode(val);
        if (root == null) {
        	return newNode;
        }
        TreeNode tmp = root;
        TreeNode prev = null;
        while (tmp != null) {
        	prev = tmp;
        	if (tmp.val <= val) {
        		tmp = tmp.right;
        	}else {
        		tmp = tmp.left;
        	}
        }
        if (prev.val <= val) {
        	prev.right = newNode;
        }else {
        	prev.left = newNode;
        }
        return root;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(30);
		
		TreeNode res = solution.insertIntoBST(root, 25);
		
		System.out.println(res);
	}
}

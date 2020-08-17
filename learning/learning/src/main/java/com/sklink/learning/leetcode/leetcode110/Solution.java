package com.sklink.learning.leetcode.leetcode110;

public class Solution {
	public boolean isBalanced(TreeNode root) {
    	return height(root) != -1;
    }
    
    public int height(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int leftHeight = height(root.left);
    	int rightHeight = height(root.right);
    	if (leftHeight == -1 || rightHeight == -1) {
    		return -1;
    	}
    	if (Math.abs(leftHeight-rightHeight ) > 1) {
    		return -1;
    	}
    	return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	
    	TreeNode root = new TreeNode(1);
    	
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(2);
    	
    	root.left.left = new TreeNode(3);
    	root.left.right = new TreeNode(3);
    	
    	root.left.left.left = new TreeNode(4);
    	root.left.left.right = new TreeNode(4);
    	
    	System.out.println(solution.isBalanced(root));
    }
}

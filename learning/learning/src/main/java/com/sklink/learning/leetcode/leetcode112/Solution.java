package com.sklink.learning.leetcode.leetcode112;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) {
    		return false;
    	}
    	if(root.left == null && root.right == null && root.val == sum) {
    		return true;
    	}
    	return (root.left != null && hasPathSum(root.left, sum-root.val)) || (root.right != null && hasPathSum(root.right, sum-root.val));
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	
    	TreeNode root = new TreeNode(5);
    	
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(8);
    	
    	root.left.left = new TreeNode(11);
    	root.right.left = new TreeNode(13);
    	root.right.right = new TreeNode(4);
    	
    	root.left.left.left = new TreeNode(7);
    	root.left.left.right = new TreeNode(2);
    	root.right.right.right = new TreeNode(1);
    	
    	System.out.println(solution.hasPathSum(root, 11));
    }
}

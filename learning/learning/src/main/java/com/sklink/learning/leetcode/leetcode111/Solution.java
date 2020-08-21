package com.sklink.learning.leetcode.leetcode111;

public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left != null && root.right != null) {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
		if (root.left != null) {
			return minDepth(root.left) + 1;
		}
		return minDepth(root.right) + 1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	
    	TreeNode root = new TreeNode(3);
    	
    	root.left = new TreeNode(9);
    	
    	System.out.println(solution.minDepth(root));
    }
}

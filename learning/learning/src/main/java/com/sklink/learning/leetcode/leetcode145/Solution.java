package com.sklink.learning.leetcode.leetcode145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode tmp = root;
            TreeNode prev = null;
            while(tmp != null || !stack.isEmpty()) {
            	while(tmp != null) {
            		stack.push(tmp);
            		tmp = tmp.left;
            	}
            	tmp = stack.pop();
            	/**
            	 * 
            	 */
            	if (tmp.right == null || tmp.right == prev) {
            		res.add(tmp.val);
            		prev = tmp;
            		tmp = null;
            	}else {
            		stack.push(tmp);
            		tmp = tmp.right;
            	}
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);
    	root.right.left = new TreeNode(3);
    	
    	List<Integer> list = solution.postorderTraversal(root);
    	list.forEach(System.out::println);
	}
}
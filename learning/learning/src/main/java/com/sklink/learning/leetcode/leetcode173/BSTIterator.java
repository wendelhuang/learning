package com.sklink.learning.leetcode.leetcode173;

import java.util.Stack;

class BSTIterator {

	Stack<TreeNode> stack = new Stack<>();
	
	public void leftMost(TreeNode node) {
		while(node != null) {
			stack.push(node);
			node = node.left;
		}
	}
	
    public BSTIterator(TreeNode root) {
    	leftMost(root);
    }
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
    	if (node.right != null) {
    		leftMost(node.right);
    	}
    	return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return stack.size() > 0;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		
		BSTIterator iterator = new BSTIterator(root);
		System.out.println(iterator.next());    // 返回 3
		System.out.println(iterator.next());    // 返回 7
		System.out.println(iterator.hasNext()); // 返回 true
		System.out.println(iterator.next());   // 返回 9
		System.out.println(iterator.hasNext()); // 返回 true
		System.out.println(iterator.next());    // 返回 15
		System.out.println(iterator.hasNext()); // 返回 true
		System.out.println(iterator.next());    // 返回 20
		System.out.println(iterator.hasNext()); // 返回 false
	}
}
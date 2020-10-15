package com.sklink.learning.leetcode.leetcode116;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public Node connect(Node root) {
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			int count = 1;
			Node prev = null;
			while(!queue.isEmpty()) {
				Node curr = queue.poll();
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
				if ((count & (count+1)) == 0) {
					if (prev != null) {
						prev.next = curr;
						prev = null;
					}
					curr.next = null;
				}else {
					if (prev == null) {
						prev = curr;
					}else {
						prev.next = curr;
						prev = curr;
					}
				}
				count++;
			}
		}
		return root;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node r = solution.connect(root);
		System.out.println(r);
	}
}

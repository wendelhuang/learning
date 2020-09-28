package com.sklink.learning.leetcode.leetcode117;

class Solution {
	public Node connect(Node root) {
		Node nextHead = null;
		Node currentHead = root;
        while(currentHead != null) {
        	System.out.println(currentHead.val);
        	Node tmp = currentHead;
    		Node tmp2 = null;
        	while(tmp != null) {
        		System.out.println(tmp.val);
        		if (tmp.val == 4) {
        			System.out.println();
        		}
        		if (tmp.left != null) {
        			if (nextHead == null) {
        				nextHead = tmp.left;
        				tmp2 = nextHead;
        			}else {
        				tmp2.next = tmp.left;
        				tmp2 = tmp2.next;
        			}
        		}
        		if (tmp.right != null) {
        			if (nextHead == null) {
        				nextHead = tmp.right;
        				tmp2 = nextHead;
        			}else {
        				tmp2.next = tmp.right;
        				tmp2 = tmp2.next;
        			}
        		}
        		tmp = tmp.next;
        	}
        	currentHead = nextHead;
        	nextHead = null;
        }
        return root;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		Node root = new Node(0);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.right.left = new Node(3);
		root.right.right = new Node(-1);
		root.left.left.left = new Node(5);
		root.left.left.right = new Node(1);
		root.right.left.right = new Node(6);
		root.right.right.right = new Node(8);
		Node r = solution.connect(root);
		System.out.println(r);
	}
}

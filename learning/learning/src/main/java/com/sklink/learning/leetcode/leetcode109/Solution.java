package com.sklink.learning.leetcode.leetcode109;

class Solution {
	ListNode gNode;
	public TreeNode sortedListToBST(ListNode head) {
		gNode = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }
	
	public int getLength(ListNode head) {
		ListNode tmp = head;
		int len = 0;
		while(tmp != null) {
			tmp = tmp.next;
			len++;
		}
		return len;
	}
	
	public TreeNode buildTree(int left, int right) {
		if (right < left) {
			return null;
		}
		int mid = (left+right)/2;
		TreeNode root = new TreeNode();
		root.left = buildTree(left, mid-1);
		root.val = gNode.val;
		gNode = gNode.next;
		root.right = buildTree(mid+1, right);
		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		System.out.println(solution.sortedListToBST(head));
	}
}
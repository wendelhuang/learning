package com.sklink.learning.leetcode.leetcode24;

class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode res = new ListNode();
		ListNode tail = res;
        if (head != null) {
        	ListNode slow = head;
        	ListNode fast = head.next;
        	while(slow != null && fast != null) {
        		ListNode tmp = fast.next;
        		// break
        		slow.next = null;
        		fast.next = null;
        		// conn
        		tail.next = fast;
        		tail = tail.next;
        		tail.next = slow;
        		tail = tail.next;
        		
        		slow=fast=null;
        		slow = tmp;
        		if (slow != null) {
        			fast = slow.next;
        		}
        	}
        	if (slow != null) {
        		tail.next = slow;
        	}
        }
        return res.next;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode res = solution.swapPairs(head);
		ListNode tmp = res;
		while(tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}

}
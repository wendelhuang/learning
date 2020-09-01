package com.sklink.learning.leetcode.leetcode86;

class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode tail1 = null;
		ListNode tail2 = null;
		ListNode tmp = head;
		while(tmp != null) {
			ListNode t = new ListNode(tmp.val);
			if (tmp.val < x) {
				if (tail1 == null) {
					tail1 = t;
					if (head1 == null) {
						head1 = tail1;
					}
				}else {
					tail1.next = t;
					tail1 = tail1.next;
				}
			}else {
				if (tail2 == null) {
					tail2 = t;
					if (head2 == null) {
						head2 = tail2;
					}
				}else {
					tail2.next = t;
					tail2 = tail2.next;
				}
			}
			tmp = tmp.next;
		}
		ListNode res = head1;
		if (res != null) {
			tail1.next = head2;
			return res;
		}else {
			res = head2;
			return res;
		}
    }
	
	public void print(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = 3;
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		ListNode res = solution.partition(head, x);
		solution.print(res);
	}
}
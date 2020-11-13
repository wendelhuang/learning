package com.sklink.learning.leetcode.leetcode328;

import java.util.Arrays;

class Solution {
	public ListNode oddEvenList(ListNode head) {
		if (head != null) {
			ListNode res = new ListNode();
			ListNode preTail = res;
			ListNode postHead = new ListNode();
			ListNode postTail = postHead;

			ListNode tmp = head;
			int cnt = 0;
			while(tmp != null) {
				cnt++;
				ListNode t = tmp;
				tmp = tmp.next;
				t.next = null;

				if ((cnt & 1 ) == 1) {
					t.next = preTail.next;
					preTail.next = t;
					preTail = t;
				}else{
					t.next = postTail.next;
					postTail.next = t;
					postTail = t;
				}

			}

			preTail.next = postHead.next;
			return res.next;
		}
		return head;
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
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(7);

		ListNode res = solution.oddEvenList(head);
		solution.print(res);
	}
}

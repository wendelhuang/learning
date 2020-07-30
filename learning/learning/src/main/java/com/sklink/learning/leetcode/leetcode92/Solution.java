package com.sklink.learning.leetcode.leetcode92;

class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		ListNode fHead = new ListNode(0);
		fHead.next = head;
		
		
		ListNode cur = fHead;
		ListNode begin = null;
		ListNode end = null;
		int count = 0;
		while(count < m-1) {
			cur = cur.next;
			count++;
		}
		begin = cur;
		end = cur.next;
		cur = cur.next.next;
		
		count = 0;
		while(count < n-m) {
			ListNode t1 = begin.next;
			ListNode t2 = cur;
			cur = t2.next;
			t2.next = t1;
			begin.next = t2;
			count++;
		}
		end.next = cur;
		return fHead.next;
    }
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		
		ListNode res = new Solution().reverseBetween(head, 1, 2);
		ListNode cur = res;
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}
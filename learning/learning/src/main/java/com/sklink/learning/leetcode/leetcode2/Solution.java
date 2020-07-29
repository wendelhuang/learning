package com.sklink.learning.leetcode.leetcode2;

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int add = 0;
		ListNode res = null;
		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode t3 = res;
		while(t1 != null && t2 != null) {
			int sum = t1.val + t2.val + add;
			ListNode t = new ListNode(sum%10);
			add = sum/10;
			if (res == null) {
				res = t;
				t3 = t;
			}else {
				t3.next = t;
				t3 = t3.next;
			}
			t1 = t1.next;
			t2 = t2.next;
		}
		while(t1 != null) {
			int sum = t1.val + add;
			ListNode t = new ListNode(sum%10);
			add = sum/10;
			t3.next = t;
			t3 = t3.next;
			t1 = t1.next;
		}
		while(t2 != null) {
			int sum = t2.val + add;
			ListNode t = new ListNode(sum%10);
			add = sum/10;
			t3.next = t;
			t3 = t3.next;
			t2 = t2.next;
		}
		if (add > 0) {
			ListNode t = new ListNode(add);
			t3.next = t;
			t3 = t3.next;
		}
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		System.out.println(solution.addTwoNumbers(l1, l2));
	}
}
package com.sklink.learning.leetcode.leetcode234;

public class Solution {
	boolean odd;
	public boolean isPalindrome(ListNode head) {
		if (head != null) {
			ListNode mid = findMid(head);
			ListNode re = reverseN(head, mid);
			printList(re);
			return is(re, mid);
		}
		return true;
    }
	
	public boolean is(ListNode head, ListNode mid) {
		if (head == mid) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = odd ? mid.next : mid;
		while(slow != mid) {
			if (slow.val != fast.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
	
	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		odd = fast.next == null;
		return odd ? slow : slow.next;
	}
	
	public void printList(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}
	
	public ListNode reverseN(ListNode head, ListNode mid) {
		ListNode res = new ListNode(0);
		res.next = mid;
		ListNode tmp = head;
		while(tmp != mid) {
			ListNode t = tmp;
			tmp = tmp.next;
			t.next = res.next;
			res.next = t;
		}
		return res.next;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		
		System.out.println(solution.isPalindrome(head));
	}
}

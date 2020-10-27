package com.sklink.learning.leetcode.leetcode143;

class Solution {
	public void reorderList(ListNode head) {
		if (head != null) {
			ListNode mid = findMid(head);
			ListNode head2 = mid.next;
			mid.next = null;
			head2 = reverseList(head2);
			ListNode tmp = mergeList(head, head2);
			head = tmp;
		}
        
    }
	
	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		if (head != null) {
			while(fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return slow;
	}
	
	public ListNode mergeList(ListNode head1, ListNode head2) {
		ListNode res = new ListNode();
		ListNode tail = res;
		while(head1 != null && head2 != null) {
			tail.next = head1;
			tail = tail.next;
			head1 = head1.next;
			
			tail.next = head2;
			tail = tail.next;
			head2 = head2.next;
		}
		if (head1 != null) {
			tail.next = head1;
		}
		return res.next;
	}
	
	public ListNode reverseList(ListNode head) {
		if (head != null) {
			ListNode tmp = new ListNode();
			while(head != null) {
				ListNode t = head;
				head = head.next;
				t.next = tmp.next;
				tmp.next = t;
			}
			return tmp.next;
		}
		return null;
	}
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	ListNode head = new ListNode(1);
    	//head.next = new ListNode(2);
    	//head.next.next = new ListNode(3);
    	//head.next.next.next = new ListNode(4);
    	//head.next.next.next.next = new ListNode(5);
    	
    	solution.reorderList(head);
    	
    	ListNode tmp = head;
    	while(tmp != null) {
    		System.out.println(tmp.val);
    		tmp = tmp.next;
    	}
	}
}
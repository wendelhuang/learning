package com.sklink.learning.leetcode.leetcode1694;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public String reformatNumber(String number) {
		number = number.replace(" ", "").replace("-", "");
		StringBuffer buffer = new StringBuffer();
		Queue<String> queue = new LinkedList<String>();
		int index = 0;
		while(number.length() - index > 4) {
			queue.offer(number.substring(index, index+3));
			index+=3;
		}
		if (number.length() - index == 4) {
			queue.offer(number.substring(index, index + 2));
			queue.offer(number.substring(index+2, index+4));
		}
		if (number.length() - index == 3 || number.length() - index == 2) {
			queue.offer(number.substring(index));
		}
		boolean first = true;
		while(!queue.isEmpty()) {
			if (first) {
				first = false;
			}else {
				buffer.append("-");
			}
			buffer.append(queue.poll());
		}
		return buffer.toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String number = "123 4-5678";
		String res = solution.reformatNumber(number);
		System.out.println(res);
	}
}

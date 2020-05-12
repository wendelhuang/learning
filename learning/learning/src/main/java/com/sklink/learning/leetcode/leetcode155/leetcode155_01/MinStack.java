package com.sklink.learning.leetcode.leetcode155.leetcode155_01;

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
    public MinStack() {

    }
    
    public void push(int x) {
    	if (stack.size() > 0) {
    		int v = minStack.peek();
    		minStack.push(Math.min(v, x));
    	}else {
    		minStack.push(x);
    	}
    	stack.push(x);
    }
    
    public void pop() {
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	minStack.getMin();   
    	minStack.pop();
    	minStack.top();
    	minStack.getMin();  

	}
}
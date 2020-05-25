package com.sklink.learning.leetcode.leetcode146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
	
	class DLinkedNode {
		public int key;
		public int value;
		public DLinkedNode prev;
		public DLinkedNode next;
		public DLinkedNode() {
		}
		public DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Map<Integer, DLinkedNode> cache = new HashMap<>();
	int size;
	int capacity;
	DLinkedNode head, tail;

    public LRUCache(int capacity) {
    	this.size = 0;
    	this.capacity = capacity;
    	head = new DLinkedNode();
    	tail = new DLinkedNode();
    	head.next = tail;
    	tail.next = head;
    }
    
    public void addToHead(DLinkedNode node) {
    	node.next = head.next;
    	node.next.prev = node;
    	head.next = node;
    	node.prev = head;
    }
    
    public void removeNode(DLinkedNode node) {
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    }
    
    public void moveToHead(DLinkedNode node) {
    	removeNode(node);
    	addToHead(node);
    }
    
    public DLinkedNode removeTail() {
    	DLinkedNode node = tail.prev;
    	removeNode(node);
    	return node;
    }
    
    public int get(int key) {
    	DLinkedNode node = cache.get(key);
    	if (node == null) {
    		return -1;
    	}
    	moveToHead(node);
    	return node.value;
    }
    
    public void put(int key, int value) {
    	DLinkedNode node = cache.get(key);
    	//System.out.println(String.format("key: %d, value: %d, node: %s", key, value, node));
    	if (node == null) {
    		//System.out.println(size);
    		//System.out.println(capacity);
    		node = new DLinkedNode(key, value);
    		cache.put(key, node);
    		if (size == capacity) {
    			DLinkedNode old = removeTail();
    			cache.remove(old.key);
    			size--;
    		}
    		addToHead(node);
    		size++;
    	}else {
    		node.value = value;
    		moveToHead(node);
    	}
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // 返回  1
    	cache.put(3, 3);    // 该操作会使得密钥 2 作废
    	System.out.println(cache.get(2));       // 返回 -1 (未找到)
    	cache.put(4, 4);    // 该操作会使得密钥 1 作废
    	System.out.println(cache.get(1));       // 返回 -1 (未找到)
    	System.out.println(cache.get(3));       // 返回  3
    	System.out.println(cache.get(4));       // 返回  4

	}
}
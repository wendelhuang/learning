package com.sklink.learning.leetcode.leetcode133;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public Node cloneGraph(Node node) {
        if (node == null) {
        	return null;
        }
        return cloneGraph(node, new HashMap<Integer, Node>());
    }
	
	public Node cloneGraph(Node node, Map<Integer, Node> map) {
		Node newNode = new Node(node.val);
		map.put(node.val, newNode);
		if (node.neighbors != null) {
			for(int i = 0; i < node.neighbors.size(); i++) {
				if (map.get(node.neighbors.get(i).val) != null) {
					newNode.neighbors.add(map.get(node.neighbors.get(i).val));
				}else {
					Node subNode = cloneGraph(node.neighbors.get(i), map);
					newNode.neighbors.add(subNode);
				}
			}
		}
		return newNode;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.neighbors = new ArrayList<Node>(Arrays.asList(node2, node4));
		node2.neighbors = new ArrayList<Node>(Arrays.asList(node1, node3));
		node3.neighbors = new ArrayList<Node>(Arrays.asList(node2, node4));
		node4.neighbors = new ArrayList<Node>(Arrays.asList(node1, node3));
		
		Node newNode1 = new Solution().cloneGraph(node1);
		System.out.println();
		
		
	}
}

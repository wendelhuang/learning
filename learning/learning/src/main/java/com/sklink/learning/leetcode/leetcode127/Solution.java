package com.sklink.learning.leetcode.leetcode127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		boolean endInList = false;
		for(int i = 0; i < wordList.size(); i++) {
			if (wordList.get(i).equals(endWord)) {
				endInList = true;
				break;
			}
		}
		if (!endInList) {
			return 0;
		}
		boolean beginInList = false;
		for(int i = 0; i < wordList.size(); i++) {
			if (wordList.get(i).equals(beginWord)) {
				beginInList = true;
				break;
			}
		}
		if (!beginInList) {
			wordList.add(beginWord);
		}
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        for(int i = 0; i < wordList.size(); i++) {
        	visited.put(wordList.get(i), false);
        }
        Map<String, List<String>> graph = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++) {
        	for(int j = i+1; j < wordList.size(); j++) {
        		if (dis(wordList.get(i), wordList.get(j)) == 1) {
        			List<String> l1 = graph.getOrDefault(wordList.get(i), new ArrayList<String>());
        			List<String> l2 = graph.getOrDefault(wordList.get(j), new ArrayList<String>());
        			l1.add(wordList.get(j));
        			l2.add(wordList.get(i));
        			
        			graph.put(wordList.get(i), l1);
        			graph.put(wordList.get(j), l2);
        		}
        	}
        }
        int res = 0;
        boolean reachEnd = false;
        visited.put(beginWord, true);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        while (!reachEnd && !queue.isEmpty()) {
        	int s = queue.size();
        	System.out.println("res: " + res);
        	res++;
        	for(int i = 0; i < s; i++) {
        		String str = queue.poll();
        		System.out.println("poll: " + str);
        		if (str.equals(endWord)) {
        			reachEnd = true;
        			break;
        		}
        		List<String> ll = graph.get(str);
        		if (ll != null) {
        			for(int j = 0; j < ll.size(); j++) {
        				if (!visited.get(ll.get(j))) {
        					visited.put(ll.get(j), true);
        					System.out.println("offer: " + ll.get(j));
        					queue.offer(ll.get(j));
        				}
        			}
        		}
        	}
        }
        return reachEnd ? res : 0;
    }
	
	public int dis(String w1, String w2) {
		int cnt = 0;
		for(int i = 0; i < w1.length(); i++) {
			if (w1.charAt(i) != w2.charAt(i)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList(Arrays.asList("hot","dot","dog","lot","log","cog"));
		System.out.println(solution.ladderLength(beginWord, endWord, wordList));
	}
}

package com.sklink.learning.leetcode.leetcode336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
	public TrieNode[] children;
	public int index;
	public List<Integer> suffixs;
	
	public TrieNode() {
		this.children = new TrieNode[26];
		this.index = -1;
		this.suffixs = new ArrayList<Integer>();
	}
}

public class Solution {
	public TrieNode root;
	public boolean isPalinkrome(String s) {
		int begin = 0;
		int end = s.length()-1;
		while(begin < end) {
			if (s.charAt(begin) != s.charAt(end)) {
				return false;
			}
			begin++;
			end--;
		}
		return true;
	}
	public List<List<Integer>> palindromePairs(String[] words) {
		this.root = new TrieNode();
		
		for(int i = 0; i < words.length; i++) {
			String word = new StringBuffer(words[i]).reverse().toString();
			TrieNode curr = root;
			
		}
		return null;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = new String[] {"abcd","dcba","lls","s","sssll"};
		List<List<Integer>> res = solution.palindromePairs(words);
		res.forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}

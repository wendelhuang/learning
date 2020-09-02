package com.sklink.learning.leetcode.interview17_15;

import java.util.HashMap;
import java.util.Map;

class Solution {
	class TrieNode {
		public boolean isWord = false;
		public Map<Character, TrieNode> children;
		public TrieNode() {
			this.isWord = false;
			this.children = new HashMap<>();
		}
	}
	class Trie {
		public TrieNode root;
		public Trie() {
			this.root = new TrieNode();
		}
		public void insert(String s) {
			TrieNode tmp = this.root;
			for(int i = 0; i < s.length(); i++) {
				Character ch = s.charAt(i);
				if (tmp.children.containsKey(ch)) {
					tmp = tmp.children.get(ch);
				}else {
					TrieNode t = new TrieNode();
					tmp.children.put(ch, t);
					tmp = t;
				}
				if (i == s.length()-1) {
					tmp.isWord = true;
				}
			}
		}
		public boolean inTrie(String s, int begin, int end) {
			if (begin > end) {
				return false;
			}
			TrieNode tmp = this.root;
			for(int i = begin; i <= end; i++) {
				Character ch = s.charAt(i);
				if (!tmp.children.containsKey(ch)) {
					return false;
				}
				tmp = tmp.children.get(ch);
			}
			return tmp.isWord;
		}
		public int count(String s, int begin, int end) {
			if (begin > end) {
				return 0;
			}
			TrieNode tmp = this.root;
			for(int i = begin; i <= end; i++) {
				Character ch = s.charAt(i);
				if (tmp.children.containsKey(ch)) {
					TrieNode t = tmp.children.get(ch);
					if (t.isWord) {
						int c = count(s, i+1, end);
						if (c > 0) {
							return 1 + c;
						}
					}
					tmp = t;
				}else {
					return 0;
				}
			}
			if (tmp.isWord) {
				return 1;
			}
			return 0;
		}
		public String longestWord(String[] words) {
			for(String s : words) {
				this.insert(s);
			}
			String res = "";
			for(String s : words) {
				if (count(s, 0, s.length()-1) > 1) {
					if (res.length() < s.length() || (res.length() == s.length() && s.compareTo(res) < 0)) {
						res = s;
					}
				}
			}
			return res;
		}
	}
	public String longestWord(String[] words) {
		return new Trie().longestWord(words);
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = new String[]{"cat","banana","dog","nana","walk","walker","dogwalker"};
		System.out.println(solution.longestWord(words));
	}
}

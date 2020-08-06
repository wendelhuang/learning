package com.sklink.learning.leetcode.leetcode336;

import static org.mockito.Matchers.startsWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution2 {
	class Node {
		int[] ch = new int[26];
		int flag = -1;
		
		public Node() {
			this.flag = -1;
		}
	}
	public List<Node> tree = new ArrayList<>();
	public void insert(String s, int index) {
		int len = s.length();
		int add = 0;
		for(int i = 0; i < len; i++) {
			int ch = s.charAt(i) - 'a';
			if (tree.get(add).ch[ch] == 0) {
				tree.add(new Node());
				tree.get(add).ch[ch] = tree.size()-1;
			}
			add = tree.get(add).ch[ch];
		}
		tree.get(add).flag = index;
	}
	public boolean isPalinkrome(String s, int begin, int end) {
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
		tree.add(new Node());
		for(int i = 0; i < words.length; i++) {
			insert(words[i], i);
		}
		List<List<Integer>> ret = new ArrayList<>();
		for(int i = 0; i < words.length; i++) {
			int m = words[i].length();
			for(int j = 0; j <= m; j++) {
				if (j != m && isPalinkrome(words[i], 0, j)) {
					int n = find(words[i], j+1, m-1);
					if (n != -1 && n != i) {
						ret.add(new ArrayList<>(Arrays.asList(n,i)));
					}
				}
				if (isPalinkrome(words[i], j, m-1)) {
					int n = find(words[i], 0, j-1);
					if (n != -1 && n != i) {
						ret.add(new ArrayList<>(Arrays.asList(i,n)));
					}
				}
			}
		}
		return ret;
    }
	
	public int find(String s, int begin, int end) {
		int curr = 0;
		for(int i = end; i >= begin; i--) {
			int ch = s.charAt(i) - 'a';
			curr = tree.get(curr).ch[ch];
			if (curr == 0) {
				return -1;
			}
		}
		return tree.get(curr).flag;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		String[] words = new String[] {"abcd","dcba","lls","s","sssll"};
		List<List<Integer>> res = solution.palindromePairs(words);
		res.forEach(e -> {
			System.out.println(Arrays.toString(e.toArray()));
		});
	}
}

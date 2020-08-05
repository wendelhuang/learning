package com.sklink.learning.leetcode.leetcode318;

class Solution {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		int[] bitmap = new int[words.length];
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < words[i].length(); j++) {
				bitmap[i] |= 1<<(words[i].charAt(j)-'a');
			}
		}
		int res = 0;
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < i; j++) {
				if ((bitmap[i] & bitmap[j]) == 0) {
					res = Math.max(res, words[i].length()*words[j].length());
					//System.out.println(String.format("i: %d, j: %d, res: %d", i, j, res));
				}
			}
		}
		return res;
    }

	public static void main(String[] args) {
		String[] words = new String[] {"abcw","baz","foo","bar","xtfn","abcdef"};
		Solution solution = new Solution();
		int res = solution.maxProduct(words);
		System.out.println(res);
	}
}
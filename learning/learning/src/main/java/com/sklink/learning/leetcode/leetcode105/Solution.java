package com.sklink.learning.leetcode.leetcode105;

class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, preorder.length-1, 0, preorder.length-1);
    }
	public TreeNode buildTree(int[] preorder, int[] inorder, int begin1, int end1, int begin2, int end2) {
		if (begin1 <= end1) {
			TreeNode t = new TreeNode(preorder[begin1]);
			if (begin1 < end1) {
				int leftLen = 0;
				for(int i = begin2; i <= end2; i++) {
					if (inorder[i] == preorder[begin1]) {
						break;
					}
					leftLen++;
				}
				int rightLen = end1-begin1+1-leftLen;
				if (leftLen > 0) {
					t.left = buildTree(preorder, inorder, begin1+1, begin1+leftLen, begin2, begin2+leftLen-1);
				}
				if (rightLen > 0) {
					t.right = buildTree(preorder, inorder, begin1+leftLen+1, end1, begin2+leftLen+1, end2);
				}
			}
			return t;
		}
		return null;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		System.out.println(solution.buildTree(preorder, inorder));
	}
}
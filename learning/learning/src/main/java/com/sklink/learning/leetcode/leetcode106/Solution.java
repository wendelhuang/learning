package com.sklink.learning.leetcode.leetcode106;


class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
	public TreeNode buildTree(int[] inorder, int[] postorder, int begin1, int end1, int begin2, int end2) {
		if (begin1 <= end1) {
			TreeNode t = new TreeNode(postorder[end2]);
			if (begin1 < end1) {
				int i = begin1;
				for(i = begin1; i <= end1; i++) {
					if (inorder[i] == postorder[end2]) {
						break;
					}
				}

				int leftLen = i - begin1;
				int rightLen = end1-begin1+1-leftLen-1;
				if (leftLen > 0) {
					t.left = buildTree(inorder, postorder, begin1, begin1+leftLen-1, begin2, begin2+leftLen-1);
				}
				if (rightLen > 0) {
					t.right = buildTree(inorder, postorder, begin1+leftLen+1, end1, begin2+leftLen, begin2+leftLen+rightLen-1);
				}
			}
			return t;
		}
		return null;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode n = solution.buildTree(inorder, postorder);
		System.out.println(solution.buildTree(inorder, postorder));
	}
}
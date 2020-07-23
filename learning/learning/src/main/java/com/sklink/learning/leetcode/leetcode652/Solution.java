package com.sklink.learning.leetcode.leetcode652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	
	public Map<String, Integer> map = new HashMap<String, Integer>();
	public List<TreeNode> res = new ArrayList<TreeNode>();
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
	public String dfs(TreeNode root) {
		if (root == null) {
			return "#";
		}
		String p = String.format("%d,%s,%s", root.val, dfs(root.left), dfs(root.right));
		map.put(p, map.getOrDefault(p, 0) + 1);
		if (map.get(p) == 2) {
			res.add(root);
		}
		return p;
	}
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		
		root.right.left.left = new TreeNode(4);
		Solution solution = new Solution();
		List<TreeNode> ress = solution.findDuplicateSubtrees(root);
		for (int i = 0; i < ress.size(); i++) {
			System.out.println(ress.get(i).val);
		}
	}
}
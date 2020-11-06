package com.sklink.learning.leetcode.leetcode1356;

import java.util.Arrays;

class Solution {
	class Node implements Comparable<Node>{
		public int bitCnt;
		public int num;
		Node(){}
		Node(int bitCnt, int num) {
			this.bitCnt = bitCnt;
			this.num = num;
		}
		Node(int num) {
			this.num = num;
			this.bitCnt = 0;
			while(num > 0) {
				this.bitCnt++;
				num = num & (num-1);
			}
		}
		@Override
		public int compareTo(Node o) {
			if (this.bitCnt < o.bitCnt) {
				return -1;
			}else if (this.bitCnt == o.bitCnt) {
				return this.num - o.num;
			}else {
				return 1;
			}
		}
	}
	public int[] sortByBits(int[] arr) {
		Node[] nodes = new Node[arr.length];
		for(int i = 0; i < arr.length; i++) {
			nodes[i] = new Node(arr[i]);
		}
		Arrays.sort(nodes);
		int[] res = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			res[i] = nodes[i].num;
		}
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = new int[] {1024,512,256,128,64,32,16,8,4,2,1};
		int[] res = solution.sortByBits(arr);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
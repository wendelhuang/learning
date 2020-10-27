package com.sklink.learning.leetcode.leetcode1626;

import java.util.Arrays;

public class Solution {
	class Node implements Comparable<Node> {
		int score, age;
		Node(){}
		Node(int score, int age) {
			this.score = score;
			this.age = age;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public int compareTo(Node o) {
			if (this.age < o.age) {
				return -1;
			}else if (this.age == o.age) {
				if (this.score < o.score) {
					return -1;
				}else if (this.score == o.score) {
					return 0;
				}else {
					return 1;
				}
			}else {
				return 1;
			}
		}
		@Override
		public String toString() {
			return "Node [score=" + score + ", age=" + age + "]";
		}
		
	}
	public int bestTeamScore(int[] scores, int[] ages) {
		int res = 0;
		Node[] nodes = new Node[scores.length];
		for(int i = 0; i < scores.length; i++) {
			nodes[i] = new Node(scores[i], ages[i]);
		}
		Arrays.sort(nodes);
		//System.out.println(Arrays.toString(nodes));
		int[] dp = new int[scores.length];
		for(int i = 0; i < scores.length; i++) {
			dp[i] = nodes[i].score;
		}
		for(int i = 0; i < scores.length; i++) {
			for(int j = i+1; j < scores.length; j++) {
				//System.out.println(Arrays.toString(new int[] {i, j}));
				if (nodes[i].score <= nodes[j].score) {
					dp[j] = Math.max(dp[j], dp[i] + nodes[j].score);
				}
			}
		}
		for(int i = 0; i < scores.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] scores = new int[] {1,1,1,1,1,1,1,1,1,1};
		int[] ages = new int[] {811,364,124,873,790,656,581,446,885,134};
		System.out.println(solution.bestTeamScore(scores, ages));
	}
}

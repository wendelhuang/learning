package com.sklink.learning.leetcode.leetcode406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Solution {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o2[1]-o1[1] : o1[0]-o2[0];
				}
				});

		int[][] res = new int[people.length][];
		for(int i = 0; i < people.length; i++) {
			int cnt = people[i][1] + 1;
			for(int j = 0; j < people.length; j++) {
				if (res[j] == null) {
					cnt--;
					if (cnt == 0) {
						res[j] = people[i];
						break;
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] people = new int[][] {
			new int[] {7, 0},
				new int[] {4, 4},
				new int[] {7, 1},
				new int[] {5, 0},
				new int[] {6, 1},
				new int[] {5, 2}
		};

		int[][] res = solution.reconstructQueue(people);

		Stream.of(res).forEach(e -> System.out.println(Arrays.toString(e)));
	}
}

/*
   输入:
   [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

   输出:
   [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

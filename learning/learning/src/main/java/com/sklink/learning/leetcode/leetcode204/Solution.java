package com.sklink.learning.leetcode.leetcode204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int countPrimes(int n) {
		List<Integer> primes = new ArrayList<>();
		int[] arr = new int[5000000 + 5];
		for(int i = 2; i <= n; i++) {
			arr[i] = 1;
		}
		int sum = 0;
		for(int i = 2; i < Math.sqrt(n); i++) {
			if (arr[i] == 1) {
				for(int j = 2; i*j <= n; j++) {
					if (arr[i*j] == 1) {
						arr[i*j] = 0;
					}
				}
			}
		}
		for(int i = 2; i < n; i++) {
			if (arr[i] == 1) {
				sum++;
			}
		}
		return sum;
    }
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 10;
		System.out.println(solution.countPrimes(n));
	}
}

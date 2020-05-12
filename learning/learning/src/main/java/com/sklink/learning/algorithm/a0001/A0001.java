package com.sklink.learning.algorithm.a0001;

public class A0001 {
	public void work(int[] arr, int n) {
		int index = 1;
		while (index <= n) {
			/**
			 * 当前出现了一次num
			 */
			int num = arr[index];
			if (num <= 0) {
				index++;
			}else {
				/**
				 * v = 0： 当前num的数量为0
				 * v < 0: -v是当前num数量
				 * v > 0: 当前num数量0 还保存着其他数据
				 */
				int v = arr[num];
				if (v <= 0) {
					arr[index] = 0;
					arr[num]--;
				}else {
					arr[index] = arr[num];
					arr[num] = -1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 2, 3, 3, 1, 6, 5};
		int n = 6;
		for(int v : arr) {
			System.out.print(" " + v);
		}
		System.out.println();
		A0001 a0001 = new A0001();
		a0001.work(arr, n);
		for(int v : arr) {
			System.out.print(" " + v);
		}
		System.out.println();
	}
}

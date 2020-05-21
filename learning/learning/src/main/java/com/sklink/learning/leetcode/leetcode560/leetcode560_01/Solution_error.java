package com.sklink.learning.leetcode.leetcode560.leetcode560_01;

class Solution_error {
	/**
	 * 此解法默认数据都为正数
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		int res = 0;
		int i = 0;
		int j = i;
		int cur = nums[i];
		for(; i < nums.length && j < nums.length;) {
			if (cur == k) {
				res++;
				System.out.println(String.format("i = %d, j = %d", i, j));
				cur -= nums[i++];
			}
			while(i < nums.length && cur > k) {
				System.out.println(String.format("move i = %d", i));
				cur -= nums[i++];
			}
			while(j < nums.length && cur < k) {
				System.out.println(String.format("move j = %d", j));
				if (j < nums.length - 1) {
					cur += nums[++j];
				}else {
					j++;
				}
			}
		}
		return res;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-1, -1, 1};
		int k = 0;
		System.out.println(solution.subarraySum(nums, k));
	}
}
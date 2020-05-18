package com.sklink.learning.leetcode.leetcode53.leetcode53_01;

class Solution {
	class Status {
		public int lSum, rSum, mSum, iSum;
		public Status(int lSum, int rSum, int mSum, int iSum) {
			this.lSum = lSum;
			this.rSum = rSum;
			this.mSum = mSum;
			this.iSum = iSum;
		}
	}
	public Status pushUp(Status lSub, Status rSub) {
		int iSum = lSub.iSum + rSub.iSum;
		int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
		int rSum = Math.max(rSub.rSum, rSub.iSum + lSub.rSum);
		int mSum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);
		return new Status(lSum, rSum, mSum, iSum);
	}
	
	public Status getInfo(int[] a, int l, int r) {
		if (l == r) {
			return new Status(a[l], a[l], a[l], a[l]);
		}
		int m = (l+r) >> 1;
		Status lSub = getInfo(a, l, m);
		Status rSub = getInfo(a, m+1, r);
		return pushUp(lSub, rSub);
	}
    public int maxSubArray(int[] nums) {
    	return getInfo(nums, 0, nums.length-1).mSum;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(arr));
	}
}
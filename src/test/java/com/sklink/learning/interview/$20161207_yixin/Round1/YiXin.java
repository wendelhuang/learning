package com.sklink.learning.interview.$20161207_yixin.Round1;

import org.junit.Test;

import java.util.Stack;

public class YiXin {

    /**
     * Q: 有一个柱状图，柱状图柱的宽度为1，连成片的柱状图中可以分割出矩形，求图中连成片的柱状图的最大面积
     *
     * leecode的第84题
     */
    @Test
    public void test101() {
        /**
         * 暴力破解
         */
        int[] arr = {2,1,5,6,2,3};
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int minHeight = arr[i];
            for(int j = i ; j < arr.length; j++) {
                if (minHeight > arr[j]) {
                    minHeight = arr[j];
                }
                int maxAreaCurrent = (j - i + 1) * minHeight;
                if (max < maxAreaCurrent) {
                    max = maxAreaCurrent;
                }
            }
        }
        System.out.println(max);
    }

    @Test
    public void test102() {
        /**
         * 单调栈解法
         */
        int[] arr = {2,1,5,6,2,3};
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int[] brr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }
        brr[brr.length-1] = 0;

        /*for(int i = 0; i < arr.length; i++) {
            while(!stack.empty() && arr[stack.peek()] >= arr[i]) {
                System.out.println("arr[" + stack.peek() + "]=" + arr[stack.peek()] + ", arr[" + i + "]=" + arr[i]);
                System.out.println("pop " + stack.peek());
                int top = stack.peek();
                stack.pop();
                max = Math.max(max, arr[top] * (stack.empty() ? 1 : (i - top - 1)));
            }
            System.out.println("push " + i);
            stack.push(i);
        }*/

        for(int i = 0; i < arr.length; i++) {
            if (stack.size() <= 0 || arr[stack.peek()] < arr[i]) {
                stack.push(i);
            }else {
                while(stack.size() >= 0 && arr[stack.peek()] < arr[i]) {

                }
            }
        }
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.peek()*stack.size());
        System.out.println(max);
    }
}

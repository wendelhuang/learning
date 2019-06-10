package com.sklink.learning.forkJoin.test01;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class CountTask extends RecursiveTask<Long> {
    private long begin, end;
    public CountTask(long begin, long end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        System.out.println(String.format("Thread: %s, begin: %d, end: %d", Thread.currentThread().getName(), this.begin, this.end));
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (end - begin == 0) {
            return end;
        }
        long mid = (begin + end)/2;
        CountTask left = new CountTask(begin, mid);
        CountTask right = new CountTask(mid+1, end);
        left.fork();
        right.fork();
        /**
         * this.invokeAll(left, right);
         * */
        long leftResult = left.join();
        long rightResult = right.join();
        return leftResult + rightResult;
    }
}

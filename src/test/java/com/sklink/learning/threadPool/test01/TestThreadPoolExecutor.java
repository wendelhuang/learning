package com.sklink.learning.threadPool.test01;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            boolean exception = false;
            int count = 0;
            Random random = new Random();
            while(true) {
                int temp = random.nextInt(100);

                System.out.println(String.format("Thread: %s, exception: %b, count: %d, temp: %d",
                        Thread.currentThread().getId(), exception, count, temp));

                if (!exception && temp > 90) {
                    int createException = 1/0;
                }
            }
        });

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(executorService.isTerminated());
        executorService.execute(() -> {
            boolean exception = false;
            int count = 0;
            Random random = new Random();
            while(true) {
                int temp = random.nextInt(100);

                System.out.println(String.format("Thread: %s, exception: %b, count: %d, temp: %d",
                        Thread.currentThread().getId(), exception, count, temp));

                if (!exception && temp > 90) {
                    int createException = 1/0;
                }
            }
        });
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

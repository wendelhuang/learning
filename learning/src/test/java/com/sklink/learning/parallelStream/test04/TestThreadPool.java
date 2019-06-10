package com.sklink.learning.parallelStream.test04;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestThreadPool {
    List<Integer> list;

    @Before
    public void before() {
        list = Stream.iterate(0, i -> i+1).limit(1000).collect(Collectors.toList());
    }

    @Test
    public void test() {
        List<String> printMessage1 = list.parallelStream().map(i -> {
            String str = String.format("Example1 Thread: %s", Thread.currentThread().getName());

            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str);
            return str;
        }).collect(Collectors.toList());
        System.out.println("------------------------");
        List<String> printMessage2 = list.parallelStream().map(i -> {
            String str = String.format("Example2 Thread: %s", Thread.currentThread().getName());

            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str);
            return str;
        }).collect(Collectors.toList());

        List<String> message1Distinct = printMessage1.stream().distinct().collect(Collectors.toList());
        List<String> message2Distinct = printMessage2.stream().distinct().collect(Collectors.toList());

        System.out.println("------------------------");
        message1Distinct.forEach(System.out::println);
        System.out.println("------------------------");
        message2Distinct.forEach(System.out::println);
    }
}

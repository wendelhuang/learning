package com.sklink.learning.parallelStream.test03;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollectorsThreadSafe {
    List<Integer> list;

    @Before
    public void before() {
        list = Stream.iterate(0, i -> i+1).limit(1000).collect(Collectors.toList());
    }

    @Test
    public void test() {
        List<String> printMessage = list.parallelStream().map(i -> {
            String str = String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i);
            System.out.println(str);
            return str;
        }).collect(Collectors.toList());

        long mainThreadExeTimes = printMessage.stream().filter(str -> str.contains("main")).count();
        long poolThreadExeTimes = printMessage.stream().filter(str -> str.contains("ForkJoinPool")).count();

        System.out.println(String.format("Total: %d, main: %d, pool: %d", printMessage.size(), mainThreadExeTimes, poolThreadExeTimes));
    }
}

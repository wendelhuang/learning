package com.sklink.learning.parallelStream.test02;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestThread {

    List<Integer> list;

    @Before
    public void before() {
        list = Stream.iterate(0, i -> i+1).limit(1000).collect(Collectors.toList());
    }

    @Test
    public void test() {
        list.parallelStream().forEach(i -> {
            System.out.println(String.format("Thread: %s, i: %d", Thread.currentThread().getName(), i));
        });
    }
}

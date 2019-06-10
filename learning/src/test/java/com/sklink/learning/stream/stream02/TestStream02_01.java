package com.sklink.learning.stream.stream02;

import org.junit.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream02_01 {
    @Test
    public void test() {
        Map<Integer, Integer> map = Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toMap(Function.identity(), i -> i*i));
        map.forEach(
                (k, v) -> System.out.println(String.format("%d -> %d", k, v))
        );
    }

    /**
     * 解决重复key的问题
     * (v1, v2) -> v1 重复时取第一个
     * (v1, v2) -> v2 重复时取第二个
     */
    @Test
    public void test2() {
        Map<Integer, Integer> map = Stream.iterate(0, i -> i).limit(10).collect(Collectors.toMap(Function.identity(), i -> i*i, (v1, v2) -> v1));
        map.forEach(
                (k, v) -> System.out.println(String.format("%d -> %d", k, v))
        );
    }
}

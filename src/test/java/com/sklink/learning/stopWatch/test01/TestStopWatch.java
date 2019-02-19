package com.sklink.learning.stopWatch.test01;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStopWatch {
    List<Integer> smallList;
    List<Integer> mediumList;
    List<Integer> largeList;

    @Before
    public void before() {
        smallList = Stream.iterate(0, i -> i+1).limit(10).collect(Collectors.toList());
        mediumList = Stream.iterate(0, i -> i+1).limit(1000).collect(Collectors.toList());
        largeList = Stream.iterate(0, i -> i+1).limit(1000000).collect(Collectors.toList());
    }

    @Test
    public void test() {
        StopWatch stopWatch = new StopWatch("Stream VS ParallelStream");
        stopWatch.start("smallList Stream");
        smallList.stream().map(i -> {
            String str = "" + i;
            return str;
        }).collect(Collectors.toList());
        stopWatch.stop();
        stopWatch.start("smallList ParallelStream");
        smallList.parallelStream().map(i -> {
            String str = "" + i;
            return str;
        }).collect(Collectors.toList());
        stopWatch.stop();

        stopWatch.start("mediumList Stream");
        mediumList.stream().map(i -> {
            String str = "" + i;
            return str;
        }).collect(Collectors.toList());
        stopWatch.stop();
        stopWatch.start("mediumList ParallelStream");
        mediumList.parallelStream().map(i -> {
            String str = "" + i;
            return str;
        }).collect(Collectors.toList());
        stopWatch.stop();


        stopWatch.start("largeList Stream");
        largeList.stream().map(i -> {
            String str = "" + i;
            return str;
        }).collect(Collectors.toList());
        stopWatch.stop();
        stopWatch.start("largeList ParallelStream");
        largeList.parallelStream().map(i -> {
            String str = "" + i;
            return str;
        }).collect(Collectors.toList());
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }

}

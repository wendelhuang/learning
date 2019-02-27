package com.sklink.learning.effectiveJava.E41.E41_03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test41_03 {

    @Test
    public void test() {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for(int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }

        System.out.println(set + "" + list);
    }
}

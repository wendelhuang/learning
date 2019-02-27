package com.sklink.learning.effectiveJava.E41.E41_01;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

public class Test41_01 {
    public String classify(Set<?> s) {
        return "set";
    }
    public String classify(List<?> list) {
        return "list";
    }
    public String classify(Collection<?> collection) {
        return "collection";
    }

    @Test
    public void test() {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        System.out.println(classify(new HashSet<String>()));
        System.out.println(classify(new ArrayList<BigInteger>()));
        System.out.println(classify(new HashMap<String, String>().values()));
        for(Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }

}

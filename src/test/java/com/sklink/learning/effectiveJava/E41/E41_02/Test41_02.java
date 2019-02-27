package com.sklink.learning.effectiveJava.E41.E41_02;

import org.junit.Test;

public class Test41_02 {

    @Test
    public void test() {
        Wine[] wines = {
                new Wine(),
                new SparklingWine(),
                new Champagne()
        };

        for(Wine wine : wines) {
            System.out.println(wine.name());
        }
    }
}

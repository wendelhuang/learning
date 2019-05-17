package com.sklink.learning.dp.proxy01.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class TestAnimalImplCglib {
    public static void main(String[] args) {
        AnimalImpl animal = new AnimalImpl();
        Enhancer e = new Enhancer();
        e.setSuperclass(AnimalImpl.class);
    }
}

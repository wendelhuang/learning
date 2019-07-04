package com.sklink.learning.dp.proxy01.jdk;

public class AnimalImpl implements IAnimal {
    @Override
    public void say() {
        System.out.println("cat");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}

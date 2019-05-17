package com.sklink.learning.dp.proxy01.cglib;

public class TestAnimalImplMain {
    public static void main(String[] args) {
        AnimalImpl animal = new AnimalImpl();
        AnimalImpl animal1 = (AnimalImpl) new AnimalMethodInterceptor().getInstance(animal);
        animal1.say();
        animal1.eat();
    }
}

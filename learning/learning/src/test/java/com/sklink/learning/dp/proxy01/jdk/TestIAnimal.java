package com.sklink.learning.dp.proxy01.jdk;

import java.lang.reflect.Proxy;

public class TestIAnimal {
    public static void main(String[] args) {
        IAnimal animal = new AnimalImpl();
        AnimalHandler animalHandler = new AnimalHandler(animal);

        IAnimal proxy = (IAnimal) Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(), animalHandler);
        proxy.say();
        proxy.eat();

    }
}

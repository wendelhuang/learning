package com.sklink.learning.framework.reflect01;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestReflect01 {
    public static void main(String[] args) {
        new B();
    }
}


class A<T, S> {
    public A() {
        Class clazz = this.getClass();
        System.out.println(clazz.getName());

        Type genericSuperClass = clazz.getGenericSuperclass();
        System.out.println(genericSuperClass);
        System.out.println(genericSuperClass.getClass());
        System.out.println(genericSuperClass.getTypeName());

        Type[] actualTypeArguments = ((ParameterizedType)genericSuperClass).getActualTypeArguments();
        for(int i = 0; i < actualTypeArguments.length; i++) {
            System.out.println(String.format("actualTypeArguments[%d] = %s", i, actualTypeArguments[i]));
        }
        Class actualTypeArgument = (Class) actualTypeArguments[0];
        System.out.println(actualTypeArgument);
        System.out.println(actualTypeArgument.getName());
    }
}

class B extends A<String, Integer> {
}

class C extends A<Integer, String> {
}
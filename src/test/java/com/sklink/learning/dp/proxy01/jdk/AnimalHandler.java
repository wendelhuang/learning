package com.sklink.learning.dp.proxy01.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalHandler implements InvocationHandler {
    private Object object;
    public AnimalHandler(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(object, args);
        System.out.println("end");
        return result;
    }
}

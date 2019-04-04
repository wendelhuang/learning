package com.sklink.learning.framework.annotation01;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyJUnitFramework {
    public static void main(String[] args) throws Exception {
        Class clazz = EmployeeDAOTest.class;
        Object object = clazz.newInstance();

        Method[] methods = clazz.getMethods();

        List<Method> myBeforeList = Arrays.stream(methods).filter(m -> m.isAnnotationPresent(MyBefore.class)).collect(Collectors.toList());
        List<Method> myTestList = Arrays.stream(methods).filter(m -> m.isAnnotationPresent(MyTest.class)).collect(Collectors.toList());
        List<Method> myAfterList = Arrays.stream(methods).filter(m -> m.isAnnotationPresent(MyAfter.class)).collect(Collectors.toList());

        for(Method m : myTestList) {
            for(Method beforeMethod : myBeforeList) {
                beforeMethod.invoke(object);
            }
            m.invoke(object);
            for(Method afterMethod : myAfterList) {
                afterMethod.invoke(object);
            }
        }
    }
}

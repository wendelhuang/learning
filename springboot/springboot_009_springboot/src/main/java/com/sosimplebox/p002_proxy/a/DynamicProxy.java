package com.sosimplebox.p002_proxy.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
	
	Object object;
	
	public DynamicProxy(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("method".equals(method.getName())) {
			System.out.println("before dynamicProxy");
			method.invoke(object, args);
			System.out.println("after dynamicProxy");
		}else if ("method1".equals(method.getName())) {
			System.out.println("before dynamicProxy1");
			method.invoke(object, args);
			System.out.println("after dynamicProxy1");
		}
		return null;
	}
	

}

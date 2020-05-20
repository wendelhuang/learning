package com.sosimplebox.p003_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	private Interceptor interceptor;
	
	public DynamicProxy(Object object, Interceptor interceptor) {
		super();
		this.interceptor = interceptor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object intercept = interceptor.intercept();
		System.out.println("我收到了: " + intercept);
		return intercept;
	}

}

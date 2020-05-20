package com.sosimplebox.p003_proxy;

import java.lang.reflect.Proxy;

import com.sosimplebox.p002_proxy.a.Source;
import com.sosimplebox.p002_proxy.a.Sourceable;

public class DynamicProxyTest {
	public static void main(String[] args) {
		Sourceable source = new Source();
		
		Interceptor interceptor = () -> new Double(Math.random() * 10).intValue();
		
		DynamicProxy dynamicProxy = new DynamicProxy(source, interceptor);
		
		Sourceable sourceProxy = (Sourceable) Proxy.newProxyInstance(Source.class.getClassLoader(), Source.class.getInterfaces(), dynamicProxy);
		
		sourceProxy.method();
		System.out.println("----------------------");
		sourceProxy.method1();
	}
}

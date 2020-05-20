package com.sosimplebox.p002_proxy.a;

import java.lang.reflect.Proxy;

public class TestProxy {
	public static void main(String[] args) {
		Sourceable source = new Source();
		DynamicProxy dynamicProxy = new DynamicProxy(source);
		Sourceable sourceProxy = (Sourceable) Proxy.newProxyInstance(Source.class.getClassLoader(), Source.class.getInterfaces(), dynamicProxy);
		sourceProxy.method();
		sourceProxy.method1();
	}
}

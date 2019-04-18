package com.sklink.learning.dp.dpInRunoob.$12proxyPattern;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("testProxy.jpg");
		
		image.display();
		
		image.display();

	}

}

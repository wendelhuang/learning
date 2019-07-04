package com.sklink.learning.classLoader.classLoader002;

import org.junit.Test;

public class ClassLoader002_ClassForName_Test {
	@Test
	public void test() {
		try {
			Class.forName("com.sklink.learning.classLoader.classLoader002.ClassLoader002_ClassForName");
			
			System.out.println("----------上面是Class.forName的加载过程, 下面是ClassLoader的加载过程-------------");
			
			ClassLoader.getSystemClassLoader().loadClass("com.sklink.learning.classLoader.classLoader002.ClassLoader002_ClassForName");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

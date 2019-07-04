package com.sklink.learning.classLoader.classLoader001;

import java.io.InputStream;

public class TestClassLoader001_003_MyClassLoader extends ClassLoader {
	public TestClassLoader001_003_MyClassLoader() {
		super();
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println(String.format("---------loadClass %s-------------", name));
		try {
			String className = null;
			if (name != null && !"".equals(name)) {
				if (name.startsWith("java.lang")) {
					className = new StringBuilder("/").append(name.replace(".", "/")).append(".class").toString();
				}else {
					className = new StringBuffer(name.substring(name.lastIndexOf('.') + 1)).append(".class").toString();
				}
				System.out.println(className);
				InputStream is = getClass().getResourceAsStream(className);
				System.out.println(is);
				if (is == null) {
					return super.loadClass(name);
				}
				byte[] bytes = new byte[is.available()];
				is.read(bytes);
				return defineClass(name, bytes, 0, bytes.length);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ClassNotFoundException();
		}
		return super.loadClass(name);
	}
}

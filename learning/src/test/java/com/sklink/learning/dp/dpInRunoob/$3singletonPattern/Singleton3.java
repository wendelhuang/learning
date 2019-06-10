package com.sklink.learning.dp.dpInRunoob.$3singletonPattern;

public class Singleton3 {
	private static Singleton3 instance = new Singleton3();
	private Singleton3(){}
	public Singleton3 getInstance() {
		return instance;
	}
}

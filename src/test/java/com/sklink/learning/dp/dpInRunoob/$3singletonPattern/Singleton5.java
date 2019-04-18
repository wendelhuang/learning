package com.sklink.learning.dp.dpInRunoob.$3singletonPattern;

public class Singleton5 {
	private static class SingletonHolder {
		private static Singleton5 INSTANCE = new Singleton5();
	}
	private Singleton5(){}
	public static Singleton5 getInstance () {
		return SingletonHolder.INSTANCE;
	}
}

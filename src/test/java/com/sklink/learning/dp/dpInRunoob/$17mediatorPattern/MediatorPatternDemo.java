package com.sklink.learning.dp.dpInRunoob.$17mediatorPattern;

public class MediatorPatternDemo {
	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");
		
		robert.sendMessage("Hi, John!");
		john.sendMessage("Hello! Robert!");
	}
}

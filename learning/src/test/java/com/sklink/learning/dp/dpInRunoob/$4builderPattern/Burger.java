package com.sklink.learning.dp.dpInRunoob.$4builderPattern;

public abstract class Burger implements Item {
	public Packing packing() {
		return new Wrapper();
	}
	public abstract float price();
}

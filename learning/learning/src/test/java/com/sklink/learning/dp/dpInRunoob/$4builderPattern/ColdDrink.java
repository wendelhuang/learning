package com.sklink.learning.dp.dpInRunoob.$4builderPattern;

public abstract class ColdDrink implements Item {
	public Packing packing() {
		return new Bottle();
	}
	public abstract float price();
}

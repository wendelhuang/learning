package com.sklink.learning.dp.dpInRunoob.$7birdgePattern;

public abstract class Shape {
	protected DrawAPI drawAPI;
	protected Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}
	public abstract void draw();
}

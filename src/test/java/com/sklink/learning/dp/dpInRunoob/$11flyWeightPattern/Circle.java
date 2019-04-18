package com.sklink.learning.dp.dpInRunoob.$11flyWeightPattern;

public class Circle implements Shape {
	private String color;
	private int x, y, radius;
	

	@Override
	public void draw() {
		System.out.println(String.format("Draw circle: color=[%s], x=%d, y=%d, radius=%d", color, x, y, radius));
		
	}
	
	public Circle(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}

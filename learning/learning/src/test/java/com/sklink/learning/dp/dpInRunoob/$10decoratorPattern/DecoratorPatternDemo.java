package com.sklink.learning.dp.dpInRunoob.$10decoratorPattern;

public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Shape circle = new Circle();
		System.out.println("Circle with normal border");
		circle.draw();
		
		Shape redCircle = new RedShapeDecorator(new Circle());
		System.out.println("Circle with red border");
		redCircle.draw();
		
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Rectangle with red border");
		redRectangle.draw();
	}
}

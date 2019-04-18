package com.sklink.learning.dp.dpInRunoob.$1factoryPattern;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape rectangle = shapeFactory.getShape("RECTANGLE");
		rectangle.draw();
		
		Shape square = shapeFactory.getShape("SQUARE");
		square.draw();
		
		Shape circle = shapeFactory.getShape("CIRCLE");
		circle.draw();
	}
}

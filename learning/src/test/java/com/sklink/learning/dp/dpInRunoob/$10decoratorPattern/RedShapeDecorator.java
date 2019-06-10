package com.sklink.learning.dp.dpInRunoob.$10decoratorPattern;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	public void draw() {
		setRedBorder(decoratedShape);
		decoratedShape.draw();
	}
	
	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border color: red");
	}

}

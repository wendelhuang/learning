package com.sklink.learning.dp.dpInRunoob.$2abstractFactoryPattern;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		if (shape == null) {
			return null;
		}
		if (shape.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}
		if (shape.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		if (shape.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		return null;
	}

}

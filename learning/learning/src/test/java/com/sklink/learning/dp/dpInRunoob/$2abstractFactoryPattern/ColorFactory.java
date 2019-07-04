package com.sklink.learning.dp.dpInRunoob.$2abstractFactoryPattern;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		}
		if (color.equalsIgnoreCase("GREEN")) {
			return new Green();
		}
		if (color.equals("BLUE")) {
			return new Blue();
		}
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}

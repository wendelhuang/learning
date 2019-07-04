package com.sklink.learning.dp.dpInRunoob.$11flyWeightPattern;

import java.util.HashMap;

public class ShapeFactory {
	private static final HashMap<String, Shape> shapeMap = new HashMap<>();
	
	public static Shape getShape(String color) {
		Shape shape = shapeMap.get(color);
		if (shape == null) {
			shape = new Circle(color);
			shapeMap.put(color, shape);
			System.out.println(String.format("Create shape of color [%s]", color));
		}
		return shape;
	}
}

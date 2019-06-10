package com.sklink.learning.dp.dpInRunoob.$5prototypePattern;

import java.util.concurrent.ConcurrentHashMap;

public class ShapeCache {
	private static ConcurrentHashMap<String, Shape> shapeMap = new ConcurrentHashMap<>();
	
	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}
	
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);
		
		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}

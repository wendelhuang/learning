package com.sklink.learning.dp.dpInRunoob.$2abstractFactoryPattern;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		
		Shape rectangle = shapeFactory.getShape("RECTANGLE");
		rectangle.draw();
		Shape square = shapeFactory.getShape("SQUARE");
		square.draw();
		Shape circle = shapeFactory.getShape("CIRCLE");
		circle.draw();
		
		Color red = colorFactory.getColor("RED");
		red.fill();
		Color green = colorFactory.getColor("GREEN");
		green.fill();
		Color blue = colorFactory.getColor("BLUE");
		blue.fill();

	}

}

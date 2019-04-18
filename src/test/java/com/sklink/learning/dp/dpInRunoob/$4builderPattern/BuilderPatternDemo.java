package com.sklink.learning.dp.dpInRunoob.$4builderPattern;

public class BuilderPatternDemo {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();
		
		Meal vegMeal = mealBuilder.prepareVegMeal();
		vegMeal.showItems();
		System.out.println(String.format("Veg Meal total cost: %f", vegMeal.getCost()));
		
		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		nonVegMeal.showItems();
		System.out.println(String.format("Non Veg Meal total cost: %f", nonVegMeal.getCost()));
	}
}

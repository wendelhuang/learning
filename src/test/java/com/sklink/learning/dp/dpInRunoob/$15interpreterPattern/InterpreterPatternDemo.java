package com.sklink.learning.dp.dpInRunoob.$15interpreterPattern;

public class InterpreterPatternDemo {
	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}
	public static Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}
	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		
		System.out.println(String.format("John is male? %b", isMale.interpret("John")));
		System.out.println(String.format("Julie is a married woman? %b", isMarriedWoman.interpret("Married Julie")));
	}
}

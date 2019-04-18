package com.sklink.learning.dp.dpInRunoob.$15interpreterPattern;

public class OrExpression implements Expression {
	private Expression expre1;
	private Expression expre2;
	
	public OrExpression(Expression expre1, Expression expre2) {
		this.expre1 = expre1;
		this.expre2 = expre2;
	}

	@Override
	public boolean interpret(String context) {
		return this.expre1.interpret(context) || this.expre2.interpret(context);
	}

}

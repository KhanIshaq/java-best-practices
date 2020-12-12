package chapter7;

import java.util.function.DoubleBinaryOperator;

// Enum with function object fields & constant-specific behavior
public enum Operation2 {
	
	PLUS("+", (x, y) -> x + y), 
	MINUS("-", (x, y) -> x - y), 
	TIMES("*", (x, y) -> x * y), 
	DIVIDE("/", (x, y) -> x / y);
	private final String symbol;
	private final DoubleBinaryOperator op;

	Operation2(String symbol, DoubleBinaryOperator op) {
		this.symbol = symbol;
		this.op = op;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public double apply(double x, double y) {
		return op.applyAsDouble(x, y);
	}
}

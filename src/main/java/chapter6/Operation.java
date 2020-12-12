package chapter6;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
//import static java.util.Map.toMap;

// Enum type that switches on its own value - questionable
public enum Operation {
	
	//Not recommended
//	PLUS, MINUS, TIMES, DIVIDE;

//	public double apply(double x, double y) {
//		switch (this) {
//		case PLUS:
//			return x + y;
//		case MINUS:
//			return x - y;
//		case TIMES:
//			return x * y;
//		case DIVIDE:
//			return x / y;
//		}
//		throw new AssertionError("Unknown Op : " + this);
//	}
	
	
	// Enum type with constant-specific method implementations
	
	//constant-specific method implementations:
//	PLUS  {public double apply(double x,double y){return x+y;}}, 
//	MINUS {public double apply(double x, double y){return x - y;}}, 
//	TIMES {public double apply(double x, double y){return x * y;}}, 
//	DIVIDE{public double apply(double x, double y){return x / y;}};
//    public abstract double apply(double x, double y);
	
	 // Enum type with constant-specific class bodies and data
	
	PLUS("+"){
		public double apply(double x, double y) { return x + y;}
	},
	MINUS("-"){
		public double apply(double x, double y) { return x - y;}
	},
	TIMES("*"){
		public double apply(double x, double y) { return x * y;}
	},
	DIVIDE("/"){
		public double apply(double x, double y) { return x / y;}
	};

	private final String symbol;
	Operation(String symbol){ this.symbol = symbol;}
	
	@Override public String toString() {return symbol;};
	public abstract double apply(double x, double y);
	
	
	public static void main(String[] args) {
	       double x = Double.parseDouble("50");
	       double y = Double.parseDouble("5");
	       for (Operation op : Operation.values())
	           System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	       
	       
	    // Implementing a fromString method on an enum type
//	       private static final Map<String, Operation> stringToEnum =
//	               Stream.of(values()).collect(toMap(Object::toString, e -> e));
	}
	
//	public static Optional<Operation> fromString(String symbol){
//		return Optional<Opertaion>.ofNullable(stringToEnum.get(symbol));
//	}
	
	// Switch on an enum to simulate a missing method
	public static Operation inverse(Operation op) {
		switch (op) {
		case PLUS:
			return Operation.MINUS;
		case MINUS:
			return Operation.PLUS;
		case TIMES:
			return Operation.DIVIDE;
		case DIVIDE:
			return Operation.TIMES;
		default:
			throw new AssertionError("Unknown op:" + op);
		}
	}
}

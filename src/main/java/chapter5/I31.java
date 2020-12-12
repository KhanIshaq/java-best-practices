package chapter5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class I31 {

	
	public static void main(String[] args) {
		//
		// Explicit type parameter - required prior to Java 8 
		Set<Integer> integers = new HashSet<>(Arrays.asList(new Integer[] {3,4,2}));
		Set<Double> doubles = new HashSet<>(Arrays.asList(new Double[] {33.0,44.0,22.0}));
		Set<Number> numbers = Union.<Number>union(integers, doubles);
		System.out.println(numbers.toString());
	}
	
}

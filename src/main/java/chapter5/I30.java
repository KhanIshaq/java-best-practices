package chapter5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.UnaryOperator;

public class I30 {

	// Generic method
	//type parameter list <E>
	// return type is Set<E>
	//The type parameter list, which declares the type parameters, goes between a method’s modifiers and its return type. 
	public static <E> Set<E> union(Set<E> s1, Set<E> s2){
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}
	
	//Simple exercise to practice Generic method
	public static void main(String[] args) {
		
		Set<String> guys = new HashSet<>(Arrays.asList(new String[] {"Tim", "Dane", "Trix"}));
		Set<String> stooges = new HashSet<>(Arrays.asList(new String[] {"Moe","Joe","Shaw"}));
		Set<String> aflcio = union(guys,stooges);
		System.out.println(aflcio);
		
		String[] strings = new String[] {"milk", "bread", "butter"};
		UnaryOperator<String> sameString = identityFunction();
		for(String s: strings) {
			System.out.println(sameString.apply(s));
		}
		
		 Number[] numbers = { 1, 2.0, 3L };
		 UnaryOperator<Number> sameNumber = identityFunction();
		 for(Number n: numbers) {
			 System.out.println(sameNumber.apply(n));
		 }
				
	}
	
	//You can make the method more flexible by using bounded wildcard types 
	
	//The generic singleton factory, is used for function objects 
	
	//Generic singleton factory
	private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;
	
	@SuppressWarnings("unchecked")
	public static <T> UnaryOperator<T> identityFunction(){
		return (UnaryOperator<T>) IDENTITY_FN;
	}
	
	//or a type parameter to be bounded by some expression involving that type parameter itself. 
	//This is what’s known as a recursive type bound.
	
	
	  public interface Comparable<T> {
	       int compareTo(T o);
	}
	  
	  
	  
//	  String implements Compa- rable<String>, Integer implements Comparable<Integer>
	  
	// Using a recursive type bound to express mutual comparability 
	 // public static <E extends Comparable<E>> E max(Collection<E> c);
	  
	 
}

/**
 * 
 */
package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nsa
 *
 */
public class I32 {

	// warning: [unchecked] Possible heap pollution from
	// parameterized vararg type List<String>

	// Heap pollution occurs when a variable of a parameterized type refers to an
	// object that is not of that type

	// Mixing generics and varargs can violate type safety!
	static void dangerous(List<String>... stringLists) {
		List<Integer> intList = Arrays.asList(42);
		Object[] objects = stringLists;
		objects[0] = intList; // Heap pollution
		String s = stringLists[0].get(0); // ClassCastException
		// it is unsafe to store a value in a generic varargs array parameter

//	Arrays.asList(T... a), 
//	Collections.addAll(Collection<? super T> c, T... elements), 
//	 EnumSet.of(E first, E... rest)
	}
	
	 // UNSAFE - Exposes a reference to its generic parameter array!
	   static <T> T[] toArray(T... args) {
	       return args;
	}
	
	//the SafeVarargs annotation constitutes a promise by the author of a method that it is typesafe.
	
	//a generic array is created when the method is invoked, to hold the varargs parameters.
	
	//this method returns its varargs parameter array, it can propagate heap pollution up the call stack.
	
//	  Approach 1
	 static <T> T[] pickTwo(T a, T b, T c) {
	       switch(ThreadLocalRandom.current().nextInt(3)) {
	         case 0: return toArray(a, b);
	         case 1: return toArray(a, c);
	         case 2: return toArray(b, c);
	       }
	       throw new AssertionError(); // Can't get here
	 }
	 
//		  Approach 2
//	 static <T> List<T> pickTwo(T a, T b, T c) 
//		 { switch(ThreadLocalRandom.current().nextInt(3)) {
//		 //Java 9 --> List.of
//		 	case 0: return List.of(a, b); 
//		 	case 1: return List.of(a, c); 
//		 	case 2: return List.of(b, c);
//		 }
//	        throw new AssertionError();
//	 }
	 
	 public static void main(String[] args) {
	       String[] attributes = pickTwo("Good", "Fast", "Cheap");
	       	//List<String> attributes = pickTwo("Good", "Fast", "Cheap");
	       Arrays.stream(attributes).forEach(System.out::println);
	}
	 //The cast fails, because Object[] is not a subtype of String[].
	 
	 //t is unsafe to give another method access to a generic varargs parameter array, with two excep- tions: 
	 //it is safe to pass the array to another varargs method that is correctly anno- tated with @SafeVarargs, and it is safe to pass the array to a non-varargs method that merely computes some function of the contents of the array.
	 
	 
	// Safe method with a generic varargs parameter
	   @SafeVarargs
	   static <T> List<T> flatten(List<? extends T>... lists) {
	       List<T> result = new ArrayList<>();
	       for (List<? extends T> list : lists)
	           result.addAll(list);
	       return result;
	}
	   // a generic varargs methods is safe if:
	   //1. it doesn’t store anything in the varargs parameter array, and
	   //2. it doesn’t make the array (or a clone) visible to untrusted code.
	   
	   //In Java 8, the annotation was legal only on static methods and final instance methods; 
	   //in Java 9, it became legal on private instance methods as well.
	   
	   // List as a typesafe alternative to a generic varargs parameter 
	   static <T> List<T> flatten(List<List<? extends T>> lists) {
       List<T> result = new ArrayList<>();	
       for (List<? extends T> list : lists)
           result.addAll(list);
       return result;
	}
	   
	   //List.of declaration is annotated with @SafeVarargs:
//	   audience = flatten(List.of(friends, romans, countrymen));
	   
	   //varargs and generics do not interact well because the varargs facility is a leaky abstraction built atop arrays, and arrays have different type rules from generics
	   //If you choose to write a method with a generic (or parameterized) varargs parame- ter, first ensure that the method is typesafe, and then annotate it with @Safe-
	   //Varargs so it is not unpleasant to use.
}

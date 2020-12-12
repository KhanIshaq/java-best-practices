package chapter5;

import java.util.*;

// Private helper method for wildcard capture (Page 145)
public class Swap {
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}

	// Private helper method for wildcard capture
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}

	public static void main(String[] args) {
		// Swap the first and last argument and print the resulting list
		List<String> argList = Arrays.asList(args);
		swap(argList, 0, argList.size() - 1);
		System.out.println(argList);
	}
	
	
	// Two possible declarations for the swap method
	//Unbound type parameters
//	public static <E> void swap1(List<E> list, int i, int j);
	//Unbounded wildcard
//	public static void swap2(List<?> list, int i, int j);
	
	//As a rule, if a type parameter appears only once in a method declaration, replace it with a wildcard
	//If it’s an unbounded type parameter, replace it with an unbounded wildcard; 
	//if it’s a bounded type parameter, replace it with a bounded wildcard.
	
	//WOnt compile
	//and you can’t put any value except null into a List<?>. Fortunately, there is a way to implement this method without resorting to an unsafe cast or a raw type. 
//	public static void swap3(List<?> list, int i, int j) {
//    list.set(i, list.set(j, list.get(i)));
//	}
	
	//This slightly convoluted implementation of swap compiles cleanly. It allows us to export the nice wildcard-based declaration, while taking advantage of the more complex generic method internally. Clients of the swap method don’t have to confront the more complex swapHelper declaration, but they do benefit from it. 
	//It is worth noting that the helper method has precisely the signature that we dismissed as too complex for the public method
	//Remember the basic rule: producer-extends, consumer-super (PECS). Also remember that all comparables and comparators are consumers.

}
package chapter5;

import java.util.Set;

/**
 * 
 * @author nsa
 *
 *A class or interface that has one or more type parameters is called as Generic class or Interface.
 *
 *Generic classes and interfaces are collectively known as generic types.
 *
 *List<E>  -> list of E
 *List<String>  -> List of String
 *
 *String is the actual type parameter corresponding to the formal type parameter E.
 *
 * the raw type corresponding to List<E> is List. Raw types behave as if all of the generic type information were erased from the type declaration. 
 * They exist primarily for compatibility with pregenerics code.
 *
 */

public class I26 {

	// Raw collection type - don't do this!
	// My stamp collection. Contains only Stamp instances.
//	private final Collection stamps = ... 
	
	// Erroneous insertion of coin into stamp collection
//	   stamps.add(new Coin( ... )); // Emits "unchecked call" warning
	
//	You don’t get an error until you try to retrieve the coin from the stamp collection:
//		// Raw iterator type - don't do this!
//		for (Iterator i = stamps.iterator(); i.hasNext(); )
//		Stamp stamp = (Stamp) i.next(); // Throws ClassCastException stamp.cancel();
//	With generics, the type declaration contains the information, not the comment:
		// Parameterized collection type - typesafe private final Collection<Stamp> stamps = ... ;
	
//	Test.java:9: error: incompatible types: Coin cannot be converted to Stamp
//    c.add(new Coin());
	
//	 If you use raw types, you lose all the safety and expressiveness benefits of generics. 
	
	//This requirement, known as migration compatibility, drove the deci- sions to support raw types and to implement generics using erasure (Item 28).
	
//	raw type List and the parameterized type List<Object>
	
//	You can pass List<String> parameter to List because --> List<String>is a subtype of List
//	Parameterised type List<Object>
	//you lose type safety if you use a raw type such as List, but not if you use a param- eterized type such as List<Object>.
	
	
	// Use of raw type for unknown element type - don't do this! 
	static int numElementsInCommon(Set s1, Set s2) {
	
	
    int result = 0;
    
    for (Object o1 : s1)
        if (s2.contains(o1))
            result++;
    return result;
	}
    //The safe alternative is to use unbounded wildcard types.
	
//	the unbounded wildcard type for the generic type Set<E> is Set<?> (read “set of some type”)
	
	// Uses unbounded wildcard type - typesafe and flexible 
//	static int numElementsInCommon(Set<?> s1, Set<?> s2) { ... }
	
	/**
	 * wildcard type Set<?> is typesafe
	 * the raw type Set is not safe
	 */
	
//	WildCard.java:13: error: incompatible types: String cannot be
//	   converted to CAP#1
//	       c.add("verboten");
//	             ^
//	     where CAP#1 is a fresh type-variable:
//	       CAP#1 extends Object from capture of ?
	
	
	
	//You can put any element into a collection with a raw type, easily corrupting the collection’s type invariant (as demonstrated by the unsafeAdd method on page 119); you can’t put any ele- ment (other than null) into a Collection<?>.
	
//	Not only can’t you put any element (other than null) into a Collection<?>, but you can’t assume anything about the type of the objects that you get out.
	
	//You must use raw types in class literals.
	//List.class, String[].class, and int.class are all legal since they are primitive 
	//but List<String>.class and List<?>.class are not permitted.
	
	//it is illegal to use the instanceof operator on parameterized types other than unbounded wildcard types.
	// Legitimate use of raw type - instanceof operator if (o instanceof Set) { // Raw type
//	Set<?> s = (Set<?>) o; // Wildcard type
//	... }
	
	// Set<Object>  object of anytype
	//Set<?> Object of some unknown type
	//Set is a raw type
	//The first two are safe, and the last is not.
	
//	Parameterized type 			List<String>
//	Actual Type Parameter		String
//	Formal Type Parameter		E
//	Generic Type				List<E>
//	Unbounded wildcard type		List<?>
//	Raw Type					List
//	Bounded type parameter		<E extends Number>
//	Bounded wildcard type		List<? extends Number>
//	Bounded type parameter		<E extends Number>
//	Recursive Type Bound		<T extends Comparable<T>>
//	Generic method				static <E> List<E> asList(E[] a)
//	Type Token					String.class
	
}

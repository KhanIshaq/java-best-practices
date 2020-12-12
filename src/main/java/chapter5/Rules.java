/**
 * 
 */
package chapter5;

/**
 * @author nsa
 *
 */
public class Rules {
	//26
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

	//28.
	// Arrays are reified/concrete
	//Arrays know & enforce their element type during runtime	
	//Generics are implemented by erasure
	//enforce constraints at compile time
	//Because of erasure, the only parameterized types that are reifiable are unbounded wildcard types such as List<?> and Map<?,?>
	//the best solution is often to use the collection type List<E> in preference to the array type E[]
	
	//PECS stands for producer-extends, consumer-super.
	
	
	// As a rule, if a type parameter appears only once in a method declaration, replace it with a wildcard
	// If it’s an unbounded type parameter, replace it with an unbounded wildcard;
	// if it’s a bounded type parameter, replace it with a bounded wildcard.
}

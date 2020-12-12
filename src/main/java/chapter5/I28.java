/**
 * 
 */
package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nsa
 *
 *Item28: Prefer  lists to arrays
 *
 */
public class I28 {

	// Arrays are covariant
	// That means Sub is a subtype of super
	// Sub[] is a subtype of Super[]
	//Generics are invariant for two distinct types
	//Type1 & Type2
	//List<Type1> is neither a subtype nor supertype of List<Type2>
	
	//Fails at runtime
//	Object[] objectArray = new Long[1];
//	objectArray[0] = "Idont fit in";// ArrayStoreException
//	
//	List<Object> ol = new ArrayList<Long>(); // Type mismatch
//	ol.add("I dont fit int");

	
	// Arrays are reified/concrete
	//Arrays know & enforce their element type during runtime
	
//	Generics are implemented by erasure
//	enforce constraints at compile time
	// Why generic array creation is illegal - won't compile! 
//	List<String>[] stringLists = new List<String>[1]; // (1)
//	List<Integer> intList = Arrays.asList(42);
//	Object[] objects = stringLists;
//	objects[0] = intList;
//	String s = stringLists[0].get(0);
	
	//Because of erasure, the only parameterized types that are reifiable are unbounded wildcard types such as List<?> and Map<?,?>
	
	//the best solution is often to use the collection type List<E> in preference to the array type E[]
	
}

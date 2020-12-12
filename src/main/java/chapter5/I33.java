/**
 * 
 */
package chapter5;

/**
 * @author nsa
 *
 */
public class I33 {

	//Item33: Consider type safe heterogeneous containers
	
	//Common uses of generics include collections, such as Set<E> and Map<K,V>, 
	//and single-element containers, such as ThreadLocal<T> and AtomicReference<T>.
	
	//The idea is to parameterize the key instead of the container.
	//Then present the parame- terized key to the container to insert or retrieve a value.
	
	//The type of a class literal is not simply Class, but Class<T>.
	//For example, String.class is of type Class<String>, and Integer.class is of type Class<Integer>.
	
//	When a class literal is passed among methods to communicate both compile-time and runtime type information, it is called a type token
	
	//It looks just like a simple map, except that the key is parameterized instead of the map
	
}

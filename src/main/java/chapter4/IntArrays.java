/**
 * 
 */
package chapter4;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author nsa
 *
 *Incidentally, this example is an Adapter that allows an int array to be viewed as a list of Integer instances.
 *the skeletal implementation can still aid the implementor’s task. 
 *The class implementing the interface can forward invocations of interface methods to a contained instance of a private inner class that extends the skeletal implementation. 
 *This technique, known as simulated multiple inheritance, is closely related to the wrapper class idiom discussed in Item 18. 
 *It provides many of the benefits of multiple inheritance, while avoiding the pitfalls.
 */


//Concrete implementation built atop skeletal implementation (Page 101)
public class IntArrays {

	static List<Integer> intArrayAsList(int[] a){
		Objects.requireNonNull(a);
		
		// The diamond operator is only legal here in Java 9 and later
        // If you're using an earlier release, specify <Integer>
		return new AbstractList<Integer>() {
			
			@Override public Integer get(int i) {
				return a[i];// Autoboxing (Item 6)
			}
			
			@Override public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val; // Auto-unboxing
				return oldVal; // Autoboxing
			}
			
			@Override public int size() {
				return a.length;
			}
		};
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i = 0; i<a.length;i++)
			a[i] = i;

		List<Integer> list = intArrayAsList(a);
		Collections.shuffle(list);
		System.out.println(list);
	}
	
	

}

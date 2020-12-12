/**
 * 
 */
package chapter5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nsa
 *
 *Eliminate every unchecked warning that you can.
 *
 *If you can’t eliminate a warning, but you can prove that the code that provoked the warning is typesafe, then (and only then) suppress the warning with an @SuppressWarnings("unchecked") annotation.
 *
 *Always use the SuppressWarnings annotation on the smallest scope possible. 
 *
 *If you find yourself using the SuppressWarnings annotation on a method or constructor that’s more than one line long, you may be able to move it onto a local variable declaration
 *
 */
public class I27 {

	//unchecked conversion
	Set<Lark> exaltation = new HashSet();
	
	int size = 10;
	Integer[] elements = new Integer[] {1,2};
//	public <T> T[] toArray(T[] a) {
//		if(a.length < size) {
//			//illegal to put suppress 
//			return (T[]) Arrays.copyOf(elements, size, a.getClass());
//		}
//		System.arraycopy(elements, 0, a, 0, size);
//		if(a.length > size) {
//			a[size] = null;
//		}
//		return a;
//	}
	
	
	public <T> T[] toArray(T[] a) {
		if(a.length < size) {
			// The cast is correct because the array that we are creating is the same type as the one that is passed.
			@SuppressWarnings("unchecked") T[] result =  (T[]) Arrays.copyOf(a, size, a.getClass());
			return result;
		}
		System.arraycopy(elements, 0, a, 0, size);
		if(a.length > size) {
			a[size] = null;
		}
		return a;
	}
	
}

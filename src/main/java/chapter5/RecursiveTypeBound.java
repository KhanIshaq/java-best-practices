/**
 * 
 */
package chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * @author nsa
 *
 */
public class RecursiveTypeBound {
	
	//public static <E extends Comparable<E>> E max(Collection<E> c) {
	//public static <T extends Comparable<T>> T max(List<T> list) {

	// Using a recursive type bound with wildcards (Page 143)
	public static <E extends Comparable<E>> E max(List<? extends E> list) {
	  if(list.isEmpty())
		  throw new IllegalArgumentException("Empty Collection");
	  
	  E result = null;
	  for(E e : list) {
		  if(result == null || e.compareTo(result) > 0) {
			  result = e;
		  }
	  }  
	return result;
}
	
	public static void main(String[] args) {
		args = new String[] {"Hana", "Baga", "Cana", "Wana"};
        List<String> argList = Arrays.asList(args);
        System.out.println(max(argList));
    }

	//Comparables are always consumers, so you should generally use Comparable<? super T> in preference to Comparable<T>. 
	//The same is true of comparators; 
	//therefore, you should generally use Comparator<? super T> in preference to Comparator<T>.
	
//	 List<ScheduledFuture<?>> scheduledFutures = ... ;
	
	
}

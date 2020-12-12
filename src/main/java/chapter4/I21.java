/**
 * 
 */
package chapter4;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author nsa
 *
 *Many new default methods were added to the core collection interfaces in Java 8, primarily to facilitate the use of lambdas
 *
 *The Java libraries’ default methods are high-quality general-purpose implementations, and in most cases, they work fine
 *
 *But it is not always possible to write a default method that maintains all invariants of every conceivable implementation.
 *
 *Even though default methods are now a part of the Java platform, it is still of the utmost importance to design interfaces with great care.
 *
 * If an interface contains a minor flaw, it may irritate its users forever; if an interface is severely deficient, it may doom the API that contains it.
 * 
 * While it may be possible to correct some interface flaws after an interface is released, you cannot count on it.
 * 
 * At a minimum, you should aim for three diverse implementations.
 * 
 * 
 * 
 */
public class I21 {

//	default <E> boolean removeIf(Predicate<? super E> filter) {
//		Objects.requireNonNull(filter);
//		boolean result = false;
//		for(Iterator<E> it = iterator(); it.hasNext()) {
//			if(filter.test(it.next())) {
//				it.remove();
//				result = true;
//			}
//		}
//		return result;
//	}
	
	
}

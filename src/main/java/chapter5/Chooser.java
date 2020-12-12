/**
 * 
 */
package chapter5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nsa
 *
 */
public class Chooser<T> {

	private final List<T> choiceList;
	
	public Chooser(Collection<T> choice) {
		choiceList = new ArrayList<>();
	}
	
	public T choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}
	
	//Arrays are covariant and reified; 
	//generics are invariant and erased.
	
	//arrays provide runtime safety & not compile time
	//generic provide compile time safely
	
	//your first impulse should be to replace the arrays with lists.
	
	
}

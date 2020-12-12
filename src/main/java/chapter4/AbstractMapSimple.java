/**
 * 
 */
package chapter4;

import java.util.AbstractMap;
import java.util.Map.Entry;

/**
 * @author nsa
 *
 */
public class AbstractMapSimple<K,V>  extends AbstractMap.SimpleEntry<K,V> {

	public AbstractMapSimple(Entry<? extends K, ? extends V> entry) {
		super(entry);
		// TODO Auto-generated constructor stub
	}

}

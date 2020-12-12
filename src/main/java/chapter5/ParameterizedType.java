/**
 * 
 */
package chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nsa
 *
 */
public class ParameterizedType {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
//        unsafeAdd(strings, Integer.valueOf(42)); // Error Message appears during compile time
        String s = (String) strings.get(0); // Has compiler-generated cast
	}
	
	private static void unsafeAdd(List<Object> list, Object o) {
		list.add(o);
	}
}

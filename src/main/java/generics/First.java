package generics;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author ishaqkhan
 *
 */
public class First {
	
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		list.add("test");
		String s = (String) list.get(0);
		
		System.out.println(s);
		
		System.out.println(First.class.getCanonicalName());
	}
}

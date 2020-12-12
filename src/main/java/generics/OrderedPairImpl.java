/**
 * 
 */
package generics;

/**
 * @author ishaqkhan
 * 
 * 
 */
public class OrderedPairImpl {

	Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
	Pair<String, String> p2 = new OrderedPair<>("hello", "world");
	
	//Parameterized Types
	OrderedPair<String, Box<Integer>> p = new OrderedPair<>("prime", new Box<>());
	
	//Raw Types
	Box raw = new Box<>();
	//However non-generic class or interface is not of raw type
	
	Box<String> stringbox = new Box<>();
	Box rawbox = stringbox;  //OK
	
	Box rawBox1 = new Box();           // rawBox is a raw type of Box<T>
	Box<Integer> intBox = rawBox1;     // warning: unchecked conversion
	
	
//	Box<String> stringBox1 = new Box<>();
//	Box rawBox2 = stringBox1;
//	rawBox2.set(8);  // warning: unchecked invocation to set(T)
	
	
	//The complete syntax for invoking this method would be:

		Pair2<Integer, String> p3 = new Pair2<>(1, "apple");
		Pair2<Integer, String> p4 = new Pair2<>(2, "pear");
		boolean same = Util.<Integer, String>compare(p3, p4);
		
		
		//Type inference
		Pair2<Integer, String> p5 = new Pair2<>(1, "apple");
		Pair2<Integer, String> p6 = new Pair2<>(2, "pear");
		// allows you to invoke a generic method as an ordinary method,
		boolean same2 = Util.compare(p5, p6);
		
}

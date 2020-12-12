/**
 * 
 */
package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author ishaqkhan
 * 
 * You are free to pass in whatever you want, provided that it is not one of the primitive types
 * 
 * Generic class is defined with the following format
 * class name<T1, T2, ..., Tn> { ... }
 */
//public class Box {
//
//	private Object object;
//	
//	public void setObject(Object object) { this.object  = object;}
//	public Object getObject() {return object;}
//}

/**
 * 
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 *
 */
public class Box<T>{
	//T stands for type
	private T t;
	
	public void set(T t) { this.t = t;}
	public T get() {return t;}
	
	public static void main(String[] args) {
		
		//An invocation of a generic type is generally known as a parameterized type.
		Box<Integer> integerBox = new Box<Integer>();
		Box<Integer> integerBox2 = new Box<>();
		
		Box<String> stringBox1 = new Box<>();
		stringBox1.set("--");
		
		System.out.println(stringBox1.get());
		Box<Double> doubleBox = new Box<>();
		doubleBox.set(100.00);
		
		//We can call the collection with a element type which is super type of element of Array
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>();
		
		// T inferred to be Object
		fromArrayToCollection(oa, co); 
		
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		
		// T inferred to be String
		fromArrayToCollection(sa, cs);
		
		// T inferred to be Object
		fromArrayToCollection(sa, co);
		
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Double[] da = new Double[100];
		
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<Number>();
		
		// T inferred to be Number
		fromArrayToCollection(ia, cn);

		// T inferred to be Number
		fromArrayToCollection(fa, cn);

		// T inferred to be Number
		fromArrayToCollection(da, cn);
				
		// T inferred to be Number
		fromArrayToCollection(na, cn);

		// T inferred to be Object
		fromArrayToCollection(na, co);

		// compile-time error
		//fromArrayToCollection(na, cs);
		
		List<String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass().getName());
		System.out.println(l2.getClass().getName());
		System.out.println(l1.getClass().getSimpleName());
		
		System.out.println(l1.getClass() == l2.getClass());
		
//		Collection cs = new ArrayList<String>();
//		// Illegal.
//		if (cs instanceof Collection<String>) {
//			
//		}
		
		// Not really allowed.
//		List<String>[] lsa = new List[10];
//		Object o = lsa;
//		Object[] oa = (Object[]) o;
//		List<Integer> li = new ArrayList<Integer>();
//		li.add(new Integer(3));
//		// Unsound, but passes run time store check
//		oa[1] = li;
//
//		// Run-time error: ClassCastException.
//		String s = lsa[1].get(0);
		
		
		List<?>[]  lsa1 = new List<?>[10];
		Object o1 = lsa1;
		Object[] oa1 = (Object[]) o1;
		List<Integer> li1 = new ArrayList<Integer>();
		li1.add(new Integer(3));
		oa1[1] = li1;
		String s1 = (String) lsa1[1].get(0);
	}
	
	//collection of unknown
	//wildcard type
	void printCollection(Collection<?> c) {
		
		for(Object o : c) {
			System.out.println(o.getClass());
		}
	}
	
	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for(T e : a) {
			c.add(e);
		}
	}
}
//all occurrences of Object are replaced by T. A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.

//This same technique can be applied to create generic interfaces.


//E = Element
//K = Key
//N = Number
//T = type
//V = Value
// S,U,V, etc = 2nd 3rd 4th types

//Generic Type invocation 
//which replaces T with some concrete value, such as Integer:

//Box<Integer> integerBox;


//public interface List<E>{
//	void add(Integer e);
//	Iterator<E> iterator;
//}
//
//public interface Interator<E>{
//	E next;
//	boolean hasNext();
//}

//Wildcards are designed to support flexible subtyping
//interface Collection<E> {
//    public boolean containsAll(Collection<?> c);
//    public boolean addAll(Collection<? extends E> c);
//}
//We could have used generic methods here instead:

//interface Collection1<E> {
//    public <T> boolean containsAll(Collection<T> c);
//    public <T extends E> boolean addAll(Collection<T> c);
//    // Hey, type variables can have bounds too!
//}

//class Collections {
//    public static <T> void copy(List<T> dest, List<? extends T> src) {
//    }
//}
//Both perform the same

//class Collections {
//    public static <T, S extends T> void copy(List<T> dest, List<S> src) {
//    }
//}

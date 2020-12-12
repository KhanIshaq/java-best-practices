package chapter5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack1<E> {
	// Initial attempt to generify Stack - won't compile!
	
	//non-reifiable type, there’s no way the compiler can check the cast at runtime.
	//private E[] elements;
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	//Thus, the first technique is preferable and more commonly used in practice. It does, however, cause heap pollution (
	//This element will contain only E instances from push(E)
	//This is sufficient to ensure the safety but runtime type of array wont be E[]; it will always be Object[] 
	@SuppressWarnings("unchecked")
	public Stack1() {
		//elements = new E[DEFAULT_INITIAL_CAPACITY];
		elements =  (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	//appropriate suppression of unchecked warning
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		
		// push requiers elements of type E so cast is correct
		@SuppressWarnings("unchecked") E result = (E) elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	// no changes in isEmpty or ensureCapacity
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	 // Little program to exercise our generic Stack
	   public static void main(String[] args) {
	       Stack1<String> stack = new Stack1<>();
	       for (String arg : args)
	           stack.push(arg);
//	       while (!stack.isEmpty()) {
//	    	   System.out.println(stack.pop().toUpperCase());
//	       }
	}
	   
//	   so some generic types, such as ArrayList, must be implemented atop arrays. Other generic types, such as HashMap, are implemented atop arrays for performance.
	   
	   //you can create a Stack<Object>, Stack<int[]>, Stack<List<String>>, or Stack of any other object reference type.
	   //you can’t create a Stack of a primitive type: trying to create a Stack<int> or Stack<double> will result in a compile-time error. This is a fun- damental limitation of Java’s generic type system. You can work around this restriction by using boxed primitive types (Item 61).
	   
	   //The type parameter E is known as a bounded type parameter. 
	   //Note that the subtype relation is defined so that every type is a subtype of itself
	   //so it is legal to create a DelayQueue<Delayed>.
	   //Item30: Favorgenericmethods
}

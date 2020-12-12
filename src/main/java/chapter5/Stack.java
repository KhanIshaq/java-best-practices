package chapter5;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * @author nsa
 *Item29: Favor generic types
 *
 * // Object-based collection - a prime candidate for generics
 */
public class Stack {
	
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack(){
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop() {
		if(size == 0)
			throw new EmptyStackException();
		
		Object result = elements[--size];
		elements[size] = null; //eliminate obselete reference
		return result;
	}
	
	private void ensureCapacity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size +1);
		}
	}
	
	//This class should have been parameterized to begin with, but since it wasn’t, we can generify it after the fact.
	
	
}

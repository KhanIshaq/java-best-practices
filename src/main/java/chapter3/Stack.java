package chapter3;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Hashtable;

public class Stack {

	private Object[] elements;
	private int size;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			return new EmptyStackException();
		Object e = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return e;

	}

	private void ensureCapacity() {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	// Clone method for class with references to mutable state
	@Override public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}

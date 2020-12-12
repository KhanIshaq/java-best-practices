package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class Stack31<E> {
	private E[] elements;
	int size = 0;
	private static final int DEFAULT_CAPACITY = 16;
	
	
	@SuppressWarnings("unchecked") public Stack31() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {

		return null;
	}

	public boolean isEmpty() {

		return false;
	}

	private void ensureCapacity() {
		if(size == elements.length) {
			elements = Arrays.copyOf(elements, size*2 + 1);	
		}
	}
	
	public int size() {
		return elements.length;
	}
	
	//pushAll static factory without of wildcard Type - deficient
//	public void pushAll(Iterable<E> src) {
//		for (E e : src) {
//			push(e);
//		}
//	}
	
//  Wildcard type for a parameter that serves as an E producer 
    public void pushAll(Iterable<? extends E> src) {
     for (E e : src)
         push(e);
    }
    
    
 // popAll method without wildcard type - deficient!
//	public void popAll(Collection<E> dst) {
//		while (!isEmpty())
//			dst.add(pop());
//	}
    
    //Wildcard type for a parameter that servers as an E Consumer
    public void popAll(Collection<? super E> dst) {
 	   while(!isEmpty()) {
 		   dst.add(pop());
 	   }
    }
    
    //a little progream to exercise our generic stack
    public static void main(String[] args) {
		Stack31<Number> numberStack = new Stack31<>();
		Iterable<Integer> integers = Arrays.asList(3,1,4,5,9,8);
		numberStack.pushAll(integers);
		System.out.println(numberStack.size());
		
		Collection<Object> objects = new ArrayList<>();
		numberStack.popAll(objects);
		
		System.out.println(numberStack.isEmpty());
		System.out.println(objects);
	}
    
	       //PECS stands for producer-extends, consumer-super.
	       
	       // Integer is a subtype of Number, so it will work
	       
//	       Stack<Number> numbers = new Stack<>();
//	       Iterable<Integer> itr = new ;
//	       numbers.pushAll(ltr);
	       
//	       Iterable<Integer > cannot be converted to Iterable<Number>
//	        numbers.pushAll(ltr);
	      
	       


//	       Stack<Number> numberStack = new Stack<Number>();
//	       Collection<Object> objects = ... ;
//	       numberStack.popAll(objects);
	       
//	       COllection<Object> is not a subtype of Collection<Number>
	       
	       
//	       PECS stands for producer-extends, consumer-super.
	       
//	       public Chooser(Collection<T> choices)
//	       This constructor uses the collection choices only to produce values of type T (and stores them for later use), so its declaration should use a wildcard type that extends T. Here’s the resulting constructor declaration:
	       // Wildcard type for parameter that serves as an T producer 
//	       public Chooser(Collection<? extends T> choices)
	       
//	       public static <E> Set<E> union(Set<? extends E> s1,
//                   Set<? extends E> s2)
	       
//	       Note that the return type is still Set<E>. 
//	       Do not use bounded wildcard types as return types.
	       
//	       Set<Integer> integers = Set.of(1, 3, 5);
//	       Set<Double>  doubles  = Set.of(2.0, 4.0, 6.0);
//	       Set<Number>  numbers  = union(integers, doubles);
	       
	       //Properly used, wildcard types are nearly invisible to the users of a class. 
//	       They cause methods to accept the parameters they should accept and reject those they should reject. 
	       
	}
/**
 * 
 */
package chapter4;

import java.util.Collection;
import java.util.Set;

/**
 * @author nsa
 * Wrapper class - uses composition in place of inheritance
 *  This is also known as the Decorator pattern because the InstrumentedSet class “decorates” a set by adding instrumentation. 
 *  Sometimes the combination of composition and forwarding is loosely referred to as delegation. 
 *  Technically it’s not delegation unless the wrapper object passes itself to the wrapped object
 *  
 *  wrapper classes are not suited for use in callback frameworks, wherein objects pass self- references to other objects for subsequent invocations (“callbacks”). 
 *  Because a wrapped object doesn’t know of its wrapper, it passes a reference to itself (this) and callbacks elude the wrapper. This is known as the SELF problem
 *  you have to write the reusable forwarding class for each interface only once, and forwarding classes may be provided for you.
 *   Guava provides forwarding classes for all of the collection interfaces
 *   
 *   
 *    For example, a stack is not a vector, so Stack should not extend Vector. 
 *    Similarly, a property list is not a hash table, so Properties should not extend Hashtable. 
 *    In both cases, composition would have been preferable.
 *    
 *    Inheritance propagates any flaws in the superclass’s API, while composition lets you design a new API that hides these flaws.
 *    
 *    use composition and forwarding instead of inheritance, especially if an appropriate interface to implement a wrapper class exists. 
 *    Not only are wrapper classes more robust than subclasses, they are also more powerful.
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
	private int addCount = 0;
	public InstrumentedSet(Set<E> s) {
		super(s);
	}
	
	@Override public boolean add(E e) {
		addCount++;
		return super.add(e);
	}
	
	@Override public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
	
	public int getAddCount() {
		return addCount;
	}

}

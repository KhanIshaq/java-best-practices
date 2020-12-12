/**
 * 
 */
package chapter4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @author nsa
 *
 * Reusable forwarding class
 */
public class ForwardingSet<E> implements Set<E> {

	private final Set<E> s;

	public ForwardingSet(Set<E> s)		{this.s = s;}
	
	public void clear()              	{ s.clear();}
	
	public boolean contains(Object o) 	{return s.contains(o);}
	
	public boolean isEmpty() 			{return s.isEmpty();}

	public int size() {return s.size();}

	public Iterator<E> iterator() {
		return s.iterator();
	}

	public Object[] toArray() {
		return s.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return s.toArray(a);
	}

	public boolean add(E e) {
		return s.add(e);
	}

	public boolean remove(Object o) {
		return s.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return s.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}

	
	@Override
	public String toString() {
		return "ForwardingSet [s=" + s + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ForwardingSet other = (ForwardingSet) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}
}
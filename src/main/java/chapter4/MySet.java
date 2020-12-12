package chapter4;

import java.util.AbstractSet;
import java.util.Iterator;

// Typical use of a nonstatic member class
public class MySet<E> extends AbstractSet<E> {

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
//	... // Bulk of the class omitted
//	@Override
//	public Iterator<E> iterator() {
//		return new MyIterator();
//	}
//
//private class MyIterator implements Iterator<E> { ...
//}
}
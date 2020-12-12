package chapter4;

import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * @author nsa
 *	
 * @param <E>
 * 
 * It is safe to use inheritance within a package, where the subclass and the superclass implementa- tions are under the control of the same programmers. 
 * It is also safe to use inheritance when extending classes specifically designed and documented for extension
 * Unlike method invocation, inheritance violates encapsulation
 * static factory method List.of, which was added in Java 9
 * earlier release, use Arrays.asList instead
 * InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
 * s.addAll(List.of("Snap", "Crackle", "Pop"));
 */
// Broken - Inappropriate use of inheritance!
public class InstrumentedHashSet<E> extends HashSet<E> {
	
	// The number of attempted element insertions
	private int addCount = 0;

	public InstrumentedHashSet() {
	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}
}

package chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chapter4.ForwardingSet;

// Broken - invokes alien method from synchronized block!
//locks in the Java programming language are reentrant, such calls won’t deadlock. 

//Reentrant locks simplify the construction of multithreaded object-oriented programs, but they can turn liveness failures into safety failures.
public class ObservableSet<E> extends ForwardingSet<E> {
	public ObservableSet(Set<E> set) {
		super(set);
	}

	private final List<SetObserver<E>> observers = new ArrayList<>();

	public void addObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public boolean removeObserver(SetObserver<E> observer) {
		synchronized (observers) {
			return observers.remove(observer);
		}
	}

//	private void notifyElementAdded(E element) {
//		synchronized (observers) {
//			for (SetObserver<E> observer : observers)
//				observer.added(this, element);
//		}
//	}
	
	// Alien method moved outside of synchronized block - open calls
	//“snapshot” of the observers list that can then be safely traversed without a lock.
	   private void notifyElementAdded(E element) {
	       List<SetObserver<E>> snapshot = null;
	       synchronized(observers) {
	           snapshot = new ArrayList<>(observers);
	       }
	       for (SetObserver<E> observer : snapshot)
	           observer.added(this, element);
	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added)
			notifyElementAdded(element);
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c)
			result |= add(element); // CallsnotifyElementAdded
		return result;
	}

	public static void main(String[] args) {
		ObservableSet<Integer> intSet = new ObservableSet<>(new HashSet<>());
		intSet.addObserver((s,e) -> System.out.println("<-"+e));
		
//		First Approach
//		for(int i = 0;i<100; i++) {
//			intSet.add(i);
//			intSet.addObserver(new SetObserver<Integer>() {
//				
//				@Override
//				public void added(ObservableSet<Integer> set, Integer element) {
//					System.out.println(element);
//					if(element == 23) {
//						set.removeObserver(this);
//					}
//				}
//			});
//		}
		
		// Second Approach
		// Observer that uses a background thread needlessly
		for(int i = 0;i<100; i++) {
			intSet.add(i);
			intSet.addObserver(new SetObserver<Integer>() {
				
				public void added(ObservableSet<Integer> s, Integer e) {
					System.out.println(e);
					if (e == 23) {
		            ExecutorService exec = Executors.newSingleThreadExecutor();
		            	try {
		            			exec.submit(() -> s.removeObserver(this)).get();
		            		} catch (ExecutionException | InterruptedException ex) { 
		            			throw new AssertionError(ex);
			            } finally {
			               exec.shutdown();
			            } 
					}
				} 
			});
		}
		System.out.println("->>"+intSet);
	}
}
package practice;

/**
 * 
 * @author ishaqkhan
 * Routes
 * Bracket Balancing
 *
 */
public class MyStack<E> {
	private MyLinkedList<E> mll = new MyLinkedList<>();
	
	void push(E e) {
		mll.add(e);
	}
	
	E pop() throws Exception {
		if(mll.isEmpty()) {
			throw new Exception("Popping from empty Stack");
		}
		return mll.remove();
	}
	
	E peek() throws Exception {
		if(mll.isEmpty()) {
			throw new Exception("Peeking from empty Stack");
		}
		
		
		return mll.getLast();
	}
}
 
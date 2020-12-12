package practice;

/**
 * 
 * @author ishaqkhan
 *	Undo and Redo Operations
 *	Sliding Window Problem
 *	ArrayDeque is faster than Stack because it is not Thread safe
 *	Stack is thread safe because it implements Vector
 */
public class MyDeque<E> {

	Node<E> head, tail;
	
	public void addToHead(E data) {
		
		Node<E> toAddNode = new Node<>(data);
		
		if(head == null) {
			head = toAddNode;
			return;
		}
		
		head.next = toAddNode;
		toAddNode.prev = head;
		head = toAddNode;
	}
	
	public E removeLast() {
		if(tail == null)
			return null;
		
		Node<E> toRemoveNode = tail;
		tail = tail.next;
		tail.prev = null;
		
		if(tail == null) {
			head = null;
		}
		
		return toRemoveNode.data;
		
	}
	
	public static class Node<E>{
		E data;
		Node<E> next, prev;
		
		public Node(E data){
			this.data = data;
			this.next = this.prev = null;
		}
	}

}

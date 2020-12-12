package practice;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author ishaqkhan
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		
//		Vector is thread safe and its operations apply a lock which adds an overhead therefore it is slow
//		ArrayList is not thread and it is much faster than Vectors
//		ArrayList is memory efficient because the size is increased 1.5 times compared to 2 times in the case of Vectors
		
//		Stack
		
//		push()
//		pop()
//		peek()
//		empty()
//		search()
		
		MyStack<Integer> stack = new MyStack<>();
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		stack.push(40);
//		int popped = stack.pop();
//		System.out.println(popped);
//		int peeked = stack.peek();
//		System.out.println(peeked);
//		stack.pop();
//		stack.pop();
		
//		ArrayDeque implements Queue
//		LinkedList implements Queue
//		PriorityQueue implements Queue
		
		
		//Queue
//		add			offer
//		remove		poll
//		element		peek
		
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> pq1 = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		Set<Integer> tset = new TreeSet<>();
		
		MyQueue<Integer> q = new MyQueue<>();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(100);
		System.out.println(q.peek());
		q.dequeue();
		q.enqueue(200);
		System.out.println(q.peek());
		//ArrayDeque - Array Deck
		//Deque extends Queue extends Collection
		//ArrayDeque implements Queue, Deque
		
		//Methods under Deque
//		offerFirst()  addFirst()
//		pollFirst()	removeFirst()
//		peekFirst()	getFirst()
//		
//		offerLast()	addLast()
//		pollLast()	removeLast()
//		peekLast()	getLast()
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Apple");
		pq.add("Kiwi");
		pq.add("Banana");
		pq.add("Watermelon");
		
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());System.out.println(pq.poll());
		
		
	}

}

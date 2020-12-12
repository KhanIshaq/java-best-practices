package practice;

import java.util.EmptyStackException;

public class MyLinkedList<E> {
	Node<E> head;
	
	
	public void add(E data) {
		Node<E> toAddNode = new Node<>(data);
		
		if(isEmpty()) {
			head = toAddNode;
			return;
		}
		
		Node<E> temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		temp.next = toAddNode;
		
	}
	
	public E remove() throws Exception {
		if(isEmpty()) {
			throw new Exception("Cannot remove element from Linked List");
		}
		
		Node<E> temp = head;
		if(temp.next == null) {
			head = null;
			return temp.data;
		}
		
		while(temp.next.next != null) {
			temp = temp.next;
		}
		
		E result = temp.next.data;
		temp.next = null;
		return (E) result;
	}
	
	public E getLast() throws Exception {
		if(isEmpty()) {
			throw new Exception("Cannot get last element from Linked List");
		}
		
		Node<E> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		Node<E> lastNode = temp;
		return (E) lastNode.data;
	}
	
	void print() {
		if(isEmpty())
			System.out.println("Empty LinkedList");
		
		Node<E> temp = head;
		while(temp!=null) {
			System.out.println(temp.data + " ");
			temp = temp.next; 
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public static class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}

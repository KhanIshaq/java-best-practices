/**
 * 
 */
package chapter11;

/**
 * @author nsa
 *
 *The synchronized keyword ensures that only a single thread can execute a method or block at one time. 
 *Many programmers think of synchronization solely as a means of mutual exclusion
 *These methods observe the state and optionally cause a state transition, transforming the object from one consistent state to another. 
 *Proper use of synchronization guarantees that no method will ever observe the object in an inconsistent state.
 *
 *
 */
public class I78 {
	
	//TODO Synchronization is required for reliable communication between threads as well as for mutual exclusion
	//TODO memory model, which specifies when and how changes made by one thread become visible to others
	//TODO  Do not use Thread.stop.
	
	
	//This optimization is known as hoisting, and it is precisely what the OpenJDK Server VM does. 
	//The result is a liveness failure: the program fails to make prog- ress. 
	
}

/**
 * 
 */
package chapter11;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author nsa
 *
 * Cooperative thread termination with a volatile field
 */
public class StopThreadGood {

	//TODO confine mutable data to a single thread. 
	//TODO If you adopt this policy, it is important to document it so that the policy is maintained as your program evolves.
	//Other threads can then read the object without further synchronization, so long as it isn’t modified again. 
	//Such objects are said to be effectively immutable. Transferring such an object reference from one thread to others is called safe publicatio
	
	// FIXME
	// safely publish an object reference
	//1)you can store it in a static field as part of class initialization; you can store it in a volatile field, a final field, or a field that is accessed with normal locking;
	//2) or you can put it into a concurrent collection
	
	// If you need only inter-thread communication, and not mutual exclusion, the volatile modifier is an acceptable form of synchronization, but it can be tricky to use correctly.
	private static volatile boolean  stopRequested;
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	
//		Thread backgroundThread = new Thread(() -> { 
//		
//			int i = 0;
//			while(!stopRequested) {
//				System.out.println(i);
//				i +=1;
//			}
//		});
//		backgroundThread.start();
//		TimeUnit.SECONDS.sleep(1);
//		System.out.println("Stopping");
//		stopRequested = true;
		//generateSerialNumber();
		generateSerialNumber1();
	}

	// You have to be careful when using volatile
	// Broken - requires synchronization!
	   private static volatile int nextSerialNumber = 0;
	   public static int generateSerialNumber() {
		   System.out.println(nextSerialNumber);
	       return nextSerialNumber++;
	}
	// Before the 1st thread after reading could write the new value, 2nd thread will read & write the old value from 1st thread.
	// This is a safety failure: the program computes the wrong results.
	   
	   
	   // Lock-free synchronization with java.util.concurrent.atomic
	   private static final AtomicLong nextSerialNumber1 = new AtomicLong(1);
	   public static long generateSerialNumber1() {
		   System.out.println(nextSerialNumber1);
	       return nextSerialNumber1.getAndIncrement();
	}
}

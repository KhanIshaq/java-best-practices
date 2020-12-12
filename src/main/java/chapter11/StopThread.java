/**
 * 
 */
package chapter11;

import java.util.concurrent.TimeUnit;

/**
 * @author nsa
 *
 *  Properly synchronized cooperative thread termination
 *  
 */
public class StopThread {

	private static boolean stopRequested;
	
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	
	private static synchronized boolean isStopRequested() {
		return stopRequested;
	}
	
//	 Synchronization is not guaranteed to work unless both read and write operations are synchronized. 
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			int i = 0;
			while(!isStopRequested()) {
				System.out.println(i);
				i = i+1;
			}
		});
		System.out.println("Starting");
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Stopping");
		requestStop();
		System.out.println(stopRequested);
	}
	//The locking here of StopThread can be omitted if stopRequested is declared volatile.
}

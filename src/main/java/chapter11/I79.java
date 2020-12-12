/**
 * 
 */
package chapter11;

/**
 * @author nsa
 *
 * Item 79: Avoid excessive synchronization
 */
public class I79 {

	// From the perspective of the class with the synchronized region, such methods are alien.
	//Depending on what an alien method does, calling it from a synchronized region can cause excep- tions, deadlocks, or data corruption.
}

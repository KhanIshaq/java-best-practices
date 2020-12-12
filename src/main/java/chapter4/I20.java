/**
 * 
 */
package chapter4;

/**
 * @author nsa
 *
 *Item20: Prefer interfaces to abstract classes
 *
 *Existing classes can easily be retrofitted to implement a new interface. 
 *For example, many existing classes were retrofitted to implement the Comparable, Iterable, and Autocloseable interfaces when they were added to the platform.
 *
 *a mixin is a type that a class can implement in addition to its “primary type,” to declare that it pro- vides some optional behavior.
 *For example, Comparable is a mixin interface 
 *Interfaces are ideal for defining mixins.
 *
 *Interfaces enable safe, powerful functionality enhancements via the wrapper class idiom
 *providing implementation assistance to pro- grammers in the form of a default method.
 *
 * If you provide default methods, be sure to document them for inheritance using the @implSpec Javadoc tag
 * 
 * Interface do not contain instance fields or nonpublic static members (with the exception of private static methods).
 * 
 * Combine interfaces and abstract classes by providing an abstract skeletal implementation class 
 * 
 * This is the Template Method pattern
 * 
 * By convention, skeletal implementation classes are called AbstractInterface, where Interface is the name of the interface they implement. 
 * For example, the Collections Framework provides a skeletal implementation to go along with each main collection interface: AbstractCollection, AbstractSet, AbstractList, and AbstractMap.
 */
public class I20 {

}

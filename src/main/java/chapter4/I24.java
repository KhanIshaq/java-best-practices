package chapter4;

/**
 * 
 * @author nsa
 * 
 * Item24: Favor static member classes over nonstatic
 * 
 * There are four kinds of nested classes: static member classes, nonstatic member classes, anonymous classes, and local classes. All but the first kind are known as inner classes. 
 * 
 * Within instance methods of a nonstatic member class, you can invoke methods on the enclosing instance or obtain a refer- ence to the enclosing instance using the qualified this construct
 * 
 * 
 * If you declare a member class that does not require access to an enclosing instance, always put the static modifier in its declaration,
 * 
 * 
 * Before lambdas were added to Java (Chapter 6), anonymous classes were the preferred means of creating small function objects and process objects on the fly, but lambdas are now preferred (Item 42). Another common use of anonymous classes is in the implementation of static factory methods (see intArrayAsList in Item 20).
 * 
 *  anonymous classes::
 *  You can’t instantiate them except at the point they’re declared. 
 *  You can’t perform instanceof tests or do anything else that requires you to name the class. You can’t declare an anonymous class to implement multiple interfaces or to extend a class and implement an interface at the same time. 
 *  Clients of an anonymous class can’t invoke any members except those it inherits from its supertype
 */
public class I24 {

}

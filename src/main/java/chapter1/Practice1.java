/**
 * 
 */
package chapter1;

import chapter1.Calzone.Sauce;
import chapter1.NyPizza.Size;
import chapter1.Pizza.Topping;

/**
 * @author nsa
 *
 */
public class Practice1 {

	
	public static void main(String[] args) {
	
		// SFM = Static Factory Methods
		// Item 1: Creating static factory methods
		// Advantages:
		//1. Unlike constructors SFM have names
		//2. Unlike constructors they are not required to create a new object each time they are invoked.
		// Booleab.valueOf()  does not create an object -> Flyweight Pattern
		// If equivalent objects are requested often, especially if they are expensive to create
		//3. Unlike Constructors they can return an object of any subtype of their return type.
		// Hiding the implementation classes leads to compact API, this technique is called interface-based frameworks
		// Interfaces provide natural return type for their static factory methods.
		
		//Interface Type has SFM in a noninstantiable companion class called Types
		
		//Java CF have 45 utility implementations of its interfaces
		//unmodifiable collections & synchronized collections
		//One non-instantiable class -> java.util.Collections
		
		//4. The call of the returned object can vary from call to call as function of the input parameters
		// EnumSet class has no public constructors only SFM
		// Below are subclasses of EnumSet
		//RegularEnumSet = 64 elements backed by a single long
		//JumboEnumSet = 65 or more elements factory is backed by long array
		
		
		// 5. The class of the returned object need not exist when the class containing the method is returned.
		//Service Provider Framework (SPI) like JDBC
		// The provider implements a service, the systems makes the implementation available to the clients, decoupling the client from implementations
		
		//Components of SPI
		// provider interface = represents implementation
		// provider registration = register implementations
		// service access API = Client
		// service provider interface = factory object which produces instances of the service interface
		//Connection
		//DriverManager.registerDriver
		//DriverManager.getConnection
		//Driver
		
		// java.util.ServiceLoader = you donot need to create SPI
		//JDBC doesnot use Service Loader
		// composition instead of inheritance
		// Limitations is that classes without public or protected constructors cannot be subclassed
		// Hard for programmers to find
		
		// impossible to subclass convenience implementation classes of CF
		
		//List of Factory Methods
		// from 
		// Date d = Date.from(instant);

		// of
		// Set<rank> faceCards = EnumSet.of(JACK,QUEEN,KING);
		// valueOf
		// BigInteger.valueOf(Integer.Max_VALUE);
		
		// instance or getInstance
		//StackWalker luke = StackWalker.getInstance(options)
		
		// create or newInstance
		// Object newArray = Array.newInstance(classobject, arrayLen);
		
		// getType
		// FileStore fs = Files.getFileStore(path)
		
		// newType
		// BufferedReader br = Files.newBufferedReader(path)
		
		// type
		// List<Complaint> litany = Collections.list(legacyLitany)
		
		//Item2 : Consider a builder when faced with many constructor parameters
		//telescoping constructor pattern,
		//one optional constructor pattern
		//two optional constructor pattern
		
		//JavaBeans Constructor
		
		//Builder Pattern -  easy to write and, more importantly, easy to read.
		// To ensure invariants against attack due check on parameters 
		// throw IllegalArgumentException
		
		//Hierarchical Builder Pattern
		
		//Abstract classes have abstract builders; concrete classes have concrete builders
		//consider an abstract class at the root of a hierarchy representing various kinds of pizza:
		
		//the Builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters
		
		NyPizza nypizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
		Calzone calzone = new Calzone.Builder(Sauce.GARLIC).addTopping(Topping.HAM).build();
		//Item 3: Enforce the singleton property with a private	constructor or an enum type

	}

}

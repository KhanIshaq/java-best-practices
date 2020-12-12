package chapter4;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author nsa
 *
 * Hashcode is invoked once & is cached.This technique, an example of lazy initialization (Item 83), is also used by String
 * 
 * Immutable class implement Serializable and it contains one or more fields that refer to mutable objects, you must provide an explicit 
 * readObject or readResolve method, or use the ObjectOutputStream.writeUnshared and ObjectInputStream.readUnshared methods, 
 * even if the default serialized form is acceptable
 * 
 * 
 */
public class Misc {

	//	 BigInteger moby = new BigInteger("1000000.00");
	//	 moby = moby.flipBit(0);
	   
	 //Java9
	 //BitSet moby1 = ...;
	 //moby1.flip(0);
	 
	 //the String class, whose mutable companion is StringBuilder (and its obsolete predecessor, StringBuffer).
	   
	//Item18: Favorcompositionoverinheritance
	public static void main(String[] args) {
		
		InstrumentedHashSet<String> ish = new InstrumentedHashSet<>();
		ish.addAll(Arrays.asList(new String[] {"Snap", "Crackle", "Pop"}));
		ish.stream().forEach(System.out::println);
		//This method invoked, HashSet’s addAll implementation using super.addAll
		//double-counted.
		System.out.println(ish.getAddCount()); // 6
		

	   //Set<Instant> times = new InstrumentedSet<>(new TreeSet<>(cmp));
	   //Set<E> s = new InstrumentedSet<>(new HashSet<>(INIT_CAPACITY));
		
//		static void walk(Set<Dog> dogs) {
//		       InstrumentedSet<Dog> iDogs = new InstrumentedSet<>(dogs);
//		       ... // Within this method use iDogs instead of dogs
//		}
	}
	
}

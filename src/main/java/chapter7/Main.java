package chapter7;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chapter6.Operation;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Main {


	//Item 42: Prefer lambdas to anonymous classes
	//Item43: Prefermethodreferencestolambdas
	//Item44: Favortheuseofstandardfunctionalinterfaces
	//Item45: Use streams judiciously 
	//Item46: Preferside-effect-freefunctionsinstreams

	private static BigInteger ONE = BigInteger.valueOf(1);
	private static BigInteger TWO = BigInteger.valueOf(2);
	
	// Using a toMap collector to make a map from string to enum
	private static final Map<String, Operation> stringToEnum =
		       Stream.of(Operation.values()).collect(toMap(Object::toString, e -> e));
	
	public static void main(String[] args) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(Integer key: map.keySet()) {
			map.merge(key, 1, (count, incr) -> count + incr);
			map.merge(key, 1, Integer::sum);
		}
		
		ExecutorService service = Executors.newFixedThreadPool(1);
		//service.execute(Main::action);
		//The lambda equivalent looks like this:
		service.execute(() -> action());
		
		//Types of Method References
		//Type
		//Static 				Integer::parseInt			str -> Integer.parseInt(str)
		//Bound					Instant.now()::isAfter		Instant then = Instant.now()
		//													t -> then.isAfter(t)
		//Unbound				String::toLowerCase			str->str.toLowerCase()
		//Class Constructor		TreeMap<K,v>::new			()-> new TreeMap<k,V>		
		//Array Constructor		int[]::new					len -> new int[len]
		
		//Where method references are shorter and clearer, use them; where they aren’t, stick with lambdas.
		
//		Interface				Function Signature
//		UnaryOperator<T>		T apply(T t)
//		BinaryOperator<T>		T apply(T t1, T t2)
//		Predicate<T>			boolean test(T t)
//		Function<T,R>			R apply(T t)
//		Supplier<T>				T get()
//		Consumer<T>				void accept(T t)
		
//		Example
//		String::toLowerCase
//		BigInteger::add
//		Collection::isEmpty
//		Arrays::asList
//		Instant::now
//		System.out::println
		
		//Variants that operate on primitive types int, long, and double.
		
		//IntPredicate
		//LongBinaryOperator
		
		//LongFunction<int[]> takes a long and returns an int[].
		
		
		//There are two-argument variants of Consumer that take one object reference and one primitive type: 
		//ObjDoubleConsumer<T>
		//ObjIntConsumer<T>
		//ObjLongConsumer<T>
		
		//ToIntBiFunction<T,U>
		//ToLongBiFunction<T,U>
		//ToDoubleBiFunction<T,U>
		
		Collections.sort(new ArrayList<>());
		List<Integer> al = new ArrayList<>();
		
		primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
         .filter(mersenne -> mersenne.isProbablePrime(50))
         .limit(20)
         //.forEach(System.out::println);
         .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
		
		
		File file = new File("/Users/nsa/Documents/eclipseWorkspace_2018_09/java8/src/main/resources/names.txt");
//	   // Uses the streams API but not the paradigm--Don't do this!
//	   Map<String, Long> freq = new HashMap<>();
//	   try (Stream<String> words = new Scanner(file).tokens()) {
//	       words.forEach(word -> {
//	           freq.merge(word.toLowerCase(), 1L, Long::sum);
//	       }); 
//	   }
		
		// Proper use of streams to initialize a frequency table
//		Map<String, Long> freq;
//		try (Stream<String> words = new Scanner(file).tokens()) {
//			freq = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
//		}
//		
//		freq.keySet()
//		    .stream()
//		    .sorted(comparing(freq::get).reversed())
//		    .limit(10)
//		    .collect(toList());
		
		
		List<Album> albums = new ArrayList<>();
		// Collector to generate a map from key to chosen element for key
//		Map<Artist, Album> topHits = albums.collect( toMap(Album::artist, a->a, maxBy(comparing(Album::sales))));
		
	}
	
	static Stream<BigInteger> primes() {
		
	    return Stream.iterate(TWO, BigInteger::nextProbablePrime);
	}
	
	private static void action() {}
	
	 // Iterative Cartesian product computation
   private static List<Card> newDeck() {
       List<Card> result = new ArrayList<>();
       for (Suit suit : Suit.values())
           for (Rank rank : Rank.values())
               result.add(new Card(suit, rank));
       return result;
   }
   
   // Stream-based Cartesian product computation
   private static List<Card> newDeck1() {
       return Stream.of(Suit.values())
    		   .flatMap(suit ->
    		    Stream.of(Rank.values())
    		.map(rank -> new Card(suit, rank))).collect(Collectors.toList());
   }

}

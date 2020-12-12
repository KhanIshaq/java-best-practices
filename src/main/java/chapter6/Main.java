package chapter6;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	public enum Planet {
		
		MERCURY(3.302e+23, 2.439e6), 
		VENUS  (4.869e+24, 6.052e6),
		EARTH  (5.975e+24, 6.378e6), 
		MARS   (6.419e+23, 3.393e6), 
		JUPITER(1.899e+27, 7.149e7),
		SATURN (5.685e+26, 6.027e7),
		URANUS (8.683e+25, 2.556e7),
		NEPTUNE(1.024e+26, 2.477e7), 
		PLUTO  (1.024e+26, 2.477e7);
			
		private final double mass;
		private final double radius;
		private final double surfaceGravity;
		private static final double G = 6.67300E-11;
		Planet(double mass, double radius){
			this.mass = mass;
			this.radius = radius;
			surfaceGravity = G * mass /(radius * radius);
		}
		
		public double mass() {return mass;}
		public double radius() {return radius;}
		public double surfaceGravity() {return surfaceGravity;}
		
		public double surfaceWeight(double mass) { return mass * surfaceGravity; }
		
	};
	
	public static void main(String[] args) {
		
		Set<Plant> garden = new HashSet<>();
		  // Using an EnumMap to associate data with an enum
		  Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle 
		  = new EnumMap<>(Plant.LifeCycle.class);
		   
		   
		   for (Plant.LifeCycle lc : Plant.LifeCycle.values())
		       plantsByLifeCycle.put(lc, new HashSet<>());
		   
		   for (Plant p : garden)
		       plantsByLifeCycle.get(p.lifeCycle).add(p);
		   System.out.println(plantsByLifeCycle);
		   
		// Naive stream-based approach - unlikely to produce an EnumMap! 
//		   System.out.println(Arrays.stream(garden)
//				   	.collect(groupingBy(p -> p.lifeCycle)));
		   
		// Using a stream and an EnumMap to associate data with an enum
//		 System.out.println(Arrays.stream(garden)
//		           .collect(groupingBy(p -> p.lifeCycle,
//		() -> new EnumMap<>(LifeCycle.class), toSet())));
		   
		   
		  double x = Double.parseDouble(args[0]); 
		  double y = Double.parseDouble(args[1]); 
		  test(ExtendedOperation.class, x, y);
		  
		  test1(Arrays.asList(ExtendedOperation.values()), x, y);

		   
	}
	
	

	private static <T extends Enum<T> & IOperation> void test( Class<T> opEnumType, double x, double y) {
	       for (IOperation op : opEnumType.getEnumConstants())
	           System.out.printf("%f %s %f = %f%n",
	                             x, op, y, op.apply(x, y));
	}
	
	private static void test1(Collection<? extends IOperation> opSet, double x, double y) {
	       for (IOperation op : opSet)
	           System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
	}
	
	//Item 34: Use enums instead of int constants
	//Item35: Use instance fields instead of ordinal
	//Item36: Use EnumSet instead of bit fields
	//Item37: Use EnumMap instead of ordinal
	//Item38: Emulate extensible enums with interfaces
	//Item39: Prefer annotations to naming patterns
	//Item40: Consistently use override annotation
	//Item41: Usemarkerinterfacestodefinetypes

}

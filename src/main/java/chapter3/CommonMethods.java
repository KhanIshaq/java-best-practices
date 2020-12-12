package chapter3;

import java.awt.Color;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author ishaqkhan
 *
 */
public class CommonMethods {

	static List<Point> pointList = Stream.of(
			new Point(1, 0), 
			new Point(0, 1), 
			new Point(-1, 0),
			new Point(0, -1)).collect(Collectors.toList());
	// Initialize unitCircle to contain all Points on the unit circle
	private static final Set<Point> unitCircle = new HashSet<>(pointList);

	public static void main(String[] args) {

		// This approach does provide symmetry, but at the expense of transitivity:
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

	}

	public static boolean onUnitCircle(Point p) {
		return unitCircle.contains(p);
	}
	
	// use the equals method to test for containment, and no CounterPoint instance is equal to any Point. 
	//If, however, you use a proper instanceof-based equals method on Point, the same onUnitCircle method works fine when presented with a CounterPoint instance.
	
	
	//When you are finished writing your equals method, ask yourself three questions: 
	//Is it symmetric? Is it transitive? Is it consistent? 

}

package chapter3;

import java.awt.Color;
import java.util.Objects;

//While there is no satisfactory way to extend an instantiable class and add a value component, 
//there is a fine workaround: Follow the advice of Item 18, “Favor composition over inheritance.” 
//Instead of having ColorPoint extend Point, give ColorPoint a private Point field and a public view method (Item 6) that returns the point at the same position as this color point:

//There are some classes in the Java platform libraries that do extend an instantiable class and add a value component. 
//For example, java.sql.Timestampextends java.util.Date and adds a nanoseconds field.

//Item 23, “Prefer class hierarchies to tagged classes.”
///you can add a value component to a subclass of an abstract class without violating the equals contract. 

//Whether or not a class is immutable, do not write an equals method that depends on unreliable resources. 

//Non-nullity—It says that all objects must be unequal to null

//the instanceof operator is specified to return false if its first operand is null, regardless of what type appears in the second operand [JLS, 15.20.2]. 
//Therefore, the type check will return false if null is passed in, so you don’t need an explicit null check.
public class ColorPoint {
	private final Point point;
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		point = new Point(x, y);
		this.color = Objects.requireNonNull(color);
	}

	/**
	 * Returns the point-view of this color point.
	 */
	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint))
			return false;
		ColorPoint cp = (ColorPoint) o;
		return cp.point.equals(point) && cp.color.equals(color);
	}

	// Broken - violates transitivity!
//	@Override
//	public boolean equals(Object o) {
//		if (!(o instanceof Point))
//			return false;
//		// If o is a normal Point, do a color-blind comparison
//		if (!(o instanceof ColorPoint))
//			return o.equals(this);
//		// o is a ColorPoint; do a full comparison
//		return super.equals(o) && ((ColorPoint) o).color == color;
//	}
	// Then a call to myColorPoint.equals(mySmellPoint) will throw a
	// StackOverflowError.

	// It turns out that this is a fundamental problem of equivalence relations in
	// object-oriented languages

	// **There is no way to extend an instantiable class and add a value component
	// while preserving the equals contract,
	// unless you’re willing to forgo the benefits of object-oriented abstraction.
	// **

	// Broken - violates Liskov substitution principle (page 43)
//	@Override
//	public boolean equals(Object o) {
//		if (o == null || o.getClass() != getClass())
//			return false;
//		Point p = (Point) o;
//		return p.x == x && p.y == y;
//	}
}
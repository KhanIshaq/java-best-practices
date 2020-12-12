/**
 * 
 */
package chapter4;

/**
 * @author nsa
 *	
 * An immutable class is simply a class whose instances cannot be modified.
 * Example : String, the boxed primitive classes, and BigInteger and BigDecimal. 
 * 
 *  Don’t provide methods that modify the object’s state (known as mutators).
 *  Ensure that the class can’t be extended.
 *  Make all fields final.
 *  Make all fields private.
 *  Ensure exclusive access to any mutable components.
 *  Make defensive copies (Item 50) in constructors, accessors, and readObject methods  
 *  
 *  java.util.Date and java.awt.Point are not mutable
 *  
 */
//Immutable objects are inherently thread-safe; they require no synchroni- zation.
//achieve thread safety. Since no thread can ever observe any effect of another thread on an immutable object, immutable objects can be shared freely.
//Not only can you share immutable objects, but they can share their internals. negate method produces a new BigInteger  
//easier to maintain the invariants of a complex object
//Immutable objects make great building blocks for other objects,
//The major disadvantage of immutable classes is that they require a separate object for each distinct value.
//resist the urge to write a setter for every getter. Classes should be immutable unless there’s a very good reason to make them mutable.
//small value objects, such as PhoneNumber and Complex, immutable.
//consider making larger value objects, such as String and BigInteger immutable
//provide a public mutable companion class only if it is necessary
//If a class cannot be made immutable, limit its mutability as much as possible
// make every field private final 
//Constructors should create fully initialized objects with all of their invari- ants established.
//Complex1 is not an industrial-strength complex number implementation.
// It uses the standard formulas for complex multiplication and division, which are not correctly rounded and provide poor semantics for complex NaNs and infinities
public final class Complex1 {	

	private final double re; 
	private final double im;
	
    public Complex1(double re, double im) {
        this.re = re;
        this.im = im;
    }
    //Using such static factories causes clients to share instances instead of creating new ones, reducing memory footprint and garbage collection costs. 
    //cache frequently requested instances 
    public static final Complex1 ZERO = new Complex1(0, 0);
    public static final Complex1 ONE  = new Complex1(1, 0);
    public static final Complex1 I    = new Complex1(0, 1);
    
    public double realPart()      { return re; }
    public double imaginaryPart() { return im; }
    
    //This pattern is known as the functional approach because methods return the result of applying a function to their operand, without modifying it
    //not provide a clone method or copy constructor (Item 13) on an immutable class
    public Complex1 plus(Complex1 c) {
        return new Complex1(re + c.re, im + c.im);
    }
    
    public Complex1 minus(Complex1 c) {
        return new Complex1(re - c.re, im - c.im);
    }
    
    public Complex1 times(Complex1 c) {
        return new Complex1(re * c.re - im * c.im,
                           re * c.im + im * c.re);
    }
    
    public Complex1 dividedBy(Complex1 c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex1((re * c.re + im * c.im) / tmp,
                           (im * c.re - re * c.im) / tmp);
    }
    
    @Override public boolean equals(Object o) {
       if (o == this)
           return true;
       if (!(o instanceof Complex1))
           return false;
       Complex1 c = (Complex1) o;
       // See page 47 to find out why we use compare instead of == 
       return Double.compare(c.re, re) == 0
           && Double.compare(c.im, im) == 0;
    }
    
    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }
    
    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
}
}

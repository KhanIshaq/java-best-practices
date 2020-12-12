package chapter3;

import java.util.Comparator;
import static java.util.Comparator.comparingInt;

// Class with a typical equals method
public final class PhoneNumber {
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 9999, "line num");
	}

	private static short rangeCheck(int val, int max, String arg) {
		if (val < 0 || val > max)
			throw new IllegalArgumentException(arg + ": " + val);
		return (short) val;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
	}

	// 1.Use the == operator to check if the argument is a reference to this object.
	// 2. Use the instanceof operator to check if the argument has the correct type.
	// 3.Cast the argument to the correct type.
	// 4. For each “significant” field in the class, check if that field of the
	// argument matches the corresponding field of this object.

	// Always override hashCode when you over ride equals(Item11).
	// • Don’t try to be too clever.
	// Don’t substitute another type for Object in the equals declaration.

	// Clone method for class with no references to mutable state
	@Override
	public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(); // Can't happen
		}
	}
	
	
	// Comparable with comparator construction methods
	private static final Comparator<PhoneNumber> COMPARATOR = comparingInt((PhoneNumber pn) -> pn.areaCode)
	             .thenComparingInt(pn -> pn.prefix)
	             .thenComparingInt(pn -> pn.lineNum);
	  
	public int compareTo(PhoneNumber pn) {
	       return COMPARATOR.compare(this, pn);
	}
	
	//If a class has multiple significant fields, compare the field until you find an unequal field or compare the least significant field
	// Multiple-field Comparable with primitive fields
	public int compareTo2(PhoneNumber pn) {
		int result = Short.compare(areaCode, pn.areaCode);
		if (result == 0) {
			result = Short.compare(prefix, pn.prefix);
			if (result == 0)
				result = Short.compare(lineNum, pn.lineNum);
		}
		return result;
	}
	
	
	 // Comparator based on static compare method
	   static Comparator<Object> hashCodeOrder = new Comparator<Object>() {
	       public int compare(Object o1, Object o2) {
	           return Integer.compare(o1.hashCode(), o2.hashCode());
	       }
	};
	//or a comparator construction method:
	   // Comparator based on Comparator construction method
	  static Comparator<Object> hashCodeOrder2 = Comparator.comparingInt(o -> o.hashCode());
}
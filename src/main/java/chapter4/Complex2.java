package chapter4;

// Immutable class with static factories instead of constructors
//multiple package-private implementation classes.
public class Complex2 {
   private final double re;
   private final double im;
       
	private Complex2(double re, double im) { 
		this.re = re;
	    this.im = im;
	}
	
	public static Complex2 valueOf(double re, double im) { 
		return new Complex2(re, im);
	}
   
	
//	public static BigInteger safeInstance(BigInteger val) {
//	       return val.getClass() == BigInteger.class ?
//	               val : new BigInteger(val.toByteArray());
//	}
 }
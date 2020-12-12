package chapter2;

import java.util.regex.Pattern;

// Reusing expensive object for improved performance (Pages 22 and 23)
public class RomanNumerals {
	// Performance can be greatly improved! (Page 22)
	static boolean isRomanNumeralSlow(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}

	// Reusing expensive object for improved performance (Page 23)
	private static final Pattern ROMAN = Pattern
			.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	static boolean isRomanNumeralFast(String s) {
		return ROMAN.matcher(s).matches();
	}

	public static void main(String[] args) {
		args = new String[] {"2","5"};
		int numSets = Integer.parseInt(args[0]);
		int numReps = Integer.parseInt(args[1]);
		boolean b = false;

		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			for (int j = 0; j < numReps; j++) {
				b ^= isRomanNumeralSlow("MCMLXXVI"); // Change Slow to Fast to see performance difference
				//265.9596 μs.
				//150.308 μs.
				//Without print
				//196.424 μs.
				//128.1484 μs.
				//b ^= isRomanNumeralFast("MCMLXXVI");
				//250.1834 μs.
				//77.9724 μs.
				//System.out.println(b);
				//Without print
				//92.6034 μs.
				//15.4718 μs.
			}
			long end = System.nanoTime();
			System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
		}

		// Prevents VM from optimizing away everything.
		if (!b)
			System.out.println();
	}
}
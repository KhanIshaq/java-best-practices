package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {

	public static void main(String[] args) {

	}

	// Code containing an annotation with an array parameter
	@ExceptionTest1({ IndexOutOfBoundsException.class, NullPointerException.class })
	public static void doublyBad() {
		List<String> list = new ArrayList<>();
		// The spec permits this method to throw either
		// IndexOutOfBoundsException or NullPointerException
		list.addAll(5, null);
	}

	
	// Code containing a repeated annotation
	@ExceptionTest2(IndexOutOfBoundsException.class)
	@ExceptionTest2(NullPointerException.class)
	public static void doublyBad1() {
		//
	}
}
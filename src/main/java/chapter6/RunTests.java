package chapter6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Program to process marker annotations
public class RunTests {

	public static void main(String[] args) throws ClassNotFoundException {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for(Method m : testClass.getDeclaredMethods()) {
			if(m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				
				}catch (InvocationTargetException wrappedExc) {
					Throwable exec = wrappedExc.getCause();
					System.out.println(m + " failed " + exec);
				}catch (Exception e) {
					System.out.println("Invalid @Test : " + m);
				}
			}
		}
		System.out.printf("Passed %d, Failed %d%n", passed, (tests - passed));
	}
}

package chapter6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests1 {

	public static void main(String[] args) throws ClassNotFoundException {
		int tests = 0;
		int passed = 0;
		
		Class<?> testClass = Class.forName(args[0]);
		
		for(Method m : testClass.getDeclaredMethods()) {
			 if (m.isAnnotationPresent(ExceptionTest.class)) {
			       tests++;
			       try {
			           m.invoke(null);
			           System.out.printf("Test %s failed: no exception%n", m);
			       } catch (InvocationTargetException wrappedEx) {
			           Throwable exc = wrappedEx.getCause();
			           Class<? extends Throwable> excType =
			               m.getAnnotation(ExceptionTest.class).value();
			           if (excType.isInstance(exc)) {
			               passed++;
			           } else {
			               System.out.printf(
			                   "Test %s failed: expected %s, got %s%n",
			                   m, excType.getName(), exc);
			           }
			       } catch (Exception exc) {
			           System.out.println("Invalid @Test: " + m);
			       }
			}
		}
	}
}


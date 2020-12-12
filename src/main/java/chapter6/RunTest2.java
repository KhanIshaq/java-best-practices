package chapter6;

import java.lang.reflect.Method;

public class RunTest2 {

	public static void main(String[] args) throws ClassNotFoundException {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);

		for(Method m : testClass.getDeclaredMethods()) {
			// Processing repeatable annotations
			if (m.isAnnotationPresent(ExceptionTest2.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (Throwable wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					int oldPassed = passed;
					ExceptionTest2[] excTests = m.getAnnotationsByType(ExceptionTest2.class);
					for (ExceptionTest2 excTest : excTests) {
						if (excTest.value().isInstance(exc)) {
							passed++;
							break;
						}
					}
					if (passed == oldPassed)
						System.out.printf("Test %s failed: %s %n", m, exc);
				}
			}
		}
	}
}

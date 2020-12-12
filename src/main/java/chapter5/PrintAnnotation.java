/**
 * 
 */
package chapter5;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * @author nsa
 *
 */
public class PrintAnnotation {

	static Annotation getAnnotation(AnnotatedElement element,
									String annotatedTypeName) {
		Class<?> annotationType = null;
		try {
			annotationType = Class.forName(annotatedTypeName);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		return element.getAnnotation(annotationType.asSubclass(Annotation.class));
				
	}
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		args = new String[2];
		args[0] = "javax.persistence.hibernate";
		args[1] = "Entity";
		if(args.length != 2) {
			System.out.println("Usage : Java PrintAnnotation <class> <annotation>");
			System.exit(1);
		}
		String className = args[0];
		String annotationTypeName = args[1];
		Class<?> kClass = Class.forName(className);
		System.out.println(getAnnotation(kClass, annotationTypeName));
	}

}

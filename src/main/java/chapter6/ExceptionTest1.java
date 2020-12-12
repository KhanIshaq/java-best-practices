package chapter6;

import java.lang.annotation.*;

// Annotation type with an array parameter
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest1 {
	Class<? extends Exception>[] value();
}
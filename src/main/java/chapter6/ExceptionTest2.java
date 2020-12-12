package chapter6;

import java.lang.annotation.*;

//Repeatable annotation type
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest2 {
    Class<? extends Exception> value();
}
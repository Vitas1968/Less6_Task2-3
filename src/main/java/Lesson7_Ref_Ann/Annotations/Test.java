package Lesson7_Ref_Ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test
{
    static class None extends Throwable {
        private static final long serialVersionUID = 1L;

        private None() {
        }
    }
    Class<? extends Throwable> expected() default None.class;

    int priority() default 5;
}

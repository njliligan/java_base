package com.njganlili.annotations;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CellStyle {

    public String name() default "miky";

    public String age() default "18";

}

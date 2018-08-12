package main.java.annotation;

import java.lang.annotation.*;

/**
 * Created by jagger on 2018/8/12.
 */
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NickNames.class)
@interface NickName {
    String value() default "none";
    int    time()  default 0;
}
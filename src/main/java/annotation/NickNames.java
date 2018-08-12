package main.java.annotation;

import java.lang.annotation.*;

/**
 * Created by liyujiang on 2018/8/12.
 */

@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NickNames {
    NickName[] value();
}
package com.example.dependency.di.framework.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Service field variables should use this annotation
 */
@Target({METHOD, CONSTRUCTOR, FIELD})
@Retention(RUNTIME)
@Documented
public @interface CustomAutowired {
}
package com.example.library.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // target class
@Retention(RetentionPolicy.RUNTIME) //jvm reflection
public @interface ContentView {

    int value();
}

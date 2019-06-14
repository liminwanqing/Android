package com.example.library.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EvenetBase {
    //set listener
    String listenerSetter();

    //new view.listener()
    Class<?> linsterType();

    //invoke callback
    String callBackListener();
}

package com.example.library.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EvenetBase(listenerSetter = "setOnLongClickListener", linsterType = View.OnLongClickListener.class, callBackListener = "onClick")
public @interface OnLongClick {
    int[] value();
}

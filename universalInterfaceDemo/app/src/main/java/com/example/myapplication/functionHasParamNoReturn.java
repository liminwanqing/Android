package com.example.myapplication;

public abstract class functionHasParamNoReturn<T> extends function {

    public functionHasParamNoReturn(String functionName) {
        super(functionName);
    }

    public abstract void function(T p);
}

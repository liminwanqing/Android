package com.example.myapplication;

public abstract class functionNoparamHasReturn<T> extends function {

    public functionNoparamHasReturn(String functionName) {
        super(functionName);
    }

    public abstract T function();
}

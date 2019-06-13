package com.example.myapplication;

public abstract class functionHasParamHasReturn<T,P> extends function {

    public functionHasParamHasReturn(String functionName) {
        super(functionName);
    }

    public abstract T function(P p);
}

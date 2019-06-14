package com.example.library;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class linstenerHandler implements InvocationHandler {
    private Object obj;

    private HashMap<String, Method> methodHashMap = new HashMap<>();

    public linstenerHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (null != obj) {
            String methodName = method.getName();
            Method current = methodHashMap.get(methodName);
            if (null != current) {
                if (method.getGenericParameterTypes().length == 0) {
                    return current.invoke(obj);
                }
                return current.invoke(obj, args);
            }
        }

        return null;
    }

    public void addMethod(String functionName, Method method) {
        methodHashMap.put(functionName, method);
    }
}

package com.example.myapplication;

import java.util.HashMap;

public class functionManager {
    private static functionManager instance;
    HashMap<String, functionHasParamHasReturn> functionHasParamHasReturnMap;
    HashMap<String, functionHasParamNoReturn> functionHasParamNoReturnMap;
    HashMap<String, functionNoparamHasReturn> functionNoparamHasReturnMap;
    HashMap<String, functionNoparamNoReturn> functionNoparamNoReturnMap;

    private functionManager() {
        functionHasParamHasReturnMap = new HashMap<>();
        functionHasParamNoReturnMap = new HashMap<>();
        functionNoparamHasReturnMap = new HashMap<>();
        functionNoparamNoReturnMap = new HashMap<>();
    }

    public static functionManager getInstance(){
        if (instance == null) {
            instance = new functionManager();
        }

        return instance ;
    }

    public void addFunction(functionNoparamHasReturn function){
        if (null != function) {
            functionNoparamHasReturnMap.put(function.functionName,function);
        }
    }

    public void removeFunction(String functionName) {
        if(null != functionName) {
            functionNoparamHasReturnMap.remove(functionName);
        }
    }

    public <T> T invokeFunction(String functionName, Class<T> t ) {
        if (functionName == null) {
            return null;
        }

        if(functionHasParamHasReturnMap == null) {
            return null;
        }

        functionNoparamHasReturn f = functionNoparamHasReturnMap.get(functionName);
        if (f != null) {
            if (t != null) {
                return t.cast(f.function());
            }
        }

        return null;
    }
}

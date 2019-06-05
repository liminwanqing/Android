package com.example.myapplication.ok;

import com.example.myapplication.Replace;

public class Caclutor {
    @Replace(clazz = "com.example.myapplication.Caclutor", method = "caclutor")
    public int caclutor() {
        int i = 1;
        int j = 10;
        return j/i;
    }
}

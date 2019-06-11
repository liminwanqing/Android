package com.example.myapplication;

public class GoodTeacher implements Teacher {

    @Override
    public String work() {
        System.out.println("老师教书育人...");
        return "教书";
    }
}

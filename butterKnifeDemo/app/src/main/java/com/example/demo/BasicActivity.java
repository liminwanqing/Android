package com.example.demo;

import android.os.Bundle;

import com.example.library.InjectManager;

import androidx.appcompat.app.AppCompatActivity;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InjectManager.inject(this);
    }

}

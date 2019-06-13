package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        functionManager.getInstance().addFunction(new functionNoparamHasReturn("test") {
            @Override
            public User function() {
                User user = new User("haha", 22);
                return user;
            }
        });

        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        functionManager.getInstance().removeFunction("test");
        super.onDestroy();
    }
}

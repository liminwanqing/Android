package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = functionManager.getInstance()
                        .invokeFunction("test", User.class);
                Log.e("SecondActivity", user.getName() + "---" + user.getAge());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

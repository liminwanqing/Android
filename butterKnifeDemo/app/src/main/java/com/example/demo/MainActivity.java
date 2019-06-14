package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.library.annotation.ContentView;
import com.example.library.annotation.InjectView;
import com.example.library.annotation.OnClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends BasicActivity {

//    private Button btn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//    }
    @InjectView(R.id.tv)
    private TextView tv;

    @InjectView(R.id.btn)
    private Button btn;

    private String name;

//    @OnClick({R.id.tv, R.id.btn})
//    public void show(View view) {
//        Toast.makeText(this, "show(View view)", Toast.LENGTH_LONG).show();
//    }

    @OnClick(R.id.btn)
    public void show() {
        Toast.makeText(this, "show()", Toast.LENGTH_LONG).show();

//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, btn.getText().toString(), Toast.LENGTH_LONG).show();
    }
}

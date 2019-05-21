package com.example.liuwanqing.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.show);

        findViewById(R.id.calc).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Calc c = new Calc();
                textview.setText(c.caculator());
            }
        });
        findViewById(R.id.fix).setOnClickListener((v) -> {fix();});
    }

    private void fix() {
        File file = new File(Environment.getExternalStorageDirectory(), "out.dex");
    }

}

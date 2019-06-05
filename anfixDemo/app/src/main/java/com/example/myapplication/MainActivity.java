package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        result = (TextView)findViewById(R.id.result);

        findViewById(R.id.calc).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Caclutor caclutor = new Caclutor();
                result.setText(""+caclutor.caclutor());
            }
        });

        findViewById(R.id.fix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fix();
            }
        });
    }

    private void fix() {
        File file = new File(Environment.getExternalStorageDirectory(), "out.dex");
        DexManager dexManager = new DexManager(this);
        dexManager.loadDex(file);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();
}

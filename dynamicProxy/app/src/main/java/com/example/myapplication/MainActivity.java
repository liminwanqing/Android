package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Teacher teahcer = new GoodTeacher();
        InvocationHandler handler = new workHandle(teahcer);

        Teacher proxy = (Teacher)Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                teahcer.getClass().getInterfaces(), handler);

        text = (TextView)findViewById(R.id.show);
        text.setText(proxy.work());
    }

    /**
     * I/System.out: before invoke。。。
     * I/System.out: 老师教书育人...
     * I/System.out: after invoke。。
     *   教书
     */
}

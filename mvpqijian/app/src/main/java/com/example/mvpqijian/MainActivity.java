package com.example.mvpqijian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements MvpView {
    TextView text;

    MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void initPresenter() {
        presenter = new MvpPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    // button 点击事件调用方法
    public void getData(View view){
        presenter.getData("normal");
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getData("error");
    }
}

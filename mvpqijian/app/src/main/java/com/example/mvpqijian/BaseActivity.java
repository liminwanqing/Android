package com.example.mvpqijian;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity extends Activity implements BaseView {

    /**
     * 获取Presenter实例，子类实现
     */
    public abstract BasePresenter getPresenter();

    /**
     * 初始化Presenter的实例，子类实现
     */
    public abstract void initPresenter();

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        if (getPresenter() != null){
            getPresenter().attachView(this);
        }

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null){
            getPresenter().detachView();
        }
    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        showToast(getResources().getString(R.string.api_error_msg));
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}

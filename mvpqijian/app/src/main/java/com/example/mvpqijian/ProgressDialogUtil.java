package com.example.mvpqijian;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ProgressDialogUtil {
    private static AlertDialog mAlertDialog;

    /**
     * 弹出耗时对话框
     * @param context
     */
    public static void showProcessDialog(Context context, String tip) {
        if (null == mAlertDialog) {
            mAlertDialog = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog )
                    .create();
        }

        View loadView = LayoutInflater.from(context).
                inflate(R.layout.custom_progress_dialog_view, null);
        mAlertDialog.setView(loadView, 0, 0,
                0, 0);
        mAlertDialog.setCancelable(false);
        TextView tvTip = loadView.findViewById(R.id.tvTip);
        tvTip.setText(tip);

        if (!mAlertDialog.isShowing()) {
            mAlertDialog.show();
        }
    }

    /**
     * 隐藏耗时对话框
     */
    public static void dismiss() {
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }
}

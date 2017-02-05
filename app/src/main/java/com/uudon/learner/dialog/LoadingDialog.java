package com.uudon.learner.dialog;

import android.app.Dialog;
import android.content.Context;

import com.uudon.learner.R;

/**
 * Created by Administrator on 2017/1/8.
 */

public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context,R.style.LoadingDdialog);

        setContentView(R.layout.dialog_loading);

        setCancelable(false);//禁止使用返回键取消
        setCanceledOnTouchOutside(false);//静止点击外边取消
    }
}

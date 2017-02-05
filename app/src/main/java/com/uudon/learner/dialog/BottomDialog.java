package com.uudon.learner.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.uudon.learner.R;

/**
 * Created by ShiXing on 2017/1/7.
 */

public class BottomDialog extends Dialog {

    private TextView mDialogContent;
    private TextView mDialogTitle;

    public BottomDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_bottom);
        initView();
    }

    private void initView() {
        mDialogTitle = (TextView) findViewById(R.id.tv_bottom_dialog_title);
        mDialogContent = (TextView) findViewById(R.id.tv_bottom_dialog_content);
    }

    public void setDialogContent(String content) {
        mDialogContent.setText(content);
    }

    public String getDialogContent() {
        return mDialogContent.getText().toString().trim();
    }

    public String getmDialogTitle() {
        return mDialogTitle.getText().toString().trim();
    }

    public void setmDialogTitle(String titleStr) {
        mDialogTitle.setText(titleStr);
    }

    @Override
    public void show() {
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;

        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.BottomDialog);
        window.setAttributes(layoutParams);
        super.show();
    }
}

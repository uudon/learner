package com.uudon.learner.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.uudon.learner.dialog.LoadingDialog;

/**
 * Created by Administrator on 2016/12/29.
 */

public abstract class BaseAcitivty extends AppCompatActivity {

    private LoadingDialog mLoadingDialog = null;
    private Context mContext = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = this;
        setContentView(getContentViewResId());

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle(getTitleStringID());
        }

        mLoadingDialog = new LoadingDialog(this);
        preInitView();
        preInitData();
    }

    public void showLoading(){
        mLoadingDialog.show();
    }

    public void hideLoading() {
        mLoadingDialog.hide();
    }

    protected abstract int getContentViewResId();

    protected abstract void preInitView();
    protected abstract void preInitData();

    protected abstract int getTitleStringID();

    protected void toast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    protected Context getContext(){
        return mContext;
    }
}

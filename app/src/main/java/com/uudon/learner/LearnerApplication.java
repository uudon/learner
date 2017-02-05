package com.uudon.learner;

import android.app.Application;

import com.lidroid.xutils.DbUtils;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2017/1/1.
 */

public class LearnerApplication extends Application {

    //程序真正的入口点
    @Override
    public void onCreate() {
        super.onCreate();

        Bmob.initialize(this,"ea2cad168eec95dc95bad012f5a787a4");
    }
}

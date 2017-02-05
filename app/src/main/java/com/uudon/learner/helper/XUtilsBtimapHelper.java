package com.uudon.learner.helper;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by Administrator on 2017/1/11.
 */

public class XUtilsBtimapHelper {
    private XUtilsBtimapHelper(){

    }

    private static BitmapUtils bitmapUtils;

    public static BitmapUtils getBitmapUtils(Context appContext) {
        if (bitmapUtils == null) {
            bitmapUtils = new BitmapUtils(appContext);
        }
        return bitmapUtils;
    }
}

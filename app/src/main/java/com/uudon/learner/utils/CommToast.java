package com.uudon.learner.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/5.
 */

public class CommToast {

    public static void ToastShow(Context mContext, int resId, int duration, boolean...isGravity) {
        Toast toast = Toast.makeText(mContext, resId, duration);
        if(isGravity != null && isGravity.length > 0 && isGravity[0])
            toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void ToastShow(Context mContext, CharSequence text, int duration, boolean...isGravity) {
        Toast toast = Toast.makeText(mContext, text, duration);
        if(isGravity != null && isGravity.length > 0 && isGravity[0])
            toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static Toast Toast(Context mContext, int resId, int duration, boolean...isGravity) {
        Toast toast = Toast.makeText(mContext, resId, duration);
        if(isGravity != null && isGravity.length > 0 && isGravity[0])
            toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;
    }

    public static Toast Toast(Context mContext, CharSequence text, int duration, boolean...isGravity) {
        Toast toast = Toast.makeText(mContext, text, duration);
        if(isGravity != null && isGravity.length > 0 && isGravity[0])
            toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;
    }
}

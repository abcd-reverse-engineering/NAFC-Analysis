package com.luck.picture.lib.tools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: classes.dex */
public class ScreenUtils {
    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - getStatusBarHeight(context);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) throws Resources.NotFoundException, ClassNotFoundException {
        int dimensionPixelSize;
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            dimensionPixelSize = context.getApplicationContext().getResources().getDimensionPixelSize(((Integer) cls.getField("status_bar_height").get(cls.newInstance())).intValue());
        } catch (Exception e2) {
            e2.printStackTrace();
            dimensionPixelSize = 0;
        }
        return dimensionPixelSize == 0 ? dip2px(context, 25.0f) : dimensionPixelSize;
    }
}

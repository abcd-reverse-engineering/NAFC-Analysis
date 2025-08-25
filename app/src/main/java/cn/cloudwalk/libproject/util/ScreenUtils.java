package cn.cloudwalk.libproject.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import anet.channel.strategy.dispatch.DispatchConstants;

/* loaded from: classes.dex */
public class ScreenUtils {
    private ScreenUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getStatusHeight(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NumberFormatException {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static Bitmap snapShotWithStatusBar(Activity activity) {
        Bitmap bitmapCreateBitmap = null;
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            decorView.buildDrawingCache();
            bitmapCreateBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, 0, getScreenWidth(activity), getScreenHeight(activity));
            decorView.destroyDrawingCache();
            return bitmapCreateBitmap;
        } catch (Error e2) {
            e2.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        Bitmap bitmapCreateBitmap = null;
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            decorView.buildDrawingCache();
            Bitmap drawingCache = decorView.getDrawingCache();
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, 0, i2, getScreenWidth(activity), getScreenHeight(activity) - i2);
            decorView.destroyDrawingCache();
            return bitmapCreateBitmap;
        } catch (Error e2) {
            e2.printStackTrace();
            return bitmapCreateBitmap;
        }
    }
}

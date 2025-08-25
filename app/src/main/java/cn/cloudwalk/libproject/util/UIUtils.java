package cn.cloudwalk.libproject.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import c.c.a.b.a.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class UIUtils {
    private UIUtils() {
    }

    public static boolean checkDeviceHasNavigationBar(Context context) {
        return (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
    }

    public static float getBottomHeight(WindowManager windowManager) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        float f2 = 0.0f;
        if (windowManager == null) {
            return 0.0f;
        }
        float height = windowManager.getDefaultDisplay().getHeight();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            f2 = displayMetrics.heightPixels;
        } catch (ClassNotFoundException e2) {
            cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e2.getMessage());
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e4.getMessage());
        } catch (InvocationTargetException e5) {
            cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e5.getMessage());
        }
        return f2 - height;
    }

    private static String getNavBarOverride() throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (ClassNotFoundException e2) {
                cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e2.getMessage());
            } catch (IllegalAccessException e3) {
                cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e3.getMessage());
            } catch (NoSuchMethodException e4) {
                cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e4.getMessage());
            } catch (InvocationTargetException e5) {
                cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e5.getMessage());
            }
        }
        return null;
    }

    public static int getNavigationBarHeight(Activity activity) {
        Resources resources = activity.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static int getStatusBarHeight(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NumberFormatException {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (ClassNotFoundException e2) {
            cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e2.getMessage());
            return 40;
        } catch (IllegalAccessException e3) {
            cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e3.getMessage());
            return 40;
        } catch (InstantiationException e4) {
            cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e4.getMessage());
            return 40;
        } catch (NoSuchFieldException e5) {
            cn.cloudwalk.util.LogUtils.LOGE(cn.cloudwalk.util.LogUtils.LOG_EXCEPTION, e5.getMessage());
            return 40;
        }
    }

    public static boolean hasNavBar(Context context) throws Resources.NotFoundException, NoSuchMethodException, SecurityException {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", DispatchConstants.ANDROID);
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String navBarOverride = getNavBarOverride();
        if ("1".equals(navBarOverride)) {
            return false;
        }
        if ("0".equals(navBarOverride)) {
            return true;
        }
        return z;
    }

    public static void hideBottomUIMenu(Window window, Context context) {
        if (hasNavBar(context)) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 11 && i2 < 19) {
                window.getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                window.getDecorView().setSystemUiVisibility(3846);
                window.addFlags(a.C1);
            }
        }
    }
}

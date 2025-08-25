package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public abstract class ResourceLoaderUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Context f7408a;

    /* renamed from: b, reason: collision with root package name */
    private static String f7409b;

    public static int getAnimId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", f7409b);
    }

    public static int getColorId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, RemoteMessageConst.Notification.COLOR, f7409b);
    }

    public static int getDimenId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", f7409b);
    }

    public static Drawable getDrawable(String str) {
        Context context = f7408a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", f7409b);
    }

    public static int getIdId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", f7409b);
    }

    public static int getLayoutId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", f7409b);
    }

    public static String getString(String str) {
        Context context = f7408a;
        return context == null ? "" : context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "string", f7409b);
    }

    public static int getStyleId(String str) {
        Context context = f7408a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "style", f7409b);
    }

    public static Context getmContext() {
        return f7408a;
    }

    public static void setmContext(Context context) {
        f7408a = context;
        if (context != null) {
            f7409b = context.getPackageName();
        } else {
            f7409b = null;
            HMSLog.e("ResourceLoaderUtil", "context is null");
        }
    }

    public static String getString(String str, Object... objArr) {
        Context context = f7408a;
        return context == null ? "" : context.getResources().getString(getStringId(str), objArr);
    }
}

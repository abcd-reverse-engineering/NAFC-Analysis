package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* loaded from: classes.dex */
public class ContextUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Context f7655a;

    public static Context getInstance() {
        return f7655a;
    }

    public static void setContext(Context context) {
        if (context == null || f7655a != null) {
            return;
        }
        f7655a = context.getApplicationContext();
    }
}

package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f9798a;

    /* renamed from: b, reason: collision with root package name */
    private static String f9799b;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f9798a)) {
            return f9798a;
        }
        if (context == null) {
            return "";
        }
        f9798a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f9798a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f9798a;
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }
}

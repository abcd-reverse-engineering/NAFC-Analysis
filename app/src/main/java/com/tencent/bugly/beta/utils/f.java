package com.tencent.bugly.beta.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Toast f8923a;

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = f8923a;
        if (toast == null) {
            f8923a = Toast.makeText(context, str, 0);
        } else {
            toast.setText(str);
        }
        f8923a.show();
    }
}

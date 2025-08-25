package com.umeng.message.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class ap {

    /* renamed from: b, reason: collision with root package name */
    private static volatile ap f11296b;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f11297a = x.a().getSharedPreferences("umeng_push", 0);

    private ap() {
    }

    public static ap a() {
        if (f11296b == null) {
            synchronized (ap.class) {
                if (f11296b == null) {
                    f11296b = new ap();
                }
            }
        }
        return f11296b;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11297a.edit().putString(str, str2).apply();
    }

    public final void a(String str) {
        if (this.f11297a.contains(str)) {
            this.f11297a.edit().remove(str).apply();
        }
    }
}

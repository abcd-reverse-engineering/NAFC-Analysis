package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;

/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private static ap f13378a;

    /* renamed from: a, reason: collision with other field name */
    private int f1008a = 0;

    /* renamed from: a, reason: collision with other field name */
    private Context f1009a;

    private ap(Context context) {
        this.f1009a = context.getApplicationContext();
    }

    public static ap a(Context context) {
        if (f13378a == null) {
            f13378a = new ap(context);
        }
        return f13378a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m701a() {
        return com.xiaomi.push.x.f1107a.contains("xmsf") || com.xiaomi.push.x.f1107a.contains("xiaomi") || com.xiaomi.push.x.f1107a.contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i2 = this.f1008a;
        if (i2 != 0) {
            return i2;
        }
        try {
            this.f1008a = Settings.Global.getInt(this.f1009a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f1008a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a, reason: collision with other method in class */
    public Uri m700a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}

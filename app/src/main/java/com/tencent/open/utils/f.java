package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f9916a;

    /* renamed from: b, reason: collision with root package name */
    private String f9917b;

    /* compiled from: ProGuard */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static f f9918a = new f();
    }

    public static f a() {
        return a.f9918a;
    }

    public String b(Context context) {
        return this.f9916a;
    }

    public String c(Context context) {
        return this.f9917b;
    }

    private f() {
        this.f9916a = "";
        this.f9917b = "";
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 4);
        String str = this.f9917b;
        if (str == null || str.trim().isEmpty()) {
            this.f9917b = sharedPreferences.getString("build_model", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, model = " + this.f9917b);
        }
        String str2 = this.f9916a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.f9916a = sharedPreferences.getString("build_device", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, device = " + this.f9916a);
        }
    }

    public String b() {
        return this.f9917b;
    }

    public void a(Context context, String str) {
        SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, model = " + str);
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.f9917b;
            if (str2 != null && str2.equals(str)) {
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, needn't update sp.");
                return;
            }
            this.f9917b = str;
            if (context != null) {
                context.getSharedPreferences("device_info_file", 4).edit().putString("build_model", this.f9917b).commit();
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, update sp.");
                return;
            }
            return;
        }
        this.f9917b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 4).edit().remove("build_model").commit();
        }
    }
}

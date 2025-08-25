package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SpWrapper.java */
/* loaded from: classes2.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10055a = "cl_count";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10056b = "interval_";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10057c = "config_ts";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10058d = "iucc_s1";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10059e = "iucc_s2";

    /* renamed from: f, reason: collision with root package name */
    public static final String f10060f = "sdk_type_ver";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10061g = "should_fetch";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10062h = "ccg_sp_config_file";

    private aq() {
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f10062h, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}

package com.umeng.commonsdk.internal;

import android.content.Context;

/* compiled from: UMInternalData.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f10768b;

    /* renamed from: a, reason: collision with root package name */
    private Context f10769a;

    /* renamed from: c, reason: collision with root package name */
    private c f10770c;

    private b(Context context) {
        this.f10769a = context;
        this.f10770c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (f10768b == null) {
            f10768b = new b(context.getApplicationContext());
        }
        return f10768b;
    }

    public c a() {
        return this.f10770c;
    }
}

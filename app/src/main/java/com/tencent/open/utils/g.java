package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static Context f9919a;

    public static final Context a() {
        Context context = f9919a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context contextA = a();
        if (contextA != null) {
            return contextA.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        f9919a = context;
    }

    public static final File a(String str) {
        return m.h(a(), str);
    }
}

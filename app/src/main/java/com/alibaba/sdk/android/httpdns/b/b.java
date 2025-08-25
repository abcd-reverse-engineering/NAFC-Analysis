package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static f f4004a = null;

    /* renamed from: a, reason: collision with other field name */
    private static com.alibaba.sdk.android.httpdns.c.a f5a = null;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f6a = false;
    private static boolean n = true;

    public static List<e> a() {
        ArrayList arrayList = new ArrayList();
        if (!f6a) {
            return arrayList;
        }
        arrayList.addAll(f4004a.a());
        return arrayList;
    }

    public static void a(Context context) {
        a(context, (com.alibaba.sdk.android.httpdns.c.a) null);
    }

    public static void a(Context context, com.alibaba.sdk.android.httpdns.c.a aVar) {
        f4004a = new a(context);
        f5a = aVar;
        if (f5a == null) {
            f5a = com.alibaba.sdk.android.httpdns.c.a.a();
        }
    }

    public static void a(e eVar) {
        if (eVar == null) {
            return;
        }
        f4004a.a(eVar);
    }

    public static void a(boolean z, boolean z2) {
        f6a = z;
        n = z2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m9a() {
        return f6a;
    }

    public static void b(Context context) {
        if (context != null) {
            f5a.c(context);
        }
    }

    public static void b(e eVar) {
        if (eVar == null) {
            return;
        }
        f4004a.b(eVar);
    }

    public static boolean g() {
        return n;
    }

    public static String i() {
        return f5a.i();
    }
}

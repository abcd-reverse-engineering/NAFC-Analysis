package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static z0 f6934a;

    private static synchronized z0 a() {
        if (f6934a == null) {
            f6934a = q.c().b();
        }
        return f6934a;
    }

    public static void a(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i2 == 1 || i2 == 0) {
            f6934a.a(i2, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i2);
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            f6934a.a(context, str, str2);
        }
    }

    public static void b(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i2 == 1 || i2 == 0) {
            f6934a.b(i2, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i2);
    }

    public static boolean b() {
        return q.c().a();
    }

    public static void c() {
        if (a() == null || !q1.b().a()) {
            return;
        }
        f6934a.a(-1);
    }
}

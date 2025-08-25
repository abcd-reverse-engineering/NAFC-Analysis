package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CollectController.java */
/* loaded from: classes2.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f10673a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Object f10674b = new Object();

    /* compiled from: CollectController.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f10675a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f10675a;
    }

    public void a() {
        synchronized (f10674b) {
            f10673a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f10674b) {
            if (!f10673a.containsKey(str)) {
                return true;
            }
            return f10673a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f10674b) {
                if (f10673a != null) {
                    f10673a.put(str, bool);
                }
            }
        }
    }
}

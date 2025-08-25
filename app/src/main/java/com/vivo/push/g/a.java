package com.vivo.push.g;

import java.util.ArrayList;

/* compiled from: TestManager.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f12079a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f12080b;

    /* compiled from: TestManager.java */
    /* renamed from: com.vivo.push.g.a$a, reason: collision with other inner class name */
    private static class C0161a {

        /* renamed from: a, reason: collision with root package name */
        private static a f12081a = new a(0);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0161a.f12081a;
    }

    public final boolean b() {
        ArrayList<String> arrayList = this.f12080b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private a() {
        this.f12080b = null;
        this.f12080b = new ArrayList<>();
    }
}

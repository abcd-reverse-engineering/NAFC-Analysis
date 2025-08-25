package com.xiaomi.push;

import java.util.Map;

/* loaded from: classes2.dex */
public class fb implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public static String f12811a = "wcc-ml-test10.bj";

    /* renamed from: b, reason: collision with root package name */
    public static String f12812b;

    /* renamed from: a, reason: collision with other field name */
    private int f509a;

    /* renamed from: a, reason: collision with other field name */
    private fe f510a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f511a = fa.f494a;

    /* renamed from: b, reason: collision with other field name */
    private boolean f512b = true;

    /* renamed from: c, reason: collision with root package name */
    private String f12813c;

    /* renamed from: d, reason: collision with root package name */
    private String f12814d;

    /* renamed from: e, reason: collision with root package name */
    private String f12815e;

    public fb(Map<String, Integer> map, int i2, String str, fe feVar) {
        a(map, i2, str, feVar);
    }

    public static final String a() {
        String str = f12812b;
        return str != null ? str : x.m766a() ? "sandbox.xmpush.xiaomi.com" : x.b() ? "10.38.162.35" : "app.chat.xiaomi.net";
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] mo422a() {
        return null;
    }

    public void b(String str) {
        this.f12815e = str;
    }

    public String c() {
        if (this.f12814d == null) {
            this.f12814d = a();
        }
        return this.f12814d;
    }

    public String b() {
        return this.f12815e;
    }

    public static final void a(String str) {
        if (x.b()) {
            return;
        }
        f12812b = str;
    }

    public void c(String str) {
        this.f12814d = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fe feVar) {
        this.f509a = i2;
        this.f12813c = str;
        this.f510a = feVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m420a() {
        return this.f509a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m421a() {
        return this.f511a;
    }

    public void a(boolean z) {
        this.f511a = z;
    }
}

package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bl extends m {

    /* renamed from: i, reason: collision with root package name */
    static Map<String, String> f9360i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public long f9361a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f9362b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f9363c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f9364d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f9365e = "";

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f9366f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f9367g = "";

    /* renamed from: h, reason: collision with root package name */
    public boolean f9368h = true;

    static {
        f9360i.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9361a, 0);
        lVar.b(this.f9362b, 1);
        String str = this.f9363c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.f9364d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f9365e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f9366f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f9367g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f9368h, 7);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9361a = kVar.a(this.f9361a, 0, true);
        this.f9362b = kVar.a(this.f9362b, 1, true);
        this.f9363c = kVar.a(2, false);
        this.f9364d = kVar.a(3, false);
        this.f9365e = kVar.a(4, false);
        this.f9366f = (Map) kVar.a((k) f9360i, 5, false);
        this.f9367g = kVar.a(6, false);
        this.f9368h = kVar.a(this.f9368h, 7, false);
    }
}

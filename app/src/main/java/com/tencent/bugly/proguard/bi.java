package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bi extends m {

    /* renamed from: i, reason: collision with root package name */
    static byte[] f9335i = new byte[1];

    /* renamed from: j, reason: collision with root package name */
    static Map<String, String> f9336j;

    /* renamed from: a, reason: collision with root package name */
    public byte f9337a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f9338b = 0;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f9339c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f9340d = "";

    /* renamed from: e, reason: collision with root package name */
    public long f9341e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f9342f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f9343g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f9344h = null;

    static {
        f9335i[0] = 0;
        f9336j = new HashMap();
        f9336j.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.b(this.f9337a, 0);
        lVar.a(this.f9338b, 1);
        byte[] bArr = this.f9339c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.f9340d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f9341e, 4);
        String str2 = this.f9342f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f9343g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f9344h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9337a = kVar.a(this.f9337a, 0, true);
        this.f9338b = kVar.a(this.f9338b, 1, true);
        this.f9339c = kVar.a(f9335i, 2, false);
        this.f9340d = kVar.a(3, false);
        this.f9341e = kVar.a(this.f9341e, 4, false);
        this.f9342f = kVar.a(5, false);
        this.f9343g = kVar.a(6, false);
        this.f9344h = (Map) kVar.a((k) f9336j, 7, false);
    }
}

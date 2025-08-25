package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bh extends m {
    static byte[] y = new byte[1];
    static Map<String, String> z;

    /* renamed from: a, reason: collision with root package name */
    public int f9322a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f9323b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f9324c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f9325d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f9326e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f9327f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f9328g = 0;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f9329h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f9330i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f9331j = "";

    /* renamed from: k, reason: collision with root package name */
    public Map<String, String> f9332k = null;

    /* renamed from: l, reason: collision with root package name */
    public String f9333l = "";

    /* renamed from: m, reason: collision with root package name */
    public long f9334m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public long q = 0;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";

    static {
        y[0] = 0;
        z = new HashMap();
        z.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9322a, 0);
        lVar.a(this.f9323b, 1);
        lVar.a(this.f9324c, 2);
        lVar.a(this.f9325d, 3);
        String str = this.f9326e;
        if (str != null) {
            lVar.a(str, 4);
        }
        lVar.a(this.f9327f, 5);
        lVar.a(this.f9328g, 6);
        lVar.a(this.f9329h, 7);
        String str2 = this.f9330i;
        if (str2 != null) {
            lVar.a(str2, 8);
        }
        String str3 = this.f9331j;
        if (str3 != null) {
            lVar.a(str3, 9);
        }
        Map<String, String> map = this.f9332k;
        if (map != null) {
            lVar.a((Map) map, 10);
        }
        String str4 = this.f9333l;
        if (str4 != null) {
            lVar.a(str4, 11);
        }
        lVar.a(this.f9334m, 12);
        String str5 = this.n;
        if (str5 != null) {
            lVar.a(str5, 13);
        }
        String str6 = this.o;
        if (str6 != null) {
            lVar.a(str6, 14);
        }
        String str7 = this.p;
        if (str7 != null) {
            lVar.a(str7, 15);
        }
        lVar.a(this.q, 16);
        String str8 = this.r;
        if (str8 != null) {
            lVar.a(str8, 17);
        }
        String str9 = this.s;
        if (str9 != null) {
            lVar.a(str9, 18);
        }
        String str10 = this.t;
        if (str10 != null) {
            lVar.a(str10, 19);
        }
        String str11 = this.u;
        if (str11 != null) {
            lVar.a(str11, 20);
        }
        String str12 = this.v;
        if (str12 != null) {
            lVar.a(str12, 21);
        }
        String str13 = this.w;
        if (str13 != null) {
            lVar.a(str13, 22);
        }
        String str14 = this.x;
        if (str14 != null) {
            lVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9322a = kVar.a(this.f9322a, 0, true);
        this.f9323b = kVar.a(1, true);
        this.f9324c = kVar.a(2, true);
        this.f9325d = kVar.a(3, true);
        this.f9326e = kVar.a(4, false);
        this.f9327f = kVar.a(5, true);
        this.f9328g = kVar.a(this.f9328g, 6, true);
        this.f9329h = kVar.a(y, 7, true);
        this.f9330i = kVar.a(8, false);
        this.f9331j = kVar.a(9, false);
        this.f9332k = (Map) kVar.a((k) z, 10, false);
        this.f9333l = kVar.a(11, false);
        this.f9334m = kVar.a(this.f9334m, 12, false);
        this.n = kVar.a(13, false);
        this.o = kVar.a(14, false);
        this.p = kVar.a(15, false);
        this.q = kVar.a(this.q, 16, false);
        this.r = kVar.a(17, false);
        this.s = kVar.a(18, false);
        this.t = kVar.a(19, false);
        this.u = kVar.a(20, false);
        this.v = kVar.a(21, false);
        this.w = kVar.a(22, false);
        this.x = kVar.a(23, false);
    }
}

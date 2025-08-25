package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bf extends m {
    static ArrayList<be> A;
    static Map<String, String> B;
    static Map<String, String> C;
    static Map<String, String> v = new HashMap();
    static bd w;
    static bc x;
    static ArrayList<bc> y;
    static ArrayList<bc> z;

    /* renamed from: a, reason: collision with root package name */
    public String f9307a = "";

    /* renamed from: b, reason: collision with root package name */
    public long f9308b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f9309c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f9310d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f9311e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f9312f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f9313g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f9314h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f9315i = "";

    /* renamed from: j, reason: collision with root package name */
    public bd f9316j = null;

    /* renamed from: k, reason: collision with root package name */
    public int f9317k = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f9318l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f9319m = "";
    public bc n = null;
    public ArrayList<bc> o = null;
    public ArrayList<bc> p = null;
    public ArrayList<be> q = null;
    public Map<String, String> r = null;
    public Map<String, String> s = null;
    public String t = "";
    public boolean u = true;

    static {
        v.put("", "");
        w = new bd();
        x = new bc();
        y = new ArrayList<>();
        y.add(new bc());
        z = new ArrayList<>();
        z.add(new bc());
        A = new ArrayList<>();
        A.add(new be());
        B = new HashMap();
        B.put("", "");
        C = new HashMap();
        C.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9307a, 0);
        lVar.a(this.f9308b, 1);
        lVar.a(this.f9309c, 2);
        String str = this.f9310d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f9311e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f9312f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f9313g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f9314h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f9315i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bd bdVar = this.f9316j;
        if (bdVar != null) {
            lVar.a((m) bdVar, 9);
        }
        lVar.a(this.f9317k, 10);
        String str6 = this.f9318l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f9319m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bc bcVar = this.n;
        if (bcVar != null) {
            lVar.a((m) bcVar, 13);
        }
        ArrayList<bc> arrayList = this.o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bc> arrayList2 = this.p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<be> arrayList3 = this.q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.u, 20);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9307a = kVar.a(0, true);
        this.f9308b = kVar.a(this.f9308b, 1, true);
        this.f9309c = kVar.a(2, true);
        this.f9310d = kVar.a(3, false);
        this.f9311e = kVar.a(4, false);
        this.f9312f = kVar.a(5, false);
        this.f9313g = kVar.a(6, false);
        this.f9314h = (Map) kVar.a((k) v, 7, false);
        this.f9315i = kVar.a(8, false);
        this.f9316j = (bd) kVar.a((m) w, 9, false);
        this.f9317k = kVar.a(this.f9317k, 10, false);
        this.f9318l = kVar.a(11, false);
        this.f9319m = kVar.a(12, false);
        this.n = (bc) kVar.a((m) x, 13, false);
        this.o = (ArrayList) kVar.a((k) y, 14, false);
        this.p = (ArrayList) kVar.a((k) z, 15, false);
        this.q = (ArrayList) kVar.a((k) A, 16, false);
        this.r = (Map) kVar.a((k) B, 17, false);
        this.s = (Map) kVar.a((k) C, 18, false);
        this.t = kVar.a(19, false);
        this.u = kVar.a(this.u, 20, false);
    }
}

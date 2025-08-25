package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class y extends m implements Cloneable {
    static v q;
    static u r;
    static u s;
    static Map<String, String> t;
    static final /* synthetic */ boolean u = !y.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public String f9475a;

    /* renamed from: b, reason: collision with root package name */
    public String f9476b;

    /* renamed from: c, reason: collision with root package name */
    public long f9477c;

    /* renamed from: d, reason: collision with root package name */
    public int f9478d;

    /* renamed from: e, reason: collision with root package name */
    public v f9479e;

    /* renamed from: f, reason: collision with root package name */
    public u f9480f;

    /* renamed from: g, reason: collision with root package name */
    public byte f9481g;

    /* renamed from: h, reason: collision with root package name */
    public int f9482h;

    /* renamed from: i, reason: collision with root package name */
    public long f9483i;

    /* renamed from: j, reason: collision with root package name */
    public u f9484j;

    /* renamed from: k, reason: collision with root package name */
    public String f9485k;

    /* renamed from: l, reason: collision with root package name */
    public Map<String, String> f9486l;

    /* renamed from: m, reason: collision with root package name */
    public String f9487m;
    public int n;
    public long o;
    public int p;

    public y() {
        this.f9475a = "";
        this.f9476b = "";
        this.f9477c = 0L;
        this.f9478d = 0;
        this.f9479e = null;
        this.f9480f = null;
        this.f9481g = (byte) 0;
        this.f9482h = 0;
        this.f9483i = 0L;
        this.f9484j = null;
        this.f9485k = "";
        this.f9486l = null;
        this.f9487m = "";
        this.n = 0;
        this.o = 0L;
        this.p = 0;
    }

    public long a() {
        return this.f9477c;
    }

    public u b() {
        return this.f9480f;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (u) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        y yVar = (y) obj;
        return n.a(this.f9475a, yVar.f9475a) && n.a(this.f9476b, yVar.f9476b) && n.a(this.f9477c, yVar.f9477c) && n.a(this.f9478d, yVar.f9478d) && n.a(this.f9479e, yVar.f9479e) && n.a(this.f9480f, yVar.f9480f) && n.a(this.f9481g, yVar.f9481g) && n.a(this.f9482h, yVar.f9482h) && n.a(this.f9483i, yVar.f9483i) && n.a(this.f9484j, yVar.f9484j) && n.a(this.f9485k, yVar.f9485k) && n.a(this.f9486l, yVar.f9486l) && n.a(this.f9487m, yVar.f9487m) && n.a(this.n, yVar.n) && n.a(this.o, yVar.o) && n.a(this.p, yVar.p);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9475a, 0);
        lVar.a(this.f9476b, 1);
        lVar.a(this.f9477c, 2);
        lVar.a(this.f9478d, 3);
        lVar.a((m) this.f9479e, 4);
        lVar.a((m) this.f9480f, 5);
        lVar.b(this.f9481g, 6);
        lVar.a(this.f9482h, 7);
        lVar.a(this.f9483i, 8);
        u uVar = this.f9484j;
        if (uVar != null) {
            lVar.a((m) uVar, 9);
        }
        String str = this.f9485k;
        if (str != null) {
            lVar.a(str, 10);
        }
        Map<String, String> map = this.f9486l;
        if (map != null) {
            lVar.a((Map) map, 11);
        }
        String str2 = this.f9487m;
        if (str2 != null) {
            lVar.a(str2, 12);
        }
        lVar.a(this.n, 13);
        lVar.a(this.o, 14);
        lVar.a(this.p, 15);
    }

    public y(String str, String str2, long j2, int i2, v vVar, u uVar, byte b2, int i3, long j3, u uVar2, String str3, Map<String, String> map, String str4, int i4, long j4, int i5) {
        this.f9475a = "";
        this.f9476b = "";
        this.f9477c = 0L;
        this.f9478d = 0;
        this.f9479e = null;
        this.f9480f = null;
        this.f9481g = (byte) 0;
        this.f9482h = 0;
        this.f9483i = 0L;
        this.f9484j = null;
        this.f9485k = "";
        this.f9486l = null;
        this.f9487m = "";
        this.n = 0;
        this.o = 0L;
        this.p = 0;
        this.f9475a = str;
        this.f9476b = str2;
        this.f9477c = j2;
        this.f9478d = i2;
        this.f9479e = vVar;
        this.f9480f = uVar;
        this.f9481g = b2;
        this.f9482h = i3;
        this.f9483i = j3;
        this.f9484j = uVar2;
        this.f9485k = str3;
        this.f9486l = map;
        this.f9487m = str4;
        this.n = i4;
        this.o = j4;
        this.p = i5;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9475a = kVar.a(0, true);
        this.f9476b = kVar.a(1, true);
        this.f9477c = kVar.a(this.f9477c, 2, true);
        this.f9478d = kVar.a(this.f9478d, 3, true);
        if (q == null) {
            q = new v();
        }
        this.f9479e = (v) kVar.a((m) q, 4, true);
        if (r == null) {
            r = new u();
        }
        this.f9480f = (u) kVar.a((m) r, 5, true);
        this.f9481g = kVar.a(this.f9481g, 6, true);
        this.f9482h = kVar.a(this.f9482h, 7, false);
        this.f9483i = kVar.a(this.f9483i, 8, false);
        if (s == null) {
            s = new u();
        }
        this.f9484j = (u) kVar.a((m) s, 9, false);
        this.f9485k = kVar.a(10, false);
        if (t == null) {
            t = new HashMap();
            t.put("", "");
        }
        this.f9486l = (Map) kVar.a((k) t, 11, false);
        this.f9487m = kVar.a(12, false);
        this.n = kVar.a(this.n, 13, false);
        this.o = kVar.a(this.o, 14, false);
        this.p = kVar.a(this.p, 15, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.f9475a, "title");
        iVar.a(this.f9476b, "newFeature");
        iVar.a(this.f9477c, "publishTime");
        iVar.a(this.f9478d, "publishType");
        iVar.a((m) this.f9479e, "appBasicInfo");
        iVar.a((m) this.f9480f, "apkBaseInfo");
        iVar.a(this.f9481g, "updateStrategy");
        iVar.a(this.f9482h, "popTimes");
        iVar.a(this.f9483i, "popInterval");
        iVar.a((m) this.f9484j, "diffApkInfo");
        iVar.a(this.f9485k, "netType");
        iVar.a((Map) this.f9486l, "reserved");
        iVar.a(this.f9487m, "strategyId");
        iVar.a(this.n, NotificationCompat.CATEGORY_STATUS);
        iVar.a(this.o, "updateTime");
        iVar.a(this.p, "updateType");
    }
}

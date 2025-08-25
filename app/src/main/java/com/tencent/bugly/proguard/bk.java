package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bk extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9348a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9349b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9350c = true;

    /* renamed from: d, reason: collision with root package name */
    public String f9351d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f9352e = "";

    /* renamed from: f, reason: collision with root package name */
    public bj f9353f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f9354g = null;

    /* renamed from: h, reason: collision with root package name */
    public long f9355h = 0;

    /* renamed from: i, reason: collision with root package name */
    public String f9356i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f9357j = "";

    /* renamed from: k, reason: collision with root package name */
    public int f9358k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f9359l = 0;
    static final /* synthetic */ boolean o = !bk.class.desiredAssertionStatus();

    /* renamed from: m, reason: collision with root package name */
    static bj f9347m = new bj();
    static Map<String, String> n = new HashMap();

    static {
        n.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9348a, 0);
        lVar.a(this.f9349b, 1);
        lVar.a(this.f9350c, 2);
        String str = this.f9351d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f9352e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        bj bjVar = this.f9353f;
        if (bjVar != null) {
            lVar.a((m) bjVar, 5);
        }
        Map<String, String> map = this.f9354g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f9355h, 7);
        String str3 = this.f9356i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f9357j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f9358k, 10);
        lVar.a(this.f9359l, 11);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bk bkVar = (bk) obj;
        return n.a(this.f9348a, bkVar.f9348a) && n.a(this.f9349b, bkVar.f9349b) && n.a(this.f9350c, bkVar.f9350c) && n.a(this.f9351d, bkVar.f9351d) && n.a(this.f9352e, bkVar.f9352e) && n.a(this.f9353f, bkVar.f9353f) && n.a(this.f9354g, bkVar.f9354g) && n.a(this.f9355h, bkVar.f9355h) && n.a(this.f9356i, bkVar.f9356i) && n.a(this.f9357j, bkVar.f9357j) && n.a(this.f9358k, bkVar.f9358k) && n.a(this.f9359l, bkVar.f9359l);
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
    public void a(k kVar) {
        this.f9348a = kVar.a(this.f9348a, 0, true);
        this.f9349b = kVar.a(this.f9349b, 1, true);
        this.f9350c = kVar.a(this.f9350c, 2, true);
        this.f9351d = kVar.a(3, false);
        this.f9352e = kVar.a(4, false);
        this.f9353f = (bj) kVar.a((m) f9347m, 5, false);
        this.f9354g = (Map) kVar.a((k) n, 6, false);
        this.f9355h = kVar.a(this.f9355h, 7, false);
        this.f9356i = kVar.a(8, false);
        this.f9357j = kVar.a(9, false);
        this.f9358k = kVar.a(this.f9358k, 10, false);
        this.f9359l = kVar.a(this.f9359l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.f9348a, "enable");
        iVar.a(this.f9349b, "enableUserInfo");
        iVar.a(this.f9350c, "enableQuery");
        iVar.a(this.f9351d, "url");
        iVar.a(this.f9352e, "expUrl");
        iVar.a((m) this.f9353f, "security");
        iVar.a((Map) this.f9354g, "valueMap");
        iVar.a(this.f9355h, "strategylastUpdateTime");
        iVar.a(this.f9356i, "httpsUrl");
        iVar.a(this.f9357j, "httpsExpUrl");
        iVar.a(this.f9358k, "eventRecordCount");
        iVar.a(this.f9359l, "eventTimeInterval");
    }
}

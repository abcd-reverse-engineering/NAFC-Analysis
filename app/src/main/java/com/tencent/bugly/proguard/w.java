package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class w extends m implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    static v f9461i;

    /* renamed from: j, reason: collision with root package name */
    static Map<String, String> f9462j;

    /* renamed from: k, reason: collision with root package name */
    static final /* synthetic */ boolean f9463k = !w.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public String f9464a;

    /* renamed from: b, reason: collision with root package name */
    public long f9465b;

    /* renamed from: c, reason: collision with root package name */
    public byte f9466c;

    /* renamed from: d, reason: collision with root package name */
    public long f9467d;

    /* renamed from: e, reason: collision with root package name */
    public v f9468e;

    /* renamed from: f, reason: collision with root package name */
    public String f9469f;

    /* renamed from: g, reason: collision with root package name */
    public int f9470g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f9471h;

    public w() {
        this.f9464a = "";
        this.f9465b = 0L;
        this.f9466c = (byte) 0;
        this.f9467d = 0L;
        this.f9468e = null;
        this.f9469f = "";
        this.f9470g = 0;
        this.f9471h = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9464a, 0);
        lVar.a(this.f9465b, 1);
        lVar.b(this.f9466c, 2);
        lVar.a(this.f9467d, 3);
        v vVar = this.f9468e;
        if (vVar != null) {
            lVar.a((m) vVar, 4);
        }
        String str = this.f9469f;
        if (str != null) {
            lVar.a(str, 5);
        }
        lVar.a(this.f9470g, 6);
        Map<String, String> map = this.f9471h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9463k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        w wVar = (w) obj;
        return n.a(this.f9464a, wVar.f9464a) && n.a(this.f9465b, wVar.f9465b) && n.a(this.f9466c, wVar.f9466c) && n.a(this.f9467d, wVar.f9467d) && n.a(this.f9468e, wVar.f9468e) && n.a(this.f9469f, wVar.f9469f) && n.a(this.f9470g, wVar.f9470g) && n.a(this.f9471h, wVar.f9471h);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public w(String str, long j2, byte b2, long j3, v vVar, String str2, int i2, Map<String, String> map) {
        this.f9464a = "";
        this.f9465b = 0L;
        this.f9466c = (byte) 0;
        this.f9467d = 0L;
        this.f9468e = null;
        this.f9469f = "";
        this.f9470g = 0;
        this.f9471h = null;
        this.f9464a = str;
        this.f9465b = j2;
        this.f9466c = b2;
        this.f9467d = j3;
        this.f9468e = vVar;
        this.f9469f = str2;
        this.f9470g = i2;
        this.f9471h = map;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9464a = kVar.a(0, true);
        this.f9465b = kVar.a(this.f9465b, 1, true);
        this.f9466c = kVar.a(this.f9466c, 2, true);
        this.f9467d = kVar.a(this.f9467d, 3, false);
        if (f9461i == null) {
            f9461i = new v();
        }
        this.f9468e = (v) kVar.a((m) f9461i, 4, false);
        this.f9469f = kVar.a(5, false);
        this.f9470g = kVar.a(this.f9470g, 6, false);
        if (f9462j == null) {
            f9462j = new HashMap();
            f9462j.put("", "");
        }
        this.f9471h = (Map) kVar.a((k) f9462j, 7, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.f9464a, "eventType");
        iVar.a(this.f9465b, "eventTime");
        iVar.a(this.f9466c, "eventResult");
        iVar.a(this.f9467d, "eventElapse");
        iVar.a((m) this.f9468e, "destAppInfo");
        iVar.a(this.f9469f, "strategyId");
        iVar.a(this.f9470g, "updateType");
        iVar.a((Map) this.f9471h, "reserved");
    }
}

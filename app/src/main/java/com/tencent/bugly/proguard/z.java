package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class z extends m implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    static Map<String, String> f9488e;

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f9489f = !z.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public int f9490a;

    /* renamed from: b, reason: collision with root package name */
    public String f9491b;

    /* renamed from: c, reason: collision with root package name */
    public long f9492c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f9493d;

    public z() {
        this.f9490a = 0;
        this.f9491b = "";
        this.f9492c = 0L;
        this.f9493d = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9490a, 0);
        String str = this.f9491b;
        if (str != null) {
            lVar.a(str, 1);
        }
        lVar.a(this.f9492c, 2);
        Map<String, String> map = this.f9493d;
        if (map != null) {
            lVar.a((Map) map, 3);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9489f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        z zVar = (z) obj;
        return n.a(this.f9490a, zVar.f9490a) && n.a(this.f9491b, zVar.f9491b) && n.a(this.f9492c, zVar.f9492c) && n.a(this.f9493d, zVar.f9493d);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public z(int i2, String str, long j2, Map<String, String> map) {
        this.f9490a = 0;
        this.f9491b = "";
        this.f9492c = 0L;
        this.f9493d = null;
        this.f9490a = i2;
        this.f9491b = str;
        this.f9492c = j2;
        this.f9493d = map;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9490a = kVar.a(this.f9490a, 0, false);
        this.f9491b = kVar.a(1, false);
        this.f9492c = kVar.a(this.f9492c, 2, false);
        if (f9488e == null) {
            f9488e = new HashMap();
            f9488e.put("", "");
        }
        this.f9493d = (Map) kVar.a((k) f9488e, 3, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.f9490a, AgooConstants.MESSAGE_FLAG);
        iVar.a(this.f9491b, "localStrategyId");
        iVar.a(this.f9492c, "localStrategyTime");
        iVar.a((Map) this.f9493d, "reserved");
    }
}

package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bm extends m implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    static ArrayList<bl> f9369f;

    /* renamed from: g, reason: collision with root package name */
    static Map<String, String> f9370g;

    /* renamed from: a, reason: collision with root package name */
    public byte f9371a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f9372b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f9373c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<bl> f9374d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f9375e = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.b(this.f9371a, 0);
        String str = this.f9372b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f9373c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bl> arrayList = this.f9374d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f9375e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9371a = kVar.a(this.f9371a, 0, true);
        this.f9372b = kVar.a(1, false);
        this.f9373c = kVar.a(2, false);
        if (f9369f == null) {
            f9369f = new ArrayList<>();
            f9369f.add(new bl());
        }
        this.f9374d = (ArrayList) kVar.a((k) f9369f, 3, false);
        if (f9370g == null) {
            f9370g = new HashMap();
            f9370g.put("", "");
        }
        this.f9375e = (Map) kVar.a((k) f9370g, 4, false);
    }
}

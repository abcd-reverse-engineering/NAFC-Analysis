package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bd extends m implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<String> f9300c;

    /* renamed from: a, reason: collision with root package name */
    public String f9301a = "";

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f9302b = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9301a, 0);
        ArrayList<String> arrayList = this.f9302b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9301a = kVar.a(0, true);
        if (f9300c == null) {
            f9300c = new ArrayList<>();
            f9300c.add("");
        }
        this.f9302b = (ArrayList) kVar.a((k) f9300c, 1, false);
    }
}

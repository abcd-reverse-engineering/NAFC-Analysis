package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bg extends m implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    static ArrayList<bf> f9320b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<bf> f9321a = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a((Collection) this.f9321a, 0);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        if (f9320b == null) {
            f9320b = new ArrayList<>();
            f9320b.add(new bf());
        }
        this.f9321a = (ArrayList) kVar.a((k) f9320b, 0, true);
    }
}

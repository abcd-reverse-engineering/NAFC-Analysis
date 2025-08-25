package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class bj extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f9345a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f9346b = "";

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9345a, 0);
        lVar.a(this.f9346b, 1);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9345a = kVar.a(0, true);
        this.f9346b = kVar.a(1, true);
    }
}

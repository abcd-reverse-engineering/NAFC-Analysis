package com.umeng.analytics.pro;

/* compiled from: DelayedStartCondition.java */
/* loaded from: classes2.dex */
public class ac implements aa {

    /* renamed from: a, reason: collision with root package name */
    private long f10021a;

    public ac(long j2) {
        this.f10021a = 0L;
        this.f10021a = j2;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return this.f10021a;
    }
}

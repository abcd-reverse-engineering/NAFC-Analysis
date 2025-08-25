package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6268a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6269b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f6270c;

    public f(l lVar, HonorPushCallback honorPushCallback, boolean z) {
        this.f6270c = lVar;
        this.f6268a = honorPushCallback;
        this.f6269b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f6270c.f6303d;
        sVar.a(new m(sVar, this.f6269b), this.f6268a);
    }
}

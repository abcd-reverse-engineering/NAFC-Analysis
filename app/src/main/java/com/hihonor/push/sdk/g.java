package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6281a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f6282b;

    public g(l lVar, HonorPushCallback honorPushCallback) {
        this.f6282b = lVar;
        this.f6281a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f6282b.f6303d;
        sVar.a(new n(sVar), this.f6281a);
    }
}

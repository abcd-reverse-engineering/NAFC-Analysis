package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6291a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f6292b;

    public i(l lVar, HonorPushCallback honorPushCallback) {
        this.f6292b = lVar;
        this.f6291a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f6292b.f6303d;
        sVar.a(new p(sVar), this.f6291a);
    }
}

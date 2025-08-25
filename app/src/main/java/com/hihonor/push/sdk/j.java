package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6295a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f6296b;

    public j(l lVar, HonorPushCallback honorPushCallback) {
        this.f6296b = lVar;
        this.f6295a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f6296b.f6303d;
        sVar.a(new q(sVar), this.f6295a);
    }
}

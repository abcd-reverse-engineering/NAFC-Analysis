package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6286a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f6287b;

    public h(l lVar, HonorPushCallback honorPushCallback) {
        this.f6287b = lVar;
        this.f6286a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f6287b.f6303d;
        sVar.a(new o(sVar), this.f6286a);
    }
}

package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6297a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f6298b;

    public k(l lVar, HonorPushCallback honorPushCallback) {
        this.f6298b = lVar;
        this.f6297a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f6298b.f6303d;
        HonorPushCallback honorPushCallback = this.f6297a;
        sVar.getClass();
        if (honorPushCallback == null) {
            return;
        }
        a1 a1VarA = b.a(new p0(sVar.f6324a));
        C0340r c0340r = new C0340r(sVar, honorPushCallback);
        a1VarA.getClass();
        a1VarA.a(new t0(o0.f6312c.f6313a, c0340r));
    }
}

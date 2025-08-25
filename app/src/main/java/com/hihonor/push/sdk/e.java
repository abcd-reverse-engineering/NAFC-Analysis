package com.hihonor.push.sdk;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f6265a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f6266b;

    public e(l lVar, v vVar) {
        this.f6266b = lVar;
        this.f6265a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6266b.f6301b) {
            return;
        }
        this.f6266b.f6301b = true;
        this.f6266b.getClass();
        this.f6266b.f6300a = new WeakReference<>(this.f6265a.f6341a);
        this.f6266b.f6302c = this.f6265a.f6342b;
        this.f6266b.f6303d = new s(this.f6265a.f6341a);
        if (this.f6266b.f6302c) {
            l lVar = this.f6266b;
            lVar.a(new f(lVar, null, true), (HonorPushCallback<?>) null);
        }
    }
}

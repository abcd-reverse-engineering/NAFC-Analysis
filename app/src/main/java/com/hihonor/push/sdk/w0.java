package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class w0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f6348a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f6349b;

    public w0(x0 x0Var, a1 a1Var) {
        this.f6349b = x0Var;
        this.f6348a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f6349b.f6353c) {
            Object obj = this.f6349b.f6352b;
            if (obj != null) {
                this.f6348a.c();
                ((y0) obj).f6356a.countDown();
            }
        }
    }
}

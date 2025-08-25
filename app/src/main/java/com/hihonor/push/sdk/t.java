package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6331a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6332b;

    public t(s sVar, HonorPushCallback honorPushCallback, Object obj) {
        this.f6331a = honorPushCallback;
        this.f6332b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f6331a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.f6332b);
        }
    }
}

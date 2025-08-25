package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6336a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6337b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6338c;

    public u(s sVar, HonorPushCallback honorPushCallback, int i2, String str) {
        this.f6336a = honorPushCallback;
        this.f6337b = i2;
        this.f6338c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f6336a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.f6337b, this.f6338c);
        }
    }
}

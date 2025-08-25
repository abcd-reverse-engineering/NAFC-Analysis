package com.hihonor.push.sdk;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* loaded from: classes.dex */
public class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z.a f6355b;

    public y(z.a aVar, int i2) {
        this.f6355b = aVar;
        this.f6354a = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6355b.a(HonorPushErrorEnum.fromCode(this.f6354a));
    }
}

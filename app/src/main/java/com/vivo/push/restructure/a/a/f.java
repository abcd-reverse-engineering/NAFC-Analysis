package com.vivo.push.restructure.a.a;

import com.vivo.push.PushClient;

/* compiled from: DispatchNode.java */
/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f12152a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12153b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f12154c;

    f(e eVar, int i2, String str) {
        this.f12154c = eVar;
        this.f12152a = i2;
        this.f12153b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f12152a;
        if (i2 == 3) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.f12153b, null);
        } else if (i2 == 4) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.f12153b, null);
        }
    }
}

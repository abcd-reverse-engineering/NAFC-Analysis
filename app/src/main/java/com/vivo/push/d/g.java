package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f12012a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f12013b;

    g(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f12013b = dVar;
        this.f12012a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete all profileIds");
        d.a(this.f12013b, "", this.f12012a, 3);
    }
}

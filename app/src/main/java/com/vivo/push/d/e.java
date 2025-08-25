package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: classes2.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f12006a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f12007b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f12008c;

    e(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f12008c = dVar;
        this.f12006a = str;
        this.f12007b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("add profileId");
        d.a(this.f12008c, this.f12006a, this.f12007b, 1);
    }
}

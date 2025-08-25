package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f12009a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f12010b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f12011c;

    f(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f12011c = dVar;
        this.f12009a = str;
        this.f12010b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete profileId");
        d.a(this.f12011c, this.f12009a, this.f12010b, 2);
    }
}

package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: classes2.dex */
final class j implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f12017a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f12018b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f12019c;

    j(d dVar, IPushRequestCallback iPushRequestCallback, int i2) {
        this.f12019c = dVar;
        this.f12017a = iPushRequestCallback;
        this.f12018b = i2;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i2) {
        if (this.f12017a != null) {
            u.b(this.f12018b + " sync err : " + i2);
            this.f12017a.onError(i2);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        if (this.f12017a != null) {
            u.b(this.f12018b + " sync success");
            this.f12017a.onSuccess(0);
        }
    }
}

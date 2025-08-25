package com.vivo.push.f;

/* compiled from: OnPublishReceiveTask.java */
/* loaded from: classes2.dex */
final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.r f12074a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ y f12075b;

    z(y yVar, com.vivo.push.b.r rVar) {
        this.f12075b = yVar;
        this.f12074a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y yVar = this.f12075b;
        ((aa) yVar).f12034b.onPublish(((com.vivo.push.s) yVar).f12207a, this.f12074a.i(), this.f12074a.h());
    }
}

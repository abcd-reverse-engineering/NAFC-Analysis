package com.vivo.push.f;

/* compiled from: OnListTagReceiveTask.java */
/* loaded from: classes2.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.m f12066a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f12067b;

    q(p pVar, com.vivo.push.b.m mVar) {
        this.f12067b = pVar;
        this.f12066a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.f12067b;
        ((aa) pVar).f12034b.onListTags(((com.vivo.push.s) pVar).f12207a, this.f12066a.i(), this.f12066a.d(), this.f12066a.h());
    }
}

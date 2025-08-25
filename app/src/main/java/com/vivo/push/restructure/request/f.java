package com.vivo.push.restructure.request;

/* compiled from: RequestManager.java */
/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f12205a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f12206b;

    f(e eVar, b bVar) {
        this.f12206b = eVar;
        this.f12205a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f12205a;
        if (bVar == null || bVar.b() == null) {
            return;
        }
        this.f12205a.b().a(1003);
    }
}

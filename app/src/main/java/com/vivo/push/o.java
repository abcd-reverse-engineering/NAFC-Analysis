package com.vivo.push;

/* compiled from: PushClientManager.java */
/* loaded from: classes2.dex */
final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f12124a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12125b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f12126c;

    o(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f12126c = mVar;
        this.f12124a = bVar;
        this.f12125b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12126c.a(this.f12124a);
        this.f12126c.c(this.f12125b);
    }
}

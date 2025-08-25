package com.vivo.push;

/* compiled from: PushClientManager.java */
/* loaded from: classes2.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f12128a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12129b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f12130c;

    q(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f12130c = mVar;
        this.f12128a = bVar;
        this.f12129b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12130c.a(this.f12128a);
        this.f12130c.c(this.f12129b);
    }
}

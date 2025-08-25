package com.vivo.push.util;

import java.util.List;

/* compiled from: ImageDownTask.java */
/* loaded from: classes2.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f12296a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f12297b;

    q(p pVar, List list) {
        this.f12297b = pVar;
        this.f12296a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f12297b.f12290b != null) {
            ad.b().a("com.vivo.push.notify_key", this.f12297b.f12291c);
            NotifyAdapterUtil.pushNotification(this.f12297b.f12289a, this.f12296a, this.f12297b.f12290b, this.f12297b.f12291c, this.f12297b.f12293e, this.f12297b.f12294f, this.f12297b.f12295g);
        }
    }
}

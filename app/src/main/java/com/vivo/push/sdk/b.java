package com.vivo.push.sdk;

import com.vivo.push.ab;
import com.vivo.push.m;
import com.vivo.push.util.u;

/* compiled from: CommandWorker.java */
/* loaded from: classes2.dex */
final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.restructure.a.a f12217a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f12218b;

    b(a aVar, com.vivo.push.restructure.a.a aVar2) {
        this.f12218b = aVar;
        this.f12217a = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.f12217a.j())));
        m.a().a(((ab) this.f12218b).f11925a);
        com.vivo.push.restructure.a.a().d().a(this.f12217a);
    }
}

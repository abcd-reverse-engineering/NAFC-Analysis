package com.vivo.push.restructure.a.a;

import android.os.SystemClock;

/* compiled from: IPCNode.java */
/* loaded from: classes2.dex */
final class g extends a<com.vivo.push.restructure.a.a> {

    /* renamed from: b, reason: collision with root package name */
    private long f12155b;

    public g(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("IPCNode", aVar, iVar);
        this.f12155b = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jD = aVar.d();
        if (jD <= 0 || jElapsedRealtime <= jD) {
            return;
        }
        this.f12155b = jElapsedRealtime - jD;
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return 0;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final synchronized String b() {
        a(this.f12155b);
        return super.b();
    }
}

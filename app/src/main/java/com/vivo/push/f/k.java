package com.vivo.push.f;

/* compiled from: OnClearCacheReceiveTask.java */
/* loaded from: classes2.dex */
final class k extends aa {
    k(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.u.d("OnClearCacheTask", "delete push info " + this.f12207a.getPackageName());
        com.vivo.push.util.af.b(this.f12207a).a();
    }
}

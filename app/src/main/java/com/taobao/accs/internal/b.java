package com.taobao.accs.internal;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.taobao.accs.c f8492a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f8493b;

    b(ACCSManagerImpl aCCSManagerImpl, com.taobao.accs.c cVar) {
        this.f8493b = aCCSManagerImpl;
        this.f8492a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.taobao.accs.c cVar = this.f8492a;
        if (cVar != null) {
            cVar.a(true, false);
        }
    }
}

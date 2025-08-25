package com.taobao.accs.net;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f8566a;

    x(v vVar) {
        this.f8566a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8566a.o();
        if (this.f8566a.I != null) {
            this.f8566a.I.setCloseReason("shut down");
        }
        synchronized (this.f8566a.u) {
            try {
                this.f8566a.u.notifyAll();
            } catch (Exception unused) {
            }
        }
    }
}

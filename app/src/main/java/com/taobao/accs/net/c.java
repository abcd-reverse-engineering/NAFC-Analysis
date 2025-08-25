package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8516a;

    c(a aVar) {
        this.f8516a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f8516a.f8504e.c()) {
            ALog.e(this.f8516a.d(), "receive ping time out! ", new Object[0]);
            g.a(this.f8516a.f8503d).c();
            this.f8516a.a("", false, "receive ping timeout");
            this.f8516a.f8504e.a(-12);
        }
    }
}

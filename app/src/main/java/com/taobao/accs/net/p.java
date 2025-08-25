package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8544a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f8545b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ k f8546c;

    p(k kVar, String str, boolean z) {
        this.f8546c = kVar;
        this.f8544a = str;
        this.f8545b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageA = this.f8546c.f8504e.a(this.f8544a);
        if (messageA != null) {
            this.f8546c.f8504e.a(messageA, -9);
            this.f8546c.a(this.f8544a, this.f8545b, "receive data time out");
            ALog.e(this.f8546c.d(), this.f8544a + "-> receive data time out!", new Object[0]);
        }
    }
}

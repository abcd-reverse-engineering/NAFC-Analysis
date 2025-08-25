package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8513a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f8514b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f8515c;

    b(a aVar, String str, boolean z) {
        this.f8515c = aVar;
        this.f8513a = str;
        this.f8514b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageA = this.f8515c.f8504e.a(this.f8513a);
        if (messageA != null) {
            this.f8515c.f8504e.a(messageA, -9);
            this.f8515c.a(this.f8513a, this.f8514b, "receive data time out");
            ALog.e(this.f8515c.d(), this.f8513a + "-> receive data time out!", new Object[0]);
        }
    }
}

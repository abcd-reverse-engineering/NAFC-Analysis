package com.taobao.accs.net;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f8547a;

    q(k kVar) {
        this.f8547a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f8547a.f8506g) {
            try {
                Session session = SessionCenter.getInstance(this.f8547a.f8508i.getAppKey()).get(this.f8547a.b((String) null), ConnType.TypeLevel.SPDY, 0L);
                if (session != null) {
                    ALog.e(this.f8547a.d(), "try session ping", new Object[0]);
                    int pingTimeout = this.f8547a.f8508i.getPingTimeout();
                    if (pingTimeout > 0) {
                        session.ping(true, pingTimeout);
                    } else {
                        session.ping(true);
                    }
                }
            } catch (Exception e2) {
                ALog.e(this.f8547a.d(), "ping error", e2, new Object[0]);
            }
        }
    }
}

package anet.channel.session;

import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.statist.SessionStatistic;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class i implements IAuth.AuthCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f1897a;

    i(TnetSpdySession tnetSpdySession) {
        this.f1897a = tnetSpdySession;
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthFail(int i2, String str) {
        this.f1897a.notifyStatus(5, null);
        SessionStatistic sessionStatistic = this.f1897a.q;
        if (sessionStatistic != null) {
            sessionStatistic.closeReason = "Accs_Auth_Fail:" + i2;
            this.f1897a.q.errorCode = (long) i2;
        }
        this.f1897a.close();
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthSuccess() {
        this.f1897a.notifyStatus(4, null);
        this.f1897a.z = System.currentTimeMillis();
        TnetSpdySession tnetSpdySession = this.f1897a;
        IHeartbeat iHeartbeat = tnetSpdySession.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(tnetSpdySession);
        }
        TnetSpdySession tnetSpdySession2 = this.f1897a;
        SessionStatistic sessionStatistic = tnetSpdySession2.q;
        sessionStatistic.ret = 1;
        ALog.d("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession2.p, "authTime", Long.valueOf(sessionStatistic.authTime));
        TnetSpdySession tnetSpdySession3 = this.f1897a;
        if (tnetSpdySession3.A > 0) {
            tnetSpdySession3.q.authTime = System.currentTimeMillis() - this.f1897a.A;
        }
    }
}

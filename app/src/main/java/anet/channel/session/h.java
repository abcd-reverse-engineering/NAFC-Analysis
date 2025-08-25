package anet.channel.session;

import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f1896a;

    h(TnetSpdySession tnetSpdySession) {
        this.f1896a = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1896a.y) {
            TnetSpdySession tnetSpdySession = this.f1896a;
            ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.p, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.y));
            try {
                this.f1896a.handleCallbacks(2048, null);
                if (this.f1896a.q != null) {
                    this.f1896a.q.closeReason = "ping time out";
                }
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = false;
                connEvent.isAccs = this.f1896a.I;
                StrategyCenter.getInstance().notifyConnEvent(this.f1896a.f1624d, this.f1896a.f1631k, connEvent);
                this.f1896a.close(true);
            } catch (Exception unused) {
            }
        }
    }
}

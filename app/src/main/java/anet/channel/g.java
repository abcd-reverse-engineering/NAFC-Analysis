package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class g implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Session f1785a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest f1786b;

    g(SessionRequest sessionRequest, Session session) {
        this.f1786b = sessionRequest;
        this.f1785a = session;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i2));
        ConnEvent connEvent = new ConnEvent();
        if (i2 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.f1786b.f1649c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.f1785a.getRealHost(), this.f1785a.getConnStrategy(), connEvent);
    }
}

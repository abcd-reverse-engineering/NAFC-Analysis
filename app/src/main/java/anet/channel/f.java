package anet.channel;

import anet.channel.SessionRequest;
import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class f implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SessionRequest.IConnCb f1772a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1773b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f1774c;

    f(SessionRequest sessionRequest, SessionRequest.IConnCb iConnCb, long j2) {
        this.f1774c = sessionRequest;
        this.f1772a = iConnCb;
        this.f1773b = j2;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        if (session == null) {
            return;
        }
        int i3 = bVar == null ? 0 : bVar.f1767b;
        String str = bVar == null ? "" : bVar.f1768c;
        if (i2 == 2) {
            ALog.d("awcn.SessionRequest", null, session != null ? session.p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f1774c.a(session, i3, str);
            SessionRequest sessionRequest = this.f1774c;
            if (sessionRequest.f1648b.c(sessionRequest, session)) {
                this.f1772a.onDisConnect(session, this.f1773b, i2);
                return;
            } else {
                this.f1772a.onFailed(session, this.f1773b, i2, i3);
                return;
            }
        }
        if (i2 == 256) {
            ALog.d("awcn.SessionRequest", null, session != null ? session.p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f1772a.onFailed(session, this.f1773b, i2, i3);
        } else {
            if (i2 != 512) {
                return;
            }
            ALog.d("awcn.SessionRequest", null, session != null ? session.p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f1774c.a(session, 0, (String) null);
            this.f1772a.onSuccess(session, this.f1773b);
        }
    }
}

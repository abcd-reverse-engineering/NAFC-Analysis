package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1680a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ anet.channel.entity.b f1681b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Session f1682c;

    b(Session session, int i2, anet.channel.entity.b bVar) {
        this.f1682c = session;
        this.f1680a = i2;
        this.f1681b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f1682c.f1622b != null) {
                for (EventCb eventCb : this.f1682c.f1622b.keySet()) {
                    if (eventCb != null && (this.f1682c.f1622b.get(eventCb).intValue() & this.f1680a) != 0) {
                        try {
                            eventCb.onEvent(this.f1682c, this.f1680a, this.f1681b);
                        } catch (Exception e2) {
                            ALog.e("awcn.Session", e2.toString(), this.f1682c.p, new Object[0]);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            ALog.e("awcn.Session", "handleCallbacks", this.f1682c.p, e3, new Object[0]);
        }
    }
}

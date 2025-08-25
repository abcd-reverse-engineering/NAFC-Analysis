package a.a.t;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.HttpUrl;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SessionCenter f1214a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HttpUrl f1215b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1216c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ HttpUrl f1217d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f1218e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ g f1219f;

    i(g gVar, SessionCenter sessionCenter, HttpUrl httpUrl, RequestStatistic requestStatistic, HttpUrl httpUrl2, boolean z) {
        this.f1219f = gVar;
        this.f1214a = sessionCenter;
        this.f1215b = httpUrl;
        this.f1216c = requestStatistic;
        this.f1217d = httpUrl2;
        this.f1218e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Session session = this.f1214a.get(this.f1215b, anet.channel.entity.c.f1769a, 3000L);
        this.f1216c.connWaitTime = System.currentTimeMillis() - jCurrentTimeMillis;
        this.f1216c.spdyRequestSend = session != null;
        Session sessionA = this.f1219f.a(session, this.f1214a, this.f1217d, this.f1218e);
        g gVar = this.f1219f;
        gVar.a(sessionA, gVar.f1197a.f1230a.a());
    }
}

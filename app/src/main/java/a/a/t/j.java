package a.a.t;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionGetCallback;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class j implements SessionGetCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1220a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1221b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Request f1222c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SessionCenter f1223d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ HttpUrl f1224e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f1225f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ g f1226g;

    j(g gVar, RequestStatistic requestStatistic, long j2, Request request, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        this.f1226g = gVar;
        this.f1220a = requestStatistic;
        this.f1221b = j2;
        this.f1222c = request;
        this.f1223d = sessionCenter;
        this.f1224e = httpUrl;
        this.f1225f = z;
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetFail() {
        ALog.e(g.n, "onSessionGetFail", this.f1226g.f1197a.f1232c, "url", this.f1220a.url);
        this.f1220a.connWaitTime = System.currentTimeMillis() - this.f1221b;
        g gVar = this.f1226g;
        gVar.a(gVar.a(null, this.f1223d, this.f1224e, this.f1225f), this.f1222c);
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetSuccess(Session session) {
        ALog.i(g.n, "onSessionGetSuccess", this.f1226g.f1197a.f1232c, "Session", session);
        this.f1220a.connWaitTime = System.currentTimeMillis() - this.f1221b;
        this.f1220a.spdyRequestSend = true;
        this.f1226g.a(session, this.f1222c);
    }
}

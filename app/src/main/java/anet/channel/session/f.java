package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f1891a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestCb f1892b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1893c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f1894d;

    f(d dVar, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f1894d = dVar;
        this.f1891a = request;
        this.f1892b = requestCb;
        this.f1893c = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1891a.f1841a.sendBeforeTime = System.currentTimeMillis() - this.f1891a.f1841a.reqStart;
        b.a(this.f1891a, new g(this));
    }
}

package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class h implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HorseRaceStat f1722a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1723b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f1724c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ l.e f1725d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f1726e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ d f1727f;

    h(d dVar, HorseRaceStat horseRaceStat, long j2, String str, l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f1727f = dVar;
        this.f1722a = horseRaceStat;
        this.f1723b = j2;
        this.f1724c = str;
        this.f1725d = eVar;
        this.f1726e = tnetSpdySession;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        if (this.f1722a.connTime != 0) {
            return;
        }
        this.f1722a.connTime = System.currentTimeMillis() - this.f1723b;
        if (i2 != 1) {
            HorseRaceStat horseRaceStat = this.f1722a;
            horseRaceStat.connErrorCode = bVar.f1767b;
            synchronized (horseRaceStat) {
                this.f1722a.notify();
            }
            return;
        }
        ALog.i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f1724c, new Object[0]);
        this.f1722a.connRet = 1;
        HttpUrl httpUrl = HttpUrl.parse(session.getHost() + this.f1725d.f2021c);
        if (httpUrl == null) {
            return;
        }
        this.f1726e.request(new Request.Builder().setUrl(httpUrl).setReadTimeout(this.f1725d.f2020b.f1992d).setRedirectEnable(false).setSeq(this.f1724c).build(), new i(this));
    }
}

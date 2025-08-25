package anetwork.channel.entity;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.detect.n;
import anet.channel.statist.RequestMonitor;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DefaultFinishEvent f2218a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f2219b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f2220c;

    j(g gVar, DefaultFinishEvent defaultFinishEvent, anetwork.channel.aidl.g gVar2) {
        this.f2220c = gVar;
        this.f2218a = defaultFinishEvent;
        this.f2219b = gVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        DefaultFinishEvent defaultFinishEvent = this.f2218a;
        String strOptString = null;
        if (defaultFinishEvent != null) {
            defaultFinishEvent.a((Object) null);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            RequestStatistic requestStatistic = this.f2218a.f2070e;
            if (requestStatistic != null) {
                requestStatistic.rspCbStart = jCurrentTimeMillis;
                requestStatistic.lastProcessTime = jCurrentTimeMillis - requestStatistic.rspEnd;
                requestStatistic.oneWayTime = requestStatistic.retryCostTime + (jCurrentTimeMillis - requestStatistic.start);
                this.f2218a.e().filledBy(requestStatistic);
            }
            this.f2219b.a(this.f2218a);
            if (requestStatistic != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                requestStatistic.rspCbEnd = jCurrentTimeMillis2;
                requestStatistic.callbackTime = jCurrentTimeMillis2 - jCurrentTimeMillis;
                anet.channel.fulltrace.a.a().commitRequest(requestStatistic.traceId, requestStatistic);
            }
            if (this.f2220c.f2206c != null) {
                this.f2220c.f2206c.a();
            }
            if (requestStatistic != null) {
                ALog.e("anet.Repeater", "[traceId:" + requestStatistic.traceId + "]end, " + requestStatistic.toString(), this.f2220c.f2205b, new Object[0]);
                CopyOnWriteArrayList<String> bucketInfo = GlobalAppRuntimeInfo.getBucketInfo();
                int i2 = 1;
                if (bucketInfo != null) {
                    int size = bucketInfo.size();
                    for (int i3 = 0; i3 < size - 1; i3 += 2) {
                        requestStatistic.putExtra(bucketInfo.get(i3), bucketInfo.get(i3 + 1));
                    }
                }
                if (GlobalAppRuntimeInfo.isAppBackground()) {
                    requestStatistic.putExtra("restrictBg", Integer.valueOf(NetworkStatusHelper.getRestrictBackgroundStatus()));
                }
                anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
                if (sceneInfo != null) {
                    ALog.i("anet.Repeater", sceneInfo.toString(), this.f2220c.f2205b, new Object[0]);
                    requestStatistic.sinceInitTime = requestStatistic.start - sceneInfo.f1780c;
                    requestStatistic.startType = sceneInfo.f1778a;
                    if (sceneInfo.f1778a != 1) {
                        requestStatistic.sinceLastLaunchTime = sceneInfo.f1780c - sceneInfo.f1781d;
                    }
                    requestStatistic.deviceLevel = sceneInfo.f1782e;
                    if (!sceneInfo.f1779b) {
                        i2 = 0;
                    }
                    requestStatistic.isFromExternal = i2;
                    requestStatistic.speedBucket = sceneInfo.f1783f;
                    requestStatistic.abTestBucket = sceneInfo.f1784g;
                }
                requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                requestStatistic.userInfo = this.f2220c.f2208e.a(a.a.u.a.f1252i);
                AppMonitor.getInstance().commitStat(requestStatistic);
                if (a.a.k.b.a(requestStatistic)) {
                    AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                }
                try {
                    String str = requestStatistic.ip;
                    if (requestStatistic.extra != null) {
                        strOptString = requestStatistic.extra.optString("firstIp");
                    }
                    if (anet.channel.strategy.utils.c.b(str) || anet.channel.strategy.utils.c.b(strOptString)) {
                        AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                    }
                } catch (Exception unused) {
                }
                a.a.r.b.a().a(this.f2220c.f2208e.g(), this.f2218a.e());
                n.a(requestStatistic);
            }
        } catch (Throwable unused2) {
        }
    }
}

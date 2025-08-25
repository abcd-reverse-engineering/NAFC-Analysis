package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1715a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExceptionDetector f1716b;

    c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.f1716b = exceptionDetector;
        this.f1715a = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f1715a == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f1715a.ip) && this.f1715a.ret == 0) {
                if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.f1715a.host)) {
                    this.f1716b.f1700b = this.f1715a.ip;
                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.f1715a.host)) {
                    this.f1716b.f1701c = this.f1715a.ip;
                } else if ("gw.alicdn.com".equalsIgnoreCase(this.f1715a.host)) {
                    this.f1716b.f1702d = this.f1715a.ip;
                }
            }
            if (!TextUtils.isEmpty(this.f1715a.url)) {
                this.f1716b.f1703e.add(Pair.create(this.f1715a.url, Integer.valueOf(this.f1715a.statusCode)));
            }
            if (this.f1716b.c()) {
                this.f1716b.b();
            }
        } catch (Throwable th) {
            ALog.e("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
        }
    }
}

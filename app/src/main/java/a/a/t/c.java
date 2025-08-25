package a.a.t;

import a.a.j.a;
import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.aidl.DefaultFinishEvent;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private l f1185a;

    /* renamed from: b, reason: collision with root package name */
    private a.a.j.a f1186b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f1187c = false;

    public c(l lVar, a.a.j.a aVar) {
        this.f1185a = null;
        this.f1186b = null;
        this.f1185a = lVar;
        this.f1186b = aVar;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f1187c = true;
        this.f1185a.f1230a.f2226f.ret = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zEquals;
        a.C0001a c0001a;
        if (this.f1187c) {
            return;
        }
        anetwork.channel.entity.k kVar = this.f1185a.f1230a;
        RequestStatistic requestStatistic = kVar.f2226f;
        if (this.f1186b != null) {
            String strG = kVar.g();
            Request requestA = this.f1185a.f1230a.a();
            String str = requestA.getHeaders().get("Cache-Control");
            boolean zEquals2 = "no-store".equals(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (zEquals2) {
                this.f1186b.remove(strG);
                zEquals = false;
                c0001a = null;
            } else {
                zEquals = "no-cache".equals(str);
                a.C0001a c0001a2 = this.f1186b.get(strG);
                if (ALog.isPrintLog(2)) {
                    String str2 = this.f1185a.f1232c;
                    Object[] objArr = new Object[8];
                    objArr[0] = "hit";
                    objArr[1] = Boolean.valueOf(c0001a2 != null);
                    objArr[2] = "cost";
                    objArr[3] = Long.valueOf(requestStatistic.cacheTime);
                    objArr[4] = "length";
                    objArr[5] = Integer.valueOf(c0001a2 != null ? c0001a2.data.length : 0);
                    objArr[6] = "key";
                    objArr[7] = strG;
                    ALog.i("anet.CacheTask", "read cache", str2, objArr);
                }
                c0001a = c0001a2;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            requestStatistic.cacheTime = jCurrentTimeMillis2 - jCurrentTimeMillis;
            if (c0001a == null || zEquals || !c0001a.isFresh()) {
                if (this.f1187c) {
                    return;
                }
                g gVar = new g(this.f1185a, zEquals2 ? null : this.f1186b, c0001a);
                this.f1185a.f1234e = gVar;
                gVar.run();
                return;
            }
            if (this.f1185a.f1233d.compareAndSet(false, true)) {
                this.f1185a.a();
                requestStatistic.ret = 1;
                requestStatistic.statusCode = 200;
                requestStatistic.msg = HttpConstant.SUCCESS;
                requestStatistic.protocolType = "cache";
                requestStatistic.rspEnd = jCurrentTimeMillis2;
                requestStatistic.processTime = jCurrentTimeMillis2 - requestStatistic.start;
                if (ALog.isPrintLog(2)) {
                    l lVar = this.f1185a;
                    ALog.i("anet.CacheTask", "hit fresh cache", lVar.f1232c, "URL", lVar.f1230a.f().urlString());
                }
                this.f1185a.f1231b.onResponseCode(200, c0001a.responseHeaders);
                a.a.p.a aVar = this.f1185a.f1231b;
                byte[] bArr = c0001a.data;
                aVar.a(1, bArr.length, ByteArray.wrap(bArr));
                this.f1185a.f1231b.a(new DefaultFinishEvent(200, HttpConstant.SUCCESS, requestA));
            }
        }
    }
}

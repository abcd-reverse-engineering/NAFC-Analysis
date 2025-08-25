package a.a.t;

import android.text.TextUtils;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d implements a {

    /* renamed from: c, reason: collision with root package name */
    private l f1190c;

    /* renamed from: f, reason: collision with root package name */
    private Request f1193f;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f1188a = false;

    /* renamed from: b, reason: collision with root package name */
    volatile Cancelable f1189b = null;

    /* renamed from: d, reason: collision with root package name */
    private int f1191d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f1192e = 0;

    public d(l lVar) {
        this.f1190c = lVar;
        this.f1193f = lVar.f1230a.a();
    }

    static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f1192e;
        dVar.f1192e = i2 + 1;
        return i2;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f1188a = true;
        if (this.f1189b != null) {
            this.f1189b.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1188a) {
            return;
        }
        if (this.f1190c.f1230a.i()) {
            String strB = a.a.l.a.b(this.f1190c.f1230a.g());
            if (!TextUtils.isEmpty(strB)) {
                Request.Builder builderNewBuilder = this.f1193f.newBuilder();
                String str = this.f1193f.getHeaders().get("Cookie");
                if (!TextUtils.isEmpty(str)) {
                    strB = StringUtils.concatString(str, "; ", strB);
                }
                builderNewBuilder.addHeader("Cookie", strB);
                this.f1193f = builderNewBuilder.build();
            }
        }
        RequestStatistic requestStatistic = this.f1193f.f1841a;
        requestStatistic.degraded = 2;
        requestStatistic.sendBeforeTime = System.currentTimeMillis() - this.f1193f.f1841a.reqStart;
        anet.channel.session.b.a(this.f1193f, new e(this));
    }
}

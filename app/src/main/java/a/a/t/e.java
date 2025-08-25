package a.a.t;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f1194a;

    e(d dVar) {
        this.f1194a = dVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        if (this.f1194a.f1190c.f1233d.get()) {
            return;
        }
        d.b(this.f1194a);
        if (this.f1194a.f1190c.f1231b != null) {
            this.f1194a.f1190c.f1231b.a(this.f1194a.f1192e, this.f1194a.f1191d, byteArray);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (this.f1194a.f1190c.f1233d.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.DegradeTask", "[onFinish]", this.f1194a.f1190c.f1232c, "code", Integer.valueOf(i2), "msg", str);
        }
        this.f1194a.f1190c.a();
        requestStatistic.isDone.set(true);
        if (this.f1194a.f1190c.f1231b != null) {
            this.f1194a.f1190c.f1231b.a(new DefaultFinishEvent(i2, str, this.f1194a.f1193f));
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (this.f1194a.f1190c.f1233d.get()) {
            return;
        }
        this.f1194a.f1190c.a();
        a.a.l.a.a(this.f1194a.f1190c.f1230a.g(), map);
        this.f1194a.f1191d = HttpHelper.parseContentLength(map);
        if (this.f1194a.f1190c.f1231b != null) {
            this.f1194a.f1190c.f1231b.onResponseCode(i2, map);
        }
    }
}

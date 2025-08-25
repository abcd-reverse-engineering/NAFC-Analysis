package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class g implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f1895a;

    g(f fVar) {
        this.f1895a = fVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        this.f1895a.f1892b.onDataReceive(byteArray, z);
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 <= 0 && i2 != -204) {
            this.f1895a.f1894d.handleCallbacks(2, new anet.channel.entity.b(2, 0, "Http connect fail"));
        }
        this.f1895a.f1892b.onFinish(i2, str, requestStatistic);
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.i("awcn.HttpSession", "", this.f1895a.f1891a.getSeq(), "httpStatusCode", Integer.valueOf(i2));
        ALog.i("awcn.HttpSession", "", this.f1895a.f1891a.getSeq(), "response headers", map);
        this.f1895a.f1892b.onResponseCode(i2, map);
        this.f1895a.f1893c.serverRT = HttpHelper.parseServerRT(map);
        f fVar = this.f1895a;
        fVar.f1894d.handleResponseCode(fVar.f1891a, i2);
        f fVar2 = this.f1895a;
        fVar2.f1894d.handleResponseHeaders(fVar2.f1891a, map);
    }
}

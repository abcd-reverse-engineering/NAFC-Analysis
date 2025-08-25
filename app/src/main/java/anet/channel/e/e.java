package anet.channel.e;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import com.just.agentweb.DefaultWebClient;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f1756a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f1757b;

    e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1756a = list;
        this.f1757b = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        IConnStrategy iConnStrategy = (IConnStrategy) this.f1756a.get(0);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(DefaultWebClient.HTTPS_SCHEME + a.f1744b, "Http3Detect" + a.f1750h.getAndIncrement(), a.b(iConnStrategy)));
        tnetSpdySession.registerEventcb(257, new f(this, iConnStrategy));
        tnetSpdySession.q.isCommitted = true;
        tnetSpdySession.connect();
    }
}

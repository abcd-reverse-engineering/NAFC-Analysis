package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static d f1735a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static ExceptionDetector f1736b = new ExceptionDetector();

    /* renamed from: c, reason: collision with root package name */
    private static k f1737c = new k();

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f1738d = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f1738d.compareAndSet(false, true)) {
                ALog.i("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                f1735a.b();
                f1736b.a();
                f1737c.a();
            }
        } catch (Exception e2) {
            ALog.e("awcn.NetworkDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(RequestStatistic requestStatistic) {
        if (f1738d.get()) {
            f1736b.a(requestStatistic);
        }
    }
}

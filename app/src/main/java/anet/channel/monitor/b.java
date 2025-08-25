package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static int f1807a = 0;

    /* renamed from: b, reason: collision with root package name */
    static long f1808b = 0;

    /* renamed from: c, reason: collision with root package name */
    static long f1809c = 0;

    /* renamed from: d, reason: collision with root package name */
    static long f1810d = 0;

    /* renamed from: e, reason: collision with root package name */
    static long f1811e = 0;

    /* renamed from: f, reason: collision with root package name */
    static long f1812f = 0;

    /* renamed from: g, reason: collision with root package name */
    static double f1813g = 0.0d;

    /* renamed from: h, reason: collision with root package name */
    static double f1814h = 0.0d;

    /* renamed from: i, reason: collision with root package name */
    static double f1815i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    static double f1816j = 40.0d;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f1817k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f1818l;

    /* renamed from: m, reason: collision with root package name */
    private int f1819m;
    private e n;

    /* compiled from: Taobao */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static b f1820a = new b(null);

        a() {
        }
    }

    /* synthetic */ b(c cVar) {
        this();
    }

    static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f1819m;
        bVar.f1819m = i2 + 1;
        return i2;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.getStatus());
        } catch (Exception e2) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e2, new Object[0]);
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            f1817k = false;
        } else {
            f1817k = true;
        }
    }

    public void e() {
        f1817k = false;
    }

    private b() {
        this.f1818l = 5;
        this.f1819m = 0;
        this.n = new e();
        NetworkStatusHelper.addStatusChangeListener(new c(this));
    }

    public double c() {
        return f1815i;
    }

    public static b a() {
        return a.f1820a;
    }

    public int b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.f1818l;
    }

    public void a(long j2, long j3, long j4) {
        if (f1817k) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j2), "mRequestFinishedTime", Long.valueOf(j3), "mRequestDataSize", Long.valueOf(j4));
            }
            if (j4 <= 3000 || j2 >= j3) {
                return;
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this, j4, j3, j2));
        }
    }
}

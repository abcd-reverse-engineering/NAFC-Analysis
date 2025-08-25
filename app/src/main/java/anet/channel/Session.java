package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class Session implements Comparable<Session> {
    static ExecutorService v = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    public Context f1621a;

    /* renamed from: c, reason: collision with root package name */
    public String f1623c;

    /* renamed from: d, reason: collision with root package name */
    public String f1624d;

    /* renamed from: e, reason: collision with root package name */
    public String f1625e;

    /* renamed from: f, reason: collision with root package name */
    public String f1626f;

    /* renamed from: g, reason: collision with root package name */
    public int f1627g;

    /* renamed from: h, reason: collision with root package name */
    public String f1628h;

    /* renamed from: i, reason: collision with root package name */
    public int f1629i;

    /* renamed from: j, reason: collision with root package name */
    public ConnType f1630j;

    /* renamed from: k, reason: collision with root package name */
    public IConnStrategy f1631k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1633m;
    protected Runnable o;
    public final String p;
    public final SessionStatistic q;
    public int r;
    public int s;
    private Future<?> x;

    /* renamed from: b, reason: collision with root package name */
    Map<EventCb, Integer> f1622b = new LinkedHashMap();
    private boolean w = false;

    /* renamed from: l, reason: collision with root package name */
    public String f1632l = null;
    public int n = 6;
    public boolean t = false;
    protected boolean u = true;
    private List<Long> y = null;
    private long z = 0;

    /* compiled from: Taobao */
    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;

        /* renamed from: a, reason: collision with root package name */
        static final String[] f1634a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        static String a(int i2) {
            return f1634a[i2];
        }
    }

    public Session(Context context, anet.channel.entity.a aVar) {
        boolean z = false;
        this.f1633m = false;
        this.f1621a = context;
        this.f1625e = aVar.a();
        this.f1626f = this.f1625e;
        this.f1627g = aVar.b();
        this.f1630j = aVar.c();
        this.f1623c = aVar.f();
        String str = this.f1623c;
        this.f1624d = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.s = aVar.e();
        this.r = aVar.d();
        this.f1631k = aVar.f1761a;
        IConnStrategy iConnStrategy = this.f1631k;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z = true;
        }
        this.f1633m = z;
        this.p = aVar.h();
        this.q = new SessionStatistic(aVar);
        this.q.host = this.f1624d;
    }

    public static void configTnetALog(Context context, String str, int i2, int i3) throws SpdyErrorException, UnsatisfiedLinkError {
        SpdyAgent spdyAgent = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (spdyAgent == null || !SpdyAgent.checkLoadSucc()) {
            ALog.e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
        } else {
            spdyAgent.configLogFile(str, i2, i3);
        }
    }

    protected void a() {
        Future<?> future;
        if (this.o == null || (future = this.x) == null) {
            return;
        }
        future.cancel(true);
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z) {
        this.t = z;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.f1631k;
    }

    public ConnType getConnType() {
        return this.f1630j;
    }

    public String getHost() {
        return this.f1623c;
    }

    public String getIp() {
        return this.f1625e;
    }

    public int getPort() {
        return this.f1627g;
    }

    public String getRealHost() {
        return this.f1624d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.f1632l;
    }

    public void handleCallbacks(int i2, anet.channel.entity.b bVar) {
        v.submit(new b(this, i2, bVar));
    }

    public void handleResponseCode(Request request, int i2) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i2 >= 500 && i2 < 600) {
            synchronized (this) {
                if (this.y == null) {
                    this.y = new LinkedList();
                }
                if (this.y.size() < 5) {
                    this.y.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long jLongValue = this.y.remove(0).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - jLongValue <= com.heytap.mcssdk.constant.a.f5800d) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.y.clear();
                    } else {
                        this.y.add(Long.valueOf(jCurrentTimeMillis));
                    }
                }
            }
        }
    }

    public void handleResponseHeaders(Request request, Map<String, List<String>> map) {
        try {
            if (map.containsKey(HttpConstant.X_SWITCH_UNIT)) {
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.X_SWITCH_UNIT);
                if (TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    singleHeaderFieldByKey = null;
                }
                if (StringUtils.isStringEqual(this.f1632l, singleHeaderFieldByKey)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.z > com.heytap.mcssdk.constant.a.f5800d) {
                    StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                    this.z = jCurrentTimeMillis;
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    public synchronized void notifyStatus(int i2, anet.channel.entity.b bVar) {
        ALog.e("awcn.Session", "notifyStatus", this.p, NotificationCompat.CATEGORY_STATUS, a.a(i2));
        if (i2 == this.n) {
            ALog.i("awcn.Session", "ignore notifyStatus", this.p, new Object[0]);
            return;
        }
        this.n = i2;
        switch (this.n) {
            case 0:
                handleCallbacks(1, bVar);
                break;
            case 2:
                handleCallbacks(256, bVar);
                break;
            case 4:
                this.f1632l = StrategyCenter.getInstance().getUnitByHost(this.f1624d);
                handleCallbacks(512, bVar);
                break;
            case 5:
                handleCallbacks(1024, bVar);
                break;
            case 6:
                onDisconnect();
                if (!this.w) {
                    handleCallbacks(2, bVar);
                    break;
                }
                break;
        }
    }

    public void onDisconnect() {
    }

    public void ping(boolean z) {
    }

    public void ping(boolean z, int i2) {
    }

    public void registerEventcb(int i2, EventCb eventCb) {
        Map<EventCb, Integer> map = this.f1622b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i2));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
    }

    public void setPingTimeout(int i2) {
        if (this.o == null) {
            this.o = getRecvTimeOutRunnable();
        }
        a();
        Runnable runnable = this.o;
        if (runnable != null) {
            this.x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, i2, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.p + '|' + this.f1630j + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(Session session) {
        return ConnType.compare(this.f1630j, session.f1630j);
    }
}

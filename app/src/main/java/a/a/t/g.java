package a.a.t;

import a.a.j.a;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ENV;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.DefaultFinishEvent;
import com.tencent.open.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class g implements a.a.t.a {
    public static final String n = "anet.NetworkTask";
    public static final int o = 131072;

    /* renamed from: a, reason: collision with root package name */
    l f1197a;

    /* renamed from: b, reason: collision with root package name */
    a.a.j.a f1198b;

    /* renamed from: c, reason: collision with root package name */
    a.C0001a f1199c;

    /* renamed from: e, reason: collision with root package name */
    String f1201e;

    /* renamed from: h, reason: collision with root package name */
    volatile AtomicBoolean f1204h;

    /* renamed from: d, reason: collision with root package name */
    ByteArrayOutputStream f1200d = null;

    /* renamed from: f, reason: collision with root package name */
    volatile Cancelable f1202f = null;

    /* renamed from: g, reason: collision with root package name */
    volatile boolean f1203g = false;

    /* renamed from: i, reason: collision with root package name */
    int f1205i = 0;

    /* renamed from: j, reason: collision with root package name */
    int f1206j = 0;

    /* renamed from: k, reason: collision with root package name */
    boolean f1207k = false;

    /* renamed from: l, reason: collision with root package name */
    boolean f1208l = false;

    /* renamed from: m, reason: collision with root package name */
    a f1209m = null;

    g(l lVar, a.a.j.a aVar, a.C0001a c0001a) {
        this.f1198b = null;
        this.f1199c = null;
        this.f1201e = DispatchConstants.OTHER;
        this.f1204h = null;
        this.f1197a = lVar;
        this.f1204h = lVar.f1233d;
        this.f1198b = aVar;
        this.f1199c = c0001a;
        this.f1201e = lVar.f1230a.h().get(HttpConstant.F_REFER);
    }

    private Session b() {
        Session throwsException;
        SessionCenter sessionCenterA = a();
        HttpUrl httpUrlF = this.f1197a.f1230a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        anetwork.channel.entity.k kVar = this.f1197a.f1230a;
        RequestStatistic requestStatistic = kVar.f2226f;
        if (kVar.f2230j != 1 || !a.a.k.b.r() || this.f1197a.f1230a.f2225e != 0 || zContainsNonDefaultPort) {
            return a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort);
        }
        HttpUrl httpUrlA = a(httpUrlF);
        try {
            throwsException = sessionCenterA.getThrowsException(httpUrlA, anet.channel.entity.c.f1769a, 0L);
        } catch (NoAvailStrategyException unused) {
            return a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort);
        } catch (Exception unused2) {
            throwsException = null;
        }
        if (throwsException == null) {
            ThreadPoolExecutorFactory.submitPriorityTask(new i(this, sessionCenterA, httpUrlA, requestStatistic, httpUrlF, zContainsNonDefaultPort), ThreadPoolExecutorFactory.Priority.NORMAL);
            return null;
        }
        ALog.i(n, "tryGetSession", this.f1197a.f1232c, "Session", throwsException);
        requestStatistic.spdyRequestSend = true;
        return throwsException;
    }

    private void c() {
        SessionCenter sessionCenterA = a();
        HttpUrl httpUrlF = this.f1197a.f1230a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        anetwork.channel.entity.k kVar = this.f1197a.f1230a;
        RequestStatistic requestStatistic = kVar.f2226f;
        Request requestA = kVar.a();
        if (this.f1197a.f1230a.f2230j != 1 || !a.a.k.b.r() || this.f1197a.f1230a.f2225e != 0 || zContainsNonDefaultPort) {
            a(a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort), requestA);
            return;
        }
        sessionCenterA.asyncGet(a(httpUrlF), anet.channel.entity.c.f1769a, 3000L, new j(this, requestStatistic, System.currentTimeMillis(), requestA, sessionCenterA, httpUrlF, zContainsNonDefaultPort));
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f1203g = true;
        if (this.f1202f != null) {
            this.f1202f.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1203g) {
            return;
        }
        RequestStatistic requestStatistic = this.f1197a.f1230a.f2226f;
        requestStatistic.f_refer = this.f1201e;
        if (!NetworkStatusHelper.isConnected()) {
            if (a.a.k.b.o() && requestStatistic.statusCode != -200) {
                requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
                ThreadPoolExecutorFactory.submitScheduledTask(new h(this), 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            if (ALog.isPrintLog(2)) {
                ALog.i(n, HttpUtils.NetworkUnavailableException.ERROR_INFO, this.f1197a.f1232c, "NetworkStatus", NetworkStatusHelper.getStatus());
            }
            this.f1204h.set(true);
            this.f1197a.a();
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
            requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_NO_NETWORK);
            requestStatistic.rspEnd = System.currentTimeMillis();
            l lVar = this.f1197a;
            lVar.f1231b.a(new DefaultFinishEvent(ErrorConstant.ERROR_NO_NETWORK, (String) null, lVar.f1230a.a()));
            return;
        }
        if (!a.a.k.b.g() || !GlobalAppRuntimeInfo.isAppBackground() || AppLifecycle.lastEnterBackgroundTime <= 0 || AppLifecycle.isGoingForeground || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= a.a.k.b.a() || a.a.k.b.b(this.f1197a.f1230a.f()) || a.a.k.b.a(this.f1197a.f1230a.a().getBizId()) || this.f1197a.f1230a.a().isAllowRequestInBg()) {
            if (ALog.isPrintLog(2)) {
                l lVar2 = this.f1197a;
                ALog.i(n, "exec request", lVar2.f1232c, "retryTimes", Integer.valueOf(lVar2.f1230a.f2225e));
            }
            if (a.a.k.b.k()) {
                c();
                return;
            }
            try {
                Session sessionB = b();
                if (sessionB == null) {
                    return;
                }
                a(sessionB, this.f1197a.f1230a.a());
                return;
            } catch (Exception e2) {
                ALog.e(n, "send request failed.", this.f1197a.f1232c, e2, new Object[0]);
                return;
            }
        }
        this.f1204h.set(true);
        this.f1197a.a();
        if (ALog.isPrintLog(2)) {
            l lVar3 = this.f1197a;
            ALog.i(n, "request forbidden in background", lVar3.f1232c, "url", lVar3.f1230a.f());
        }
        requestStatistic.isDone.set(true);
        requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG;
        requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG);
        requestStatistic.rspEnd = System.currentTimeMillis();
        l lVar4 = this.f1197a;
        lVar4.f1231b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, (String) null, lVar4.f1230a.a()));
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
        exceptionStatistic.host = this.f1197a.f1230a.f().host();
        exceptionStatistic.url = this.f1197a.f1230a.g();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f1210a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, List<String>> f1211b;

        /* renamed from: c, reason: collision with root package name */
        List<ByteArray> f1212c = new ArrayList();

        a(int i2, Map<String, List<String>> map) {
            this.f1210a = i2;
            this.f1211b = map;
        }

        void a() {
            Iterator<ByteArray> it = this.f1212c.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
        }

        int a(a.a.p.a aVar, int i2) {
            aVar.onResponseCode(this.f1210a, this.f1211b);
            Iterator<ByteArray> it = this.f1212c.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                aVar.a(i3, i2, it.next());
                i3++;
            }
            return i3;
        }
    }

    private HttpUrl a(HttpUrl httpUrl) {
        HttpUrl httpUrl2;
        String str = this.f1197a.f1230a.h().get(HttpConstant.X_HOST_CNAME);
        return (TextUtils.isEmpty(str) || (httpUrl2 = HttpUrl.parse(httpUrl.urlString().replaceFirst(httpUrl.host(), str))) == null) ? httpUrl : httpUrl2;
    }

    private SessionCenter a() {
        String strA = this.f1197a.f1230a.a(a.a.u.a.f1244a);
        if (TextUtils.isEmpty(strA)) {
            return SessionCenter.getInstance();
        }
        ENV env = ENV.ONLINE;
        String strA2 = this.f1197a.f1230a.a(a.a.u.a.f1245b);
        if (a.a.u.a.f1256m.equalsIgnoreCase(strA2)) {
            env = ENV.PREPARE;
        } else if (a.a.u.a.n.equalsIgnoreCase(strA2)) {
            env = ENV.TEST;
        }
        if (env != a.a.o.c.CURRENT_ENV) {
            a.a.o.c.CURRENT_ENV = env;
            SessionCenter.switchEnvironment(env);
        }
        Config config = Config.getConfig(strA, env);
        if (config == null) {
            config = new Config.Builder().setAppkey(strA).setEnv(env).setAuthCode(this.f1197a.f1230a.a(a.a.u.a.f1246c)).build();
        }
        return SessionCenter.getInstance(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Session a(Session session, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        anetwork.channel.entity.k kVar = this.f1197a.f1230a;
        RequestStatistic requestStatistic = kVar.f2226f;
        if (session == null && kVar.e() && !z && !NetworkStatusHelper.isProxy()) {
            session = sessionCenter.get(httpUrl, anet.channel.entity.c.f1770b, 0L);
        }
        if (session == null) {
            ALog.i(n, "create HttpSession with local DNS", this.f1197a.f1232c, new Object[0]);
            session = new anet.channel.session.d(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(StringUtils.concatString(httpUrl.scheme(), HttpConstant.SCHEME_SPLIT, httpUrl.host()), this.f1197a.f1232c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.i(n, "tryGetHttpSession", this.f1197a.f1232c, "Session", session);
        return session;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private anet.channel.request.Request a(anet.channel.request.Request r7) {
        /*
            r6 = this;
            a.a.t.l r0 = r6.f1197a
            anetwork.channel.entity.k r0 = r0.f1230a
            boolean r0 = r0.i()
            if (r0 == 0) goto L3c
            a.a.t.l r0 = r6.f1197a
            anetwork.channel.entity.k r0 = r0.f1230a
            java.lang.String r0 = r0.g()
            java.lang.String r0 = a.a.l.a.b(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L3c
            anet.channel.request.Request$Builder r1 = r7.newBuilder()
            java.util.Map r2 = r7.getHeaders()
            java.lang.String r3 = "Cookie"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L38
            java.lang.String r4 = "; "
            java.lang.String r0 = anet.channel.util.StringUtils.concatString(r2, r4, r0)
        L38:
            r1.addHeader(r3, r0)
            goto L3d
        L3c:
            r1 = 0
        L3d:
            a.a.j.a$a r0 = r6.f1199c
            if (r0 == 0) goto L65
            if (r1 != 0) goto L47
            anet.channel.request.Request$Builder r1 = r7.newBuilder()
        L47:
            a.a.j.a$a r0 = r6.f1199c
            java.lang.String r0 = r0.etag
            if (r0 == 0) goto L52
            java.lang.String r2 = "If-None-Match"
            r1.addHeader(r2, r0)
        L52:
            a.a.j.a$a r0 = r6.f1199c
            long r2 = r0.lastModified
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L65
            java.lang.String r0 = a.a.j.d.a(r2)
            java.lang.String r2 = "If-Modified-Since"
            r1.addHeader(r2, r0)
        L65:
            a.a.t.l r0 = r6.f1197a
            anetwork.channel.entity.k r0 = r0.f1230a
            int r0 = r0.f2225e
            if (r0 != 0) goto L84
            java.lang.String r0 = r6.f1201e
            java.lang.String r2 = "weex"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L84
            if (r1 != 0) goto L7f
            anet.channel.request.Request$Builder r0 = r7.newBuilder()
            r1 = r0
        L7f:
            r0 = 3000(0xbb8, float:4.204E-42)
            r1.setReadTimeout(r0)
        L84:
            if (r1 != 0) goto L87
            goto L8b
        L87:
            anet.channel.request.Request r7 = r1.build()
        L8b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.t.g.a(anet.channel.request.Request):anet.channel.request.Request");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Session session, Request request) {
        if (session == null || this.f1203g) {
            return;
        }
        Request requestA = a(request);
        RequestStatistic requestStatistic = this.f1197a.f1230a.f2226f;
        requestStatistic.reqStart = System.currentTimeMillis();
        this.f1202f = session.request(requestA, new k(this, requestA, requestStatistic));
    }
}

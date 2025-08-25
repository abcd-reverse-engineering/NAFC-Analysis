package anet.channel;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.Config;
import anet.channel.detect.n;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SessionCenter {
    public static final String TAG = "awcn.SessionCenter";

    /* renamed from: a, reason: collision with root package name */
    static Map<Config, SessionCenter> f1635a = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static boolean f1636j = false;

    /* renamed from: c, reason: collision with root package name */
    String f1638c;

    /* renamed from: d, reason: collision with root package name */
    Config f1639d;

    /* renamed from: h, reason: collision with root package name */
    final AccsSessionManager f1643h;

    /* renamed from: e, reason: collision with root package name */
    final e f1640e = new e();

    /* renamed from: f, reason: collision with root package name */
    final LruCache<String, SessionRequest> f1641f = new LruCache<>(32);

    /* renamed from: g, reason: collision with root package name */
    final c f1642g = new c();

    /* renamed from: i, reason: collision with root package name */
    final a f1644i = new a(this, null);

    /* renamed from: b, reason: collision with root package name */
    Context f1637b = GlobalAppRuntimeInfo.getContext();

    private SessionCenter(Config config) {
        this.f1639d = config;
        this.f1638c = config.getAppkey();
        this.f1644i.a();
        this.f1643h = new AccsSessionManager(this);
        if (config.getAppkey().equals("[default]")) {
            return;
        }
        AmdcRuntimeInfo.setSign(new d(this, config.getAppkey(), config.getSecurity()));
    }

    public static void checkAndStartAccsSession() {
        Iterator<SessionCenter> it = f1635a.values().iterator();
        while (it.hasNext()) {
            it.next().f1643h.checkAndStartSession();
        }
    }

    public static synchronized SessionCenter getInstance(String str) {
        Config configByTag;
        configByTag = Config.getConfigByTag(str);
        if (configByTag == null) {
            throw new RuntimeException("tag not exist!");
        }
        return getInstance(configByTag);
    }

    public static synchronized void init(Context context) {
        if (context == null) {
            ALog.e(TAG, "context is null!", null, new Object[0]);
            throw new NullPointerException("init failed. context is null");
        }
        GlobalAppRuntimeInfo.setContext(context.getApplicationContext());
        if (!f1636j) {
            f1635a.put(Config.DEFAULT_CONFIG, new SessionCenter(Config.DEFAULT_CONFIG));
            AppLifecycle.initialize();
            NetworkStatusHelper.startListener(context);
            if (!AwcnConfig.isTbNextLaunch()) {
                StrategyCenter.getInstance().initialize(GlobalAppRuntimeInfo.getContext());
            }
            if (GlobalAppRuntimeInfo.isTargetProcess()) {
                n.a();
                anet.channel.e.a.a();
            }
            f1636j = true;
        }
    }

    public static synchronized void switchEnvironment(ENV env) {
        try {
            if (GlobalAppRuntimeInfo.getEnv() != env) {
                ALog.i(TAG, "switch env", null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                GlobalAppRuntimeInfo.setEnv(env);
                StrategyCenter.getInstance().switchEnv();
                SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).switchAccsServer(env == ENV.TEST ? 0 : 1);
            }
            Iterator<Map.Entry<Config, SessionCenter>> it = f1635a.entrySet().iterator();
            while (it.hasNext()) {
                SessionCenter value = it.next().getValue();
                if (value.f1639d.getEnv() != env) {
                    ALog.i(TAG, "remove instance", value.f1638c, a.a.u.a.f1245b, value.f1639d.getEnv());
                    value.f1643h.forceCloseSession(false);
                    value.f1644i.b();
                    it.remove();
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "switch env error.", null, th, new Object[0]);
        }
    }

    public void asyncGet(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) {
        if (sessionGetCallback == null) {
            throw new NullPointerException("cb is null");
        }
        if (j2 <= 0) {
            throw new InvalidParameterException("timeout must > 0");
        }
        try {
            b(httpUrl, i2, j2, sessionGetCallback);
        } catch (Exception unused) {
            sessionGetCallback.onSessionGetFail();
        }
    }

    protected void b(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo sessionInfoB;
        if (!f1636j) {
            ALog.e(TAG, "getInternal not inited!", this.f1638c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl == null) {
            throw new InvalidParameterException("httpUrl is null");
        }
        if (sessionGetCallback == null) {
            throw new InvalidParameterException("sessionGetCallback is null");
        }
        String str = this.f1638c;
        Object[] objArr = new Object[6];
        objArr[0] = bh.aK;
        objArr[1] = httpUrl.urlString();
        objArr[2] = "sessionType";
        objArr[3] = i2 == anet.channel.entity.c.f1769a ? "LongLink" : "ShortLink";
        objArr[4] = "timeout";
        objArr[5] = Long.valueOf(j2);
        ALog.d(TAG, "getInternal", str, objArr);
        SessionRequest sessionRequestA = a(httpUrl);
        Session sessionA = this.f1640e.a(sessionRequestA, i2);
        if (sessionA != null) {
            ALog.d(TAG, "get internal hit cache session", this.f1638c, com.umeng.analytics.pro.d.aw, sessionA);
            sessionGetCallback.onSessionGetSuccess(sessionA);
            return;
        }
        if (this.f1639d == Config.DEFAULT_CONFIG && i2 != anet.channel.entity.c.f1770b) {
            sessionGetCallback.onSessionGetFail();
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground() && i2 == anet.channel.entity.c.f1769a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (sessionInfoB = this.f1642g.b(httpUrl.host())) != null && sessionInfoB.isAccs) {
            ALog.w(TAG, "app background, forbid to create accs session", this.f1638c, new Object[0]);
            throw new ConnectException("accs session connecting forbidden in background");
        }
        sessionRequestA.b(this.f1637b, i2, anet.channel.util.i.a(this.f1638c), sessionGetCallback, j2);
    }

    @Deprecated
    public void enterBackground() {
        AppLifecycle.onBackground();
    }

    @Deprecated
    public void enterForeground() {
        AppLifecycle.onForeground();
    }

    public void forceRecreateAccsSession() {
        this.f1643h.forceCloseSession(true);
    }

    public Session get(String str, long j2) {
        return get(HttpUrl.parse(str), anet.channel.entity.c.f1771c, j2);
    }

    public Session getThrowsException(String str, long j2) throws Exception {
        return a(HttpUrl.parse(str), anet.channel.entity.c.f1771c, j2, null);
    }

    public void registerAccsSessionListener(ISessionListener iSessionListener) {
        this.f1643h.registerListener(iSessionListener);
    }

    public void registerPublicKey(String str, int i2) {
        this.f1642g.a(str, i2);
    }

    public void registerSessionInfo(SessionInfo sessionInfo) {
        this.f1642g.a(sessionInfo);
        if (sessionInfo.isKeepAlive) {
            this.f1643h.checkAndStartSession();
        }
    }

    @Deprecated
    public synchronized void switchEnv(ENV env) {
        switchEnvironment(env);
    }

    public void unregisterAccsSessionListener(ISessionListener iSessionListener) {
        this.f1643h.unregisterListener(iSessionListener);
    }

    public void unregisterSessionInfo(String str) {
        SessionInfo sessionInfoA = this.f1642g.a(str);
        if (sessionInfoA == null || !sessionInfoA.isKeepAlive) {
            return;
        }
        this.f1643h.checkAndStartSession();
    }

    /* compiled from: Taobao */
    private class a implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f1645a;

        private a() {
            this.f1645a = false;
        }

        void a() {
            AppLifecycle.registerLifecycleListener(this);
            NetworkStatusHelper.addStatusChangeListener(this);
            StrategyCenter.getInstance().registerListener(this);
        }

        void b() {
            StrategyCenter.getInstance().unregisterListener(this);
            AppLifecycle.unregisterLifecycleListener(this);
            NetworkStatusHelper.removeStatusChangeListener(this);
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
            ALog.i(SessionCenter.TAG, "[background]", SessionCenter.this.f1638c, new Object[0]);
            if (!SessionCenter.f1636j) {
                ALog.e(SessionCenter.TAG, "background not inited!", SessionCenter.this.f1638c, new Object[0]);
                return;
            }
            try {
                StrategyCenter.getInstance().saveData();
                if (AwcnConfig.isAccsSessionCreateForbiddenInBg() && "OPPO".equalsIgnoreCase(Build.BRAND)) {
                    ALog.i(SessionCenter.TAG, "close session for OPPO", SessionCenter.this.f1638c, new Object[0]);
                    SessionCenter.this.f1643h.forceCloseSession(false);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            ALog.i(SessionCenter.TAG, "[forground]", SessionCenter.this.f1638c, new Object[0]);
            if (SessionCenter.this.f1637b == null || this.f1645a) {
                return;
            }
            this.f1645a = true;
            try {
                if (!SessionCenter.f1636j) {
                    ALog.e(SessionCenter.TAG, "forground not inited!", SessionCenter.this.f1638c, new Object[0]);
                    return;
                }
                try {
                    if (AppLifecycle.lastEnterBackgroundTime == 0 || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= com.heytap.mcssdk.constant.a.f5800d) {
                        SessionCenter.this.f1643h.checkAndStartSession();
                    } else {
                        SessionCenter.this.f1643h.forceCloseSession(true);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f1645a = false;
                    throw th;
                }
                this.f1645a = false;
            } catch (Exception unused2) {
            }
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.e(SessionCenter.TAG, "onNetworkStatusChanged.", SessionCenter.this.f1638c, "networkStatus", networkStatus);
            List<SessionRequest> listA = SessionCenter.this.f1640e.a();
            if (!listA.isEmpty()) {
                for (SessionRequest sessionRequest : listA) {
                    ALog.d(SessionCenter.TAG, "network change, try recreate session", SessionCenter.this.f1638c, new Object[0]);
                    sessionRequest.a((String) null);
                }
            }
            SessionCenter.this.f1643h.checkAndStartSession();
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(l.d dVar) {
            SessionCenter.this.a(dVar);
            SessionCenter.this.f1643h.checkAndStartSession();
        }

        /* synthetic */ a(SessionCenter sessionCenter, d dVar) {
            this();
        }
    }

    @Deprecated
    public Session get(String str, ConnType.TypeLevel typeLevel, long j2) {
        return get(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f1769a : anet.channel.entity.c.f1770b, j2);
    }

    @Deprecated
    public Session getThrowsException(String str, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return a(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f1769a : anet.channel.entity.c.f1770b, j2, null);
    }

    private SessionRequest a(HttpUrl httpUrl) {
        String cNameByHost = StrategyCenter.getInstance().getCNameByHost(httpUrl.host());
        if (cNameByHost == null) {
            cNameByHost = httpUrl.host();
        }
        String strScheme = httpUrl.scheme();
        if (!httpUrl.isSchemeLocked()) {
            strScheme = StrategyCenter.getInstance().getSchemeByHost(cNameByHost, strScheme);
        }
        return a(StringUtils.concatString(strScheme, HttpConstant.SCHEME_SPLIT, cNameByHost));
    }

    @Deprecated
    public Session get(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j2) {
        return get(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f1769a : anet.channel.entity.c.f1770b, j2);
    }

    public Session getThrowsException(HttpUrl httpUrl, int i2, long j2) throws Exception {
        return a(httpUrl, i2, j2, null);
    }

    public static synchronized SessionCenter getInstance(Config config) {
        SessionCenter sessionCenter;
        Context appContext;
        if (config != null) {
            if (!f1636j && (appContext = Utils.getAppContext()) != null) {
                init(appContext);
            }
            sessionCenter = f1635a.get(config);
            if (sessionCenter == null) {
                sessionCenter = new SessionCenter(config);
                f1635a.put(config, sessionCenter);
            }
        } else {
            throw new NullPointerException("config is null!");
        }
        return sessionCenter;
    }

    public Session get(HttpUrl httpUrl, int i2, long j2) {
        try {
            return a(httpUrl, i2, j2, null);
        } catch (NoAvailStrategyException e2) {
            ALog.i(TAG, "[Get]" + e2.getMessage(), this.f1638c, null, "url", httpUrl.urlString());
            return null;
        } catch (ConnectException e3) {
            ALog.e(TAG, "[Get]connect exception", this.f1638c, "errMsg", e3.getMessage(), "url", httpUrl.urlString());
            return null;
        } catch (InvalidParameterException e4) {
            ALog.e(TAG, "[Get]param url is invalid", this.f1638c, e4, "url", httpUrl);
            return null;
        } catch (TimeoutException e5) {
            ALog.e(TAG, "[Get]timeout exception", this.f1638c, e5, "url", httpUrl.urlString());
            return null;
        } catch (Exception e6) {
            ALog.e(TAG, "[Get]" + e6.getMessage(), this.f1638c, null, "url", httpUrl.urlString());
            return null;
        }
    }

    @Deprecated
    public Session getThrowsException(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return a(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f1769a : anet.channel.entity.c.f1770b, j2, null);
    }

    protected Session a(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo sessionInfoB;
        if (!f1636j) {
            ALog.e(TAG, "getInternal not inited!", this.f1638c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl != null) {
            String str = this.f1638c;
            Object[] objArr = new Object[6];
            objArr[0] = bh.aK;
            objArr[1] = httpUrl.urlString();
            objArr[2] = "sessionType";
            objArr[3] = i2 == anet.channel.entity.c.f1769a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j2);
            ALog.d(TAG, "getInternal", str, objArr);
            SessionRequest sessionRequestA = a(httpUrl);
            Session sessionA = this.f1640e.a(sessionRequestA, i2);
            if (sessionA != null) {
                ALog.d(TAG, "get internal hit cache session", this.f1638c, com.umeng.analytics.pro.d.aw, sessionA);
            } else {
                if (this.f1639d == Config.DEFAULT_CONFIG && i2 != anet.channel.entity.c.f1770b) {
                    if (sessionGetCallback == null) {
                        return null;
                    }
                    sessionGetCallback.onSessionGetFail();
                    return null;
                }
                if (GlobalAppRuntimeInfo.isAppBackground() && i2 == anet.channel.entity.c.f1769a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (sessionInfoB = this.f1642g.b(httpUrl.host())) != null && sessionInfoB.isAccs) {
                    ALog.w(TAG, "app background, forbid to create accs session", this.f1638c, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                }
                sessionRequestA.a(this.f1637b, i2, anet.channel.util.i.a(this.f1638c), sessionGetCallback, j2);
                if (sessionGetCallback == null && j2 > 0 && (i2 == anet.channel.entity.c.f1771c || sessionRequestA.b() == i2)) {
                    sessionRequestA.a(j2);
                    sessionA = this.f1640e.a(sessionRequestA, i2);
                    if (sessionA == null) {
                        throw new ConnectException("session connecting failed or timeout");
                    }
                }
            }
            return sessionA;
        }
        throw new InvalidParameterException("httpUrl is null");
    }

    @Deprecated
    public static synchronized SessionCenter getInstance() {
        Context appContext;
        if (!f1636j && (appContext = Utils.getAppContext()) != null) {
            init(appContext);
        }
        SessionCenter sessionCenter = null;
        for (Map.Entry<Config, SessionCenter> entry : f1635a.entrySet()) {
            SessionCenter value = entry.getValue();
            if (entry.getKey() != Config.DEFAULT_CONFIG) {
                return value;
            }
            sessionCenter = value;
        }
        return sessionCenter;
    }

    @Deprecated
    public static synchronized void init(Context context, String str) {
        init(context, str, GlobalAppRuntimeInfo.getEnv());
    }

    public static synchronized void init(Context context, String str, ENV env) {
        if (context != null) {
            Config config = Config.getConfig(str, env);
            if (config == null) {
                config = new Config.Builder().setAppkey(str).setEnv(env).build();
            }
            init(context, config);
        } else {
            ALog.e(TAG, "context is null!", null, new Object[0]);
            throw new NullPointerException("init failed. context is null");
        }
    }

    private void b(l.b bVar) {
        boolean z;
        boolean z2;
        ALog.i(TAG, "find effectNow", this.f1638c, Constants.KEY_HOST, bVar.f1997a);
        l.a[] aVarArr = bVar.f2004h;
        String[] strArr = bVar.f2002f;
        for (Session session : this.f1640e.a(a(StringUtils.buildKey(bVar.f1999c, bVar.f1997a)))) {
            if (!session.getConnType().isHttpType()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= strArr.length) {
                        z = false;
                        break;
                    } else {
                        if (session.getIp().equals(strArr[i2])) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= aVarArr.length) {
                            z2 = false;
                            break;
                        } else {
                            if (session.getPort() == aVarArr[i3].f1989a && session.getConnType().equals(ConnType.valueOf(ConnProtocol.valueOf(aVarArr[i3])))) {
                                z2 = true;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z2) {
                        if (ALog.isPrintLog(2)) {
                            ALog.i(TAG, "aisle not match", session.p, "port", Integer.valueOf(session.getPort()), "connType", session.getConnType(), "aisle", Arrays.toString(aVarArr));
                        }
                        session.close(true);
                    }
                } else {
                    if (ALog.isPrintLog(2)) {
                        ALog.i(TAG, "ip not match", session.p, "session ip", session.getIp(), "ips", Arrays.toString(strArr));
                    }
                    session.close(true);
                }
            }
        }
    }

    public static synchronized void init(Context context, Config config) {
        if (context == null) {
            ALog.e(TAG, "context is null!", null, new Object[0]);
            throw new NullPointerException("init failed. context is null");
        }
        if (config != null) {
            init(context);
            if (!f1635a.containsKey(config)) {
                f1635a.put(config, new SessionCenter(config));
            }
        } else {
            ALog.e(TAG, "paramter config is null!", null, new Object[0]);
            throw new NullPointerException("init failed. config is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l.d dVar) {
        try {
            for (l.b bVar : dVar.f2012b) {
                if (bVar.f2007k) {
                    b(bVar);
                }
                if (bVar.f2001e != null) {
                    a(bVar);
                }
            }
        } catch (Exception e2) {
            ALog.e(TAG, "checkStrategy failed", this.f1638c, e2, new Object[0]);
        }
    }

    private void a(l.b bVar) {
        for (Session session : this.f1640e.a(a(StringUtils.buildKey(bVar.f1999c, bVar.f1997a)))) {
            if (!StringUtils.isStringEqual(session.f1632l, bVar.f2001e)) {
                ALog.i(TAG, "unit change", session.p, "session unit", session.f1632l, "unit", bVar.f2001e);
                session.close(true);
            }
        }
    }

    protected SessionRequest a(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f1641f) {
            sessionRequest = this.f1641f.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.f1641f.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }
}

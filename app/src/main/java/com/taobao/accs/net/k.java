package com.taobao.accs.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class k extends com.taobao.accs.net.a implements DataFrameCb {
    private boolean o;
    private long p;
    private ScheduledFuture q;
    private Handler r;
    private Runnable s;
    private ISessionListener t;
    private Runnable u;
    private Set<String> v;

    /* compiled from: Taobao */
    public static class a implements IAuth {

        /* renamed from: a, reason: collision with root package name */
        private String f8533a;

        /* renamed from: b, reason: collision with root package name */
        private int f8534b;

        /* renamed from: c, reason: collision with root package name */
        private String f8535c;

        /* renamed from: d, reason: collision with root package name */
        private com.taobao.accs.net.a f8536d;

        public a(com.taobao.accs.net.a aVar, String str) {
            this.f8535c = aVar.d();
            this.f8533a = aVar.c(DefaultWebClient.HTTPS_SCHEME + str + "/accs/");
            this.f8534b = aVar.f8502c;
            this.f8536d = aVar;
        }

        @Override // anet.channel.IAuth
        public void auth(Session session, IAuth.AuthCallback authCallback) {
            ALog.e(this.f8535c, "auth", "URL", this.f8533a);
            session.request(new Request.Builder().setUrl(this.f8533a).build(), new u(this, authCallback));
        }
    }

    public k(Context context, int i2, String str) {
        super(context, i2, str);
        this.o = true;
        this.p = com.heytap.mcssdk.constant.a.f5801e;
        this.r = new Handler(Looper.getMainLooper());
        this.s = new l(this);
        this.t = new m(this);
        this.u = new t(this);
        this.v = Collections.synchronizedSet(new HashSet());
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.u, 120000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f8508i.isAccsHeartbeatEnable()) {
            ALog.e(d(), "startAccsHeartBeat", new Object[0]);
            ScheduledFuture scheduledFuture = this.q;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.s;
            long j2 = this.p;
            this.q = scheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.taobao.accs.net.a
    public com.taobao.accs.ut.a.c c() {
        return null;
    }

    @Override // com.taobao.accs.net.a
    public String d() {
        return "InAppConn_" + this.f8512m;
    }

    @Override // com.taobao.accs.net.a
    public void e() {
        ALog.e(d(), "shut down", new Object[0]);
        this.o = false;
    }

    @Override // com.taobao.accs.net.a
    public boolean m() {
        if (!this.f8506g) {
            return false;
        }
        try {
            Session session = SessionCenter.getInstance(this.f8508i.getAppKey()).get(b((String) null), ConnType.TypeLevel.SPDY, 0L);
            Object[] objArr = new Object[2];
            objArr[0] = "state";
            objArr[1] = Boolean.valueOf(session == null || session.isAvailable());
            ALog.e("InAppConn_", "isConnected", objArr);
            if (session != null) {
                if (session.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // anet.channel.DataFrameCb
    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i2, int i3) {
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.e(d(), "onDataReceive", "type", Integer.valueOf(i3), "dataid", Integer.valueOf(i2));
        }
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new r(this, i3, bArr, tnetSpdySession));
    }

    @Override // anet.channel.DataFrameCb
    public void onException(int i2, int i3, boolean z, String str) {
        ALog.e(d(), "errorId:" + i3 + "detail:" + str + " dataId:" + i2 + " needRetry:" + z, new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new s(this, i2, z, i3));
    }

    @Override // com.taobao.accs.net.a
    public synchronized void a() {
        ALog.d(d(), "start", new Object[0]);
        this.o = true;
        a(this.f8503d);
    }

    @Override // com.taobao.accs.net.a
    public void b() {
        this.f8505f = 0;
    }

    @Override // com.taobao.accs.net.a
    public void c(int i2) {
        super.c(i2);
    }

    @Override // com.taobao.accs.net.a
    public void a(Message message, boolean z) {
        if (this.o && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> scheduledFutureSchedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new o(this, message), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame() && a(message.cunstomDataId)) {
                            this.f8504e.b(message);
                        }
                        this.f8504e.f8450a.put(message.cunstomDataId, scheduledFutureSchedule);
                    }
                    NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                    if (netPermanceMonitor != null) {
                        netPermanceMonitor.setDeviceId(UtilityImpl.j(this.f8503d));
                        netPermanceMonitor.setConnType(this.f8502c);
                        netPermanceMonitor.onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f8504e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.e(d(), "send queue full count:" + ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f8504e.a(message, -8);
                ALog.e(d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.o, new Object[0]);
    }

    public k(Context context, int i2, String str, int i3) {
        super(context, i2, str);
        this.o = true;
        this.p = com.heytap.mcssdk.constant.a.f5801e;
        this.r = new Handler(Looper.getMainLooper());
        this.s = new l(this);
        this.t = new m(this);
        this.u = new t(this);
        this.v = Collections.synchronizedSet(new HashSet());
        c(i3);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.u, 120000L, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.a
    protected void a(String str, boolean z, long j2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new p(this, str, z), j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.a
    public void a(boolean z, boolean z2) {
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new q(this));
    }

    @Override // com.taobao.accs.net.a
    public void a(String str, boolean z, String str2) {
        Session session;
        try {
            Message messageB = this.f8504e.b(str);
            if (messageB != null && messageB.host != null && (session = SessionCenter.getInstance(this.f8508i.getAppKey()).get(messageB.host.toString(), 0L)) != null) {
                if (z) {
                    ALog.e(d(), "close session by time out", new Object[0]);
                    session.close(true);
                } else {
                    session.ping(true);
                }
            }
        } catch (Exception e2) {
            ALog.e(d(), "onTimeOut", e2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.a
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.f8504e.f8450a.get(str);
        boolean zCancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (zCancel) {
            ALog.e(d(), CommonNetImpl.CANCEL, "customDataId", str);
        }
        return zCancel;
    }

    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp response data is null", new Object[0]);
            return;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(d(), "onReceiveAccsHeartbeatResp", "data", jSONObject);
        }
        try {
            int i2 = jSONObject.getInt("timeInterval");
            if (i2 == -1) {
                if (this.q != null) {
                    this.q.cancel(true);
                    return;
                }
                return;
            }
            long j2 = i2 * 1000;
            if (this.p != j2) {
                if (i2 == 0) {
                    j2 = com.heytap.mcssdk.constant.a.f5801e;
                }
                this.p = j2;
                if (this.q != null) {
                    this.q.cancel(true);
                }
                this.q = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleAtFixedRate(this.s, this.p, this.p, TimeUnit.MILLISECONDS);
            }
        } catch (JSONException e2) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp", "e", e2.getMessage());
        }
    }

    @Override // com.taobao.accs.net.a
    protected void a(Context context) {
        boolean z;
        try {
            if (this.f8506g) {
                return;
            }
            super.a(context);
            if (com.taobao.accs.utl.t.c()) {
                SessionCenter.getInstance(this.f8508i.getAppKey()).registerAccsSessionListener(this.t);
            }
            String inappHost = this.f8508i.getInappHost();
            if (h() && this.f8508i.isKeepalive()) {
                z = true;
            } else {
                ALog.d(d(), "initAwcn close keepalive", new Object[0]);
                z = false;
            }
            a(SessionCenter.getInstance(this.f8508i.getAppKey()), inappHost, z);
            this.f8506g = true;
            ALog.i(d(), "initAwcn success!", new Object[0]);
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    public void a(SessionCenter sessionCenter, String str, boolean z) {
        if (this.v.contains(str)) {
            return;
        }
        sessionCenter.registerSessionInfo(SessionInfo.create(str, z, true, new a(this, str), null, this));
        sessionCenter.registerPublicKey(str, this.f8508i.getInappPubKey());
        this.v.add(str);
        ALog.i(d(), "registerSessionInfo", Constants.KEY_HOST, str);
    }

    public void a(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.i(d(), "updateConfig null", new Object[0]);
            return;
        }
        if (accsClientConfig.equals(this.f8508i)) {
            ALog.w(d(), "updateConfig not any changed", new Object[0]);
            return;
        }
        if (!this.f8506g) {
            if (UtilityImpl.isMainProcess(this.f8503d)) {
                this.f8508i = accsClientConfig;
                a(this.f8503d);
                return;
            }
            return;
        }
        try {
            boolean z = true;
            ALog.w(d(), "updateConfig", "old", this.f8508i, "new", accsClientConfig);
            String inappHost = this.f8508i.getInappHost();
            String inappHost2 = accsClientConfig.getInappHost();
            SessionCenter sessionCenter = SessionCenter.getInstance(this.f8508i.getAppKey());
            if (sessionCenter == null) {
                ALog.w(d(), "updateConfig not need update", new Object[0]);
                return;
            }
            sessionCenter.unregisterSessionInfo(inappHost);
            ALog.w(d(), "updateConfig unregisterSessionInfo", Constants.KEY_HOST, inappHost);
            if (this.v.contains(inappHost)) {
                this.v.remove(inappHost);
                ALog.w(d(), "updateConfig removeSessionRegistered", "oldHost", inappHost);
            }
            this.f8508i = accsClientConfig;
            this.f8501b = this.f8508i.getAppKey();
            this.f8512m = this.f8508i.getTag();
            String str = ConnType.PK_ACS;
            if (this.f8508i.getInappPubKey() == 10 || this.f8508i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "update config register new conn protocol host:", this.f8508i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f8508i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
            if (!h() || !this.f8508i.isKeepalive()) {
                ALog.i(d(), "updateConfig close keepalive", new Object[0]);
                z = false;
            }
            a(sessionCenter, inappHost2, z);
        } catch (Throwable th) {
            ALog.e(d(), "updateConfig", th, new Object[0]);
        }
    }
}

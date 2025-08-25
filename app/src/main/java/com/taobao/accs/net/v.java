package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.HttpConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import h.f1;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class v extends com.taobao.accs.net.a implements SessionCb, Spdycb {
    private SpdySession A;
    private Object B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private String H;
    private SessionMonitor I;
    private com.taobao.accs.ut.a.c J;
    private boolean K;
    private String L;
    private boolean M;
    private h N;
    private String O;
    protected ScheduledFuture<?> o;
    protected String p;
    protected int q;
    protected String r;
    protected int s;
    private int t;
    private LinkedList<Message> u;
    private a v;
    private boolean w;
    private String x;
    private String y;
    private SpdyAgent z;

    /* compiled from: Taobao */
    private class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public int f8559a;

        /* renamed from: b, reason: collision with root package name */
        long f8560b;

        /* renamed from: d, reason: collision with root package name */
        private final String f8562d;

        public a(String str) {
            super(str);
            this.f8562d = getName();
            this.f8559a = 0;
        }

        private void a(boolean z) throws InterruptedException {
            if (v.this.t == 1) {
                if (v.this.t != 1 || System.currentTimeMillis() - this.f8560b <= com.heytap.mcssdk.constant.a.r) {
                    return;
                }
                this.f8559a = 0;
                return;
            }
            ALog.d(v.this.d(), "tryConnect", "force", Boolean.valueOf(z));
            if (!UtilityImpl.i(v.this.f8503d)) {
                ALog.e(this.f8562d, "Network not available", new Object[0]);
                return;
            }
            if (z) {
                this.f8559a = 0;
            }
            ALog.i(this.f8562d, "tryConnect", "force", Boolean.valueOf(z), "failTimes", Integer.valueOf(this.f8559a));
            if (v.this.t != 1 && this.f8559a >= 4) {
                v.this.K = true;
                ALog.e(this.f8562d, "tryConnect fail", "maxTimes", 4);
                return;
            }
            if (v.this.t != 1) {
                if (v.this.f8502c == 1 && this.f8559a == 0) {
                    ALog.i(this.f8562d, "tryConnect in app, no sleep", new Object[0]);
                } else {
                    ALog.i(this.f8562d, "tryConnect, need sleep", new Object[0]);
                    try {
                        Thread.sleep(com.heytap.mcssdk.constant.a.r);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                v.this.L = "";
                if (this.f8559a == 3) {
                    v.this.N.b(v.this.p());
                }
                v.this.d((String) null);
                v.this.I.setRetryTimes(this.f8559a);
                if (v.this.t == 1) {
                    this.f8560b = System.currentTimeMillis();
                    return;
                }
                this.f8559a++;
                ALog.e(this.f8562d, "try connect fail, ready for reconnect", new Object[0]);
                a(false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0062 A[Catch: all -> 0x0507, TryCatch #2 {, blocks: (B:7:0x0027, B:9:0x0033, B:15:0x004d, B:17:0x0062, B:19:0x0074, B:21:0x007c, B:12:0x0047, B:13:0x004a), top: B:208:0x0027, inners: #0 }] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.v.a.run():void");
        }
    }

    public v(Context context, int i2, String str) {
        super(context, i2, str);
        this.t = 3;
        this.u = new LinkedList<>();
        this.w = true;
        this.z = null;
        this.A = null;
        this.B = new Object();
        this.G = -1;
        this.H = null;
        this.K = false;
        this.L = "";
        this.M = false;
        this.N = new h(p());
        u();
    }

    private int r() {
        boolean zL = l();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.f8508i.getChannelPubKey();
        if (channelPubKey <= 0) {
            return zL ? 4 : 3;
        }
        ALog.i(d(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
        return channelPubKey;
    }

    private void s() {
        if (this.A == null) {
            d(3);
            return;
        }
        try {
            String strEncode = URLEncoder.encode(UtilityImpl.j(this.f8503d));
            String strA = UtilityImpl.a(i(), this.f8508i.getAppSecret(), UtilityImpl.j(this.f8503d));
            String strC = c(this.x);
            ALog.e(d(), "auth", "url", strC);
            this.y = strC;
            if (!a(strEncode, i(), strA)) {
                ALog.e(d(), "auth param error!", new Object[0]);
                e(-6);
            } else {
                SpdyRequest spdyRequest = new SpdyRequest(new URL(strC), "GET", RequestPriority.DEFAULT_PRIORITY, 80000, com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT);
                spdyRequest.setDomain(p());
                this.A.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), p(), this);
            }
        } catch (Throwable th) {
            ALog.e(d(), "auth exception ", th, new Object[0]);
            e(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        if (this.f8502c == 1) {
            return;
        }
        this.C = System.currentTimeMillis();
        this.D = System.nanoTime();
        g.a(this.f8503d).a();
    }

    private void u() {
        try {
            SpdyAgent.enableDebug = ALog.isPrintLog();
            this.z = SpdyAgent.getInstance(this.f8503d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                com.taobao.accs.utl.q.a();
            } else {
                ALog.e(d(), "initClient", new Object[0]);
                this.z = null;
                com.taobao.accs.utl.q.b();
            }
        } catch (Throwable th) {
            ALog.e(d(), "initClient", th, new Object[0]);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
        ALog.w(d(), "bioPingRecvCallback uniId:" + i2, new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        spdySession.getDomain();
        return UtilityImpl.c();
    }

    @Override // com.taobao.accs.net.a
    protected boolean h() {
        return false;
    }

    public void o() {
        ALog.e(d(), " force close!", new Object[0]);
        try {
            this.A.closeSession();
            this.I.setCloseType(1);
        } catch (Exception unused) {
        }
        d(3);
    }

    public String p() {
        String channelHost = this.f8508i.getChannelHost();
        ALog.i(d(), "getChannelHost", Constants.KEY_HOST, channelHost);
        return channelHost == null ? "" : channelHost;
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        spdySession.getDomain();
        return UtilityImpl.b();
    }

    public boolean q() {
        return this.w;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        b(i2);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        t();
        ALog.e(d(), "onFrame", "type", Integer.valueOf(i3), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (byte b2 : bArr) {
                sb.append(Integer.toHexString(b2 & f1.f16099c));
                sb.append(c.c.a.b.a.a.f3100g);
            }
            ALog.d(d(), ((Object) sb) + " log time:" + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        }
        if (i3 == 200) {
            try {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                this.f8504e.a(bArr);
                com.taobao.accs.ut.a.d dVarG = this.f8504e.g();
                if (dVarG != null) {
                    dVarG.f8595c = String.valueOf(jCurrentTimeMillis2);
                    dVarG.f8599g = this.f8502c == 0 ? "service" : "inapp";
                    dVarG.a();
                }
            } catch (Throwable th) {
                ALog.e(d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.a(th));
            }
            ALog.d(d(), "try handle msg", new Object[0]);
            g();
        } else {
            ALog.e(d(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j2, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
        ALog.d(d(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
        ALog.d(d(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) throws NumberFormatException {
        this.C = System.currentTimeMillis();
        this.D = System.nanoTime();
        try {
            Map<String, String> mapA = UtilityImpl.a(map);
            ALog.d("SilenceConn_", "spdyOnStreamResponse", "header", map);
            int i2 = Integer.parseInt(mapA.get(HttpConstant.STATUS));
            ALog.e(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(i2));
            if (i2 == 200) {
                d(1);
                String str = mapA.get("x-at");
                if (!TextUtils.isEmpty(str)) {
                    this.f8510k = str;
                }
                this.I.auth_time = this.I.connection_stop_date > 0 ? System.currentTimeMillis() - this.I.connection_stop_date : 0L;
                String str2 = this.f8502c == 0 ? "service" : "inapp";
                UTMini.getInstance().commitEvent(66001, "CONNECTED 200 " + str2, (Object) this.y, (Object) this.L, (Object) 221, "0");
                com.taobao.accs.utl.k.a("accs", "auth", "");
            } else {
                e(i2);
            }
        } catch (Exception e2) {
            ALog.e(d(), e2.toString(), new Object[0]);
            o();
            this.I.setCloseReason("exception");
        }
        ALog.d(d(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j2, Object obj) {
        ALog.d(d(), "spdyPingRecvCallback uniId:" + j2, new Object[0]);
        if (j2 < 0) {
            return;
        }
        this.f8504e.b();
        g.a(this.f8503d).e();
        g.a(this.f8503d).a();
        this.I.onPingCBReceive();
        if (this.I.ping_rec_times % 2 == 0) {
            UtilityImpl.a(this.f8503d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j2, Object obj) {
        ALog.d(d(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.e(d(), "spdySessionCloseCallback", Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e(d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        d(3);
        this.I.onCloseConnect();
        if (this.I.getConCloseDate() > 0 && this.I.getConStopDate() > 0) {
            this.I.getConCloseDate();
            this.I.getConStopDate();
        }
        this.I.setCloseReason(this.I.getCloseReason() + "tnet error:" + i2);
        if (superviseConnectInfo != null) {
            this.I.live_time = superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.I);
        for (Message message : this.f8504e.e()) {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setRet(false);
                message.getNetPermanceMonitor().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        }
        String str = this.f8502c == 0 ? "service" : "inapp";
        ALog.d(d(), "spdySessionCloseCallback, conKeepTime:" + this.I.live_time + " connectType:" + str, new Object[0]);
        UTMini uTMini = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        uTMini.commitEvent(66001, sb.toString(), (Object) Integer.valueOf(i2), (Object) Long.valueOf(this.I.live_time), (Object) 221, this.y, this.L);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.G = superviseConnectInfo.connectTime;
        int i2 = superviseConnectInfo.handshakeTime;
        ALog.e(d(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.G), "sslTime", Integer.valueOf(i2), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        s();
        this.I.setRet(true);
        this.I.onConnectStop();
        SessionMonitor sessionMonitor = this.I;
        sessionMonitor.tcp_time = this.G;
        sessionMonitor.ssl_time = i2;
        String str = this.f8502c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED " + str + c.c.a.b.a.a.f3100g + superviseConnectInfo.sessionTicketReused, (Object) String.valueOf(this.G), (Object) String.valueOf(i2), (Object) 221, String.valueOf(superviseConnectInfo.sessionTicketReused), this.y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e(d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        a aVar = this.v;
        int i3 = aVar != null ? aVar.f8559a : 0;
        ALog.e(d(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i3), "errorId", Integer.valueOf(i2));
        this.K = false;
        this.M = true;
        d(3);
        this.I.setFailReason(i2);
        this.I.onConnectStop();
        String str = this.f8502c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) 221, this.y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i3, i2 + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
        ALog.d(d(), "spdyStreamCloseCallback", new Object[0]);
        if (i2 != 0) {
            ALog.e(d(), "spdyStreamCloseCallback", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
            e(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        SessionInfo sessionInfo;
        int i2 = this.t;
        if (i2 == 2 || i2 == 1) {
            return;
        }
        if (this.N == null) {
            this.N = new h(p());
        }
        List<IConnStrategy> listA = this.N.a(p());
        int port = Constants.PORT;
        if (listA == null || listA.size() <= 0) {
            if (str != null) {
                this.p = str;
            } else {
                this.p = p();
            }
            if (System.currentTimeMillis() % 2 == 0) {
                port = 80;
            }
            this.q = port;
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
            ALog.i(d(), "connect get ip from amdc fail!!", new Object[0]);
        } else {
            for (IConnStrategy iConnStrategy : listA) {
                if (iConnStrategy != null) {
                    ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "ip", iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                }
            }
            if (this.M) {
                this.N.b();
                this.M = false;
            }
            IConnStrategy iConnStrategyA = this.N.a();
            this.p = iConnStrategyA == null ? p() : iConnStrategyA.getIp();
            if (iConnStrategyA != null) {
                port = iConnStrategyA.getPort();
            }
            this.q = port;
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
            ALog.e(d(), "connect from amdc succ", "ip", this.p, "port", Integer.valueOf(this.q), "originPos", Integer.valueOf(this.N.c()));
        }
        this.x = DefaultWebClient.HTTPS_SCHEME + this.p + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.q + "/accs/";
        ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "URL", this.x);
        this.O = String.valueOf(System.currentTimeMillis());
        if (this.I != null) {
            AppMonitor.getInstance().commitStat(this.I);
        }
        this.I = new SessionMonitor();
        this.I.setConnectType(this.f8502c == 0 ? "service" : "inapp");
        if (this.z != null) {
            try {
                this.E = System.currentTimeMillis();
                this.F = System.nanoTime();
                this.r = UtilityImpl.a(this.f8503d);
                this.s = UtilityImpl.b(this.f8503d);
                this.C = System.currentTimeMillis();
                this.I.onStartConnect();
                d(2);
                synchronized (this.B) {
                    try {
                        try {
                            if (TextUtils.isEmpty(this.r) || this.s < 0 || !this.K) {
                                ALog.e(d(), "connect normal", new Object[0]);
                                sessionInfo = new SessionInfo(this.p, this.q, p() + c.c.a.b.a.a.s1 + this.f8501b, null, 0, this.O, this, 4226);
                                this.L = "";
                            } else {
                                ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "proxy", this.r, "port", Integer.valueOf(this.s));
                                sessionInfo = new SessionInfo(this.p, this.q, p() + c.c.a.b.a.a.s1 + this.f8501b, this.r, this.s, this.O, this, 4226);
                                this.L = this.r + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.s;
                            }
                            sessionInfo.setPubKeySeqNum(r());
                            sessionInfo.setConnectionTimeoutMs(com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT);
                            this.A = this.z.createSession(sessionInfo);
                            this.I.connection_stop_date = 0L;
                            this.B.wait();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            this.K = false;
                        }
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.taobao.accs.net.a
    public com.taobao.accs.ut.a.c c() {
        if (this.J == null) {
            this.J = new com.taobao.accs.ut.a.c();
        }
        com.taobao.accs.ut.a.c cVar = this.J;
        cVar.f8583b = this.f8502c;
        cVar.f8585d = this.u.size();
        this.J.f8590i = UtilityImpl.i(this.f8503d);
        com.taobao.accs.ut.a.c cVar2 = this.J;
        cVar2.f8587f = this.L;
        cVar2.f8582a = this.t;
        SessionMonitor sessionMonitor = this.I;
        cVar2.f8584c = sessionMonitor != null && sessionMonitor.getRet();
        this.J.f8591j = q();
        com.taobao.accs.ut.a.c cVar3 = this.J;
        com.taobao.accs.data.d dVar = this.f8504e;
        cVar3.f8586e = dVar != null ? dVar.d() : 0;
        com.taobao.accs.ut.a.c cVar4 = this.J;
        cVar4.f8588g = this.y;
        return cVar4;
    }

    @Override // com.taobao.accs.net.a
    public void e() {
        super.e();
        this.w = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new x(this));
        ALog.e(d(), "shut down", new Object[0]);
    }

    @Override // com.taobao.accs.net.a
    public void b() {
        this.K = false;
        this.f8505f = 0;
    }

    private void e(int i2) {
        this.f8510k = null;
        o();
        a aVar = this.v;
        int i3 = aVar != null ? aVar.f8559a : 0;
        this.I.setCloseReason("code not 200 is" + i2);
        this.M = true;
        String str = this.f8502c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED NO 200 " + str, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) 221, this.y, this.L);
        com.taobao.accs.utl.k.a("accs", "auth", "", i2 + "", "");
    }

    @Override // com.taobao.accs.net.a
    public void a() {
        this.w = true;
        ALog.d(d(), "start", new Object[0]);
        a(this.f8503d);
        if (this.v == null) {
            ALog.i(d(), "start thread", new Object[0]);
            this.v = new a("NetworkThread_" + this.f8512m);
            this.v.setPriority(2);
            this.v.start();
        }
        a(false, false);
    }

    @Override // com.taobao.accs.net.a
    public String b(String str) {
        return DefaultWebClient.HTTPS_SCHEME + this.f8508i.getChannelHost();
    }

    @Override // com.taobao.accs.net.a
    public void a(Message message, boolean z) {
        if (this.w && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> scheduledFutureSchedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new w(this, message, z), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame()) {
                            a(message.cunstomDataId);
                        }
                        this.f8504e.f8450a.put(message.cunstomDataId, scheduledFutureSchedule);
                    }
                    if (message.getNetPermanceMonitor() != null) {
                        message.getNetPermanceMonitor().setDeviceId(UtilityImpl.j(this.f8503d));
                        message.getNetPermanceMonitor().setConnType(this.f8502c);
                        message.getNetPermanceMonitor().onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f8504e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.e(d(), "send queue full count:" + ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f8504e.a(message, -8);
                ALog.e(d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.w, new Object[0]);
    }

    @Override // com.taobao.accs.net.a
    public void a(boolean z, boolean z2) {
        ALog.d(d(), "try ping, force:" + z, new Object[0]);
        if (this.f8502c == 1) {
            ALog.d(d(), "INAPP, skip", new Object[0]);
            return;
        }
        Message messageBuildPing = Message.BuildPing(z, (int) (z2 ? Math.random() * 10.0d * 1000.0d : 0.0d));
        int pingTimeout = this.f8508i.getPingTimeout();
        if (pingTimeout > 0) {
            messageBuildPing.timeout = pingTimeout;
        }
        b(messageBuildPing, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (message.command == null || this.u.size() == 0) {
            return;
        }
        for (int size = this.u.size() - 1; size >= 0; size--) {
            Message message2 = this.u.get(size);
            if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                switch (message.command.intValue()) {
                    case 1:
                    case 2:
                        if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                            this.u.remove(size);
                            break;
                        }
                        break;
                    case 3:
                    case 4:
                        if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                            this.u.remove(size);
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                        if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                            this.u.remove(size);
                            break;
                        }
                        break;
                }
                ALog.d(d(), "clearRepeatControlCommand message:" + message2.command + "/" + message2.getPackageName(), new Object[0]);
            }
        }
        com.taobao.accs.data.d dVar = this.f8504e;
        if (dVar != null) {
            dVar.b(message);
        }
    }

    private synchronized void d(int i2) {
        ALog.e(d(), "notifyStatus start", NotificationCompat.CATEGORY_STATUS, a(i2));
        if (i2 == this.t) {
            ALog.i(d(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.t = i2;
        if (i2 == 1) {
            g.a(this.f8503d).f();
            t();
            if (this.o != null) {
                this.o.cancel(true);
            }
            synchronized (this.B) {
                try {
                    this.B.notifyAll();
                } catch (Exception unused) {
                }
            }
            synchronized (this.u) {
                try {
                    this.u.notifyAll();
                } catch (Exception unused2) {
                }
            }
            ALog.i(d(), "notifyStatus end", NotificationCompat.CATEGORY_STATUS, a(i2));
        }
        if (i2 == 2) {
            if (this.o != null) {
                this.o.cancel(true);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new y(this, this.O), 120000L, TimeUnit.MILLISECONDS);
        } else if (i2 == 3) {
            t();
            g.a(this.f8503d).d();
            synchronized (this.B) {
                try {
                    this.B.notifyAll();
                } catch (Exception unused3) {
                }
            }
            this.f8504e.a(-10);
            a(false, true);
        }
        ALog.i(d(), "notifyStatus end", NotificationCompat.CATEGORY_STATUS, a(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            android.content.Context r0 = r11.f8503d
            int r0 = com.taobao.accs.utl.v.b(r0)
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Lb
            return r2
        Lb:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r3 = 0
            if (r0 != 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 == 0) goto Lb0
        L1e:
            r0 = 3
            r11.d(r0)
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L2a
        L28:
            r0 = 1
            goto L38
        L2a:
            boolean r12 = android.text.TextUtils.isEmpty(r13)
            if (r12 == 0) goto L32
            r0 = 2
            goto L38
        L32:
            boolean r12 = android.text.TextUtils.isEmpty(r14)
            if (r12 == 0) goto L28
        L38:
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.I
            r12.setFailReason(r0)
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.I
            r12.onConnectStop()
            int r12 = r11.f8502c
            if (r12 != 0) goto L49
            java.lang.String r12 = "service"
            goto L4b
        L49:
            java.lang.String r12 = "inapp"
        L4b:
            com.taobao.accs.net.v$a r13 = r11.v
            if (r13 == 0) goto L52
            int r13 = r13.f8559a
            goto L53
        L52:
            r13 = 0
        L53:
            com.taobao.accs.utl.UTMini r4 = com.taobao.accs.utl.UTMini.getInstance()
            r5 = 66001(0x101d1, float:9.2487E-41)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r6 = "DISCONNECT "
            r14.append(r6)
            r14.append(r12)
            java.lang.String r6 = r14.toString()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            r12 = 221(0xdd, float:3.1E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            java.lang.String[] r10 = new java.lang.String[r1]
            java.lang.String r12 = r11.y
            r10[r3] = r12
            java.lang.String r12 = r11.L
            r10[r2] = r12
            r4.commitEvent(r5, r6, r7, r8, r9, r10)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "retrytimes:"
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r0)
            java.lang.String r14 = ""
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "accs"
            java.lang.String r1 = "connect"
            com.taobao.accs.utl.k.a(r0, r1, r12, r13, r14)
            r2 = 0
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.v.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    @Override // com.taobao.accs.net.a
    public void a(String str, boolean z, String str2) {
        try {
            d(4);
            o();
            this.I.setCloseReason(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.a
    public boolean a(String str) {
        boolean z;
        synchronized (this.u) {
            z = true;
            int size = this.u.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.u.get(size);
                    if (message != null && message.getType() == 1 && message.cunstomDataId != null && message.cunstomDataId.equals(str)) {
                        this.u.remove(size);
                        break;
                    }
                    size--;
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    @Override // com.taobao.accs.net.a
    public String d() {
        return "SilenceConn_" + this.f8512m;
    }

    @Override // com.taobao.accs.net.a
    protected void a(Context context) {
        if (this.f8506g) {
            return;
        }
        super.a(context);
        GlobalAppRuntimeInfo.setBackground(false);
        this.f8506g = true;
        ALog.i(d(), "init awcn success!", new Object[0]);
    }
}

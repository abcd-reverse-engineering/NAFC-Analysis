package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.PushAgent;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class a {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;
    protected static int n;

    /* renamed from: b, reason: collision with root package name */
    public String f8501b;

    /* renamed from: c, reason: collision with root package name */
    protected int f8502c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f8503d;

    /* renamed from: e, reason: collision with root package name */
    protected com.taobao.accs.data.d f8504e;

    /* renamed from: h, reason: collision with root package name */
    public com.taobao.accs.client.b f8507h;

    /* renamed from: i, reason: collision with root package name */
    public AccsClientConfig f8508i;

    /* renamed from: j, reason: collision with root package name */
    protected String f8509j;

    /* renamed from: m, reason: collision with root package name */
    public String f8512m;
    private Runnable r;
    private ScheduledFuture<?> s;

    /* renamed from: a, reason: collision with root package name */
    public String f8500a = "android@umeng";

    /* renamed from: f, reason: collision with root package name */
    protected int f8505f = 0;
    private long o = 0;

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f8506g = false;

    /* renamed from: k, reason: collision with root package name */
    protected String f8510k = null;
    private boolean p = false;

    /* renamed from: l, reason: collision with root package name */
    protected LinkedHashMap<Integer, Message> f8511l = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            return size() > 10;
        }
    };
    private final ArrayList<AccsConnectStateListener> q = new ArrayList<>();

    protected a(Context context, int i2, String str) {
        this.f8501b = "";
        this.f8502c = i2;
        this.f8503d = context.getApplicationContext();
        this.f8508i = AccsClientConfig.getConfigByTag(str);
        if (this.f8508i == null) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            try {
                PushAgent pushAgent = PushAgent.getInstance(context);
                pushAgent.register(pushAgent.getRegisterCallback());
                this.f8508i = AccsClientConfig.getConfigByTag(str);
            } catch (Throwable th) {
                ALog.e(d(), "BaseConnection build config", th, new Object[0]);
            }
        }
        AccsClientConfig accsClientConfig = this.f8508i;
        if (accsClientConfig != null) {
            this.f8512m = accsClientConfig.getTag();
            this.f8501b = this.f8508i.getAppKey();
        }
        this.f8504e = new com.taobao.accs.data.d(context, this);
        this.f8504e.f8451b = this.f8502c;
        ALog.d(d(), "new connection", new Object[0]);
    }

    protected String a(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 3 || i2 != 4) ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTING" : "CONNECTED";
    }

    public abstract void a();

    public abstract void a(Message message, boolean z);

    protected void a(String str, boolean z, long j2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new b(this, str, z), j2, TimeUnit.MILLISECONDS);
    }

    public abstract void a(String str, boolean z, String str2);

    public abstract void a(boolean z, boolean z2);

    public abstract boolean a(String str);

    public abstract void b();

    public void b(Message message, boolean z) {
        if (!message.isAck && !UtilityImpl.i(this.f8503d)) {
            ALog.e(d(), "sendMessage ready no network", Constants.KEY_DATA_ID, message.dataId);
            this.f8504e.a(message, -13);
            return;
        }
        long jA = message.getType() != 2 ? this.f8504e.f8453d.a(message.serviceId, message.bizId) : 0L;
        if (jA == -1) {
            ALog.e(d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.dataId);
            this.f8504e.a(message, ErrorCode.SERVIER_HIGH_LIMIT);
            return;
        }
        if (jA == -1000) {
            ALog.e(d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.dataId);
            this.f8504e.a(message, ErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            return;
        }
        if (jA > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = this.o;
            if (jCurrentTimeMillis > j2) {
                message.delyTime = jA;
            } else {
                message.delyTime = (j2 + jA) - System.currentTimeMillis();
            }
            this.o = System.currentTimeMillis() + message.delyTime;
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if ("accs".equals(message.serviceId)) {
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        }
        try {
            if (TextUtils.isEmpty(this.f8509j)) {
                this.f8509j = UtilityImpl.j(this.f8503d);
            }
            if (message.isTimeOut()) {
                this.f8504e.a(message, -9);
            } else {
                a(message, z);
            }
        } catch (RejectedExecutionException unused) {
            this.f8504e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
            ALog.e(d(), "sendMessage ready queue full", "size", Integer.valueOf(ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size()));
        }
    }

    public abstract com.taobao.accs.ut.a.c c();

    protected String c(String str) {
        String strEncode;
        String strJ = UtilityImpl.j(this.f8503d);
        try {
            strEncode = URLEncoder.encode(strJ);
        } catch (Throwable th) {
            ALog.e(d(), "buildAuthUrl", th, new Object[0]);
            strEncode = strJ;
        }
        String strA = UtilityImpl.a(i(), this.f8508i.getAppSecret(), strJ);
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth?1=");
        sb.append(strEncode);
        sb.append("&2=");
        sb.append(strA);
        sb.append("&3=");
        sb.append(i());
        if (this.f8510k != null) {
            sb.append("&4=");
            sb.append(this.f8510k);
        }
        sb.append("&5=");
        sb.append(this.f8502c);
        sb.append("&6=");
        sb.append(UtilityImpl.g(this.f8503d));
        sb.append("&7=");
        sb.append(UtilityImpl.d());
        sb.append("&8=");
        sb.append(this.f8502c == 1 ? com.luozm.captcha.b.f7868g : 221);
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.f8503d.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.l(this.f8503d));
        sb.append("&14=");
        sb.append(this.f8500a);
        sb.append("&15=");
        sb.append(UtilityImpl.b(Build.MODEL));
        sb.append("&16=");
        sb.append(UtilityImpl.b(Build.BRAND));
        sb.append("&17=");
        sb.append("221");
        sb.append("&19=");
        sb.append(!l() ? 1 : 0);
        sb.append("&20=");
        sb.append(this.f8508i.getStoreId());
        return sb.toString();
    }

    public abstract String d();

    public void e() {
    }

    protected void f() {
        if (this.r == null) {
            this.r = new c(this);
        }
        g();
        this.s = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.r, 40000L, TimeUnit.MILLISECONDS);
    }

    protected void g() {
        ScheduledFuture<?> scheduledFuture = this.s;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    protected boolean h() {
        return true;
    }

    public String i() {
        return this.f8501b;
    }

    public com.taobao.accs.client.b j() {
        if (this.f8507h == null) {
            ALog.d(d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.f8512m);
            this.f8507h = new com.taobao.accs.client.b(this.f8503d, this.f8512m);
        }
        return this.f8507h;
    }

    public void k() {
        try {
            ThreadPoolExecutorFactory.schedule(new d(this), com.heytap.mcssdk.constant.a.q, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(d(), "startChannelService", th, new Object[0]);
        }
    }

    public boolean l() {
        return 2 == this.f8508i.getSecurity();
    }

    public boolean m() {
        return false;
    }

    protected ArrayList<AccsConnectStateListener> n() {
        return this.q;
    }

    protected boolean a(Message message, int i2) {
        boolean z = true;
        try {
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (message.retryTimes > 3) {
            return false;
        }
        message.retryTimes++;
        message.delyTime = i2;
        ALog.e(d(), "reSend dataid:" + message.dataId + " retryTimes:" + message.retryTimes, new Object[0]);
        b(message, true);
        try {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().take_date = 0L;
                message.getNetPermanceMonitor().to_tnet_date = 0L;
                message.getNetPermanceMonitor().retry_times = message.retryTimes;
                if (message.retryTimes == 1) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            this.f8504e.a(message, -8);
            ALog.e(d(), "reSend error", th, new Object[0]);
            return z;
        }
        return z;
    }

    protected void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            if (AccsClientConfig.mEnv == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (AccsClientConfig.mEnv == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.f8501b).setAppSecret(this.f8508i.getAppSecret()).setAuthCode(this.f8508i.getAuthCode()).setEnv(env).setTag(this.f8508i.getAppKey()).build());
            String str = ConnType.PK_ACS;
            if (this.f8508i.getInappPubKey() == 10 || this.f8508i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "init awcn register new conn protocol host:", this.f8508i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f8508i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    protected void b(int i2) {
        if (i2 < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i2));
            Message message = this.f8511l.get(Integer.valueOf(i2));
            if (message != null) {
                a(message, 5000);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public void c(int i2) {
        n = i2 != 1 ? 0 : 1;
    }

    public String b(String str) {
        String inappHost = this.f8508i.getInappHost();
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.HTTPS_SCHEME);
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(inappHost);
        String string = sb.toString();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DefaultWebClient.HTTPS_SCHEME);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb2.append(str);
            sb2.append(inappHost);
            return sb2.toString();
        } catch (Throwable th) {
            ALog.e("InAppConnection", "getHost", th, new Object[0]);
            return string;
        }
    }

    public void a(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.q) {
            this.q.add(accsConnectStateListener);
        }
    }

    public void b(Message message, int i2) {
        this.f8504e.a(message, i2);
    }

    public void b(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.q) {
            this.q.remove(accsConnectStateListener);
        }
    }
}

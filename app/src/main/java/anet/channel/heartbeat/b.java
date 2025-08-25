package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.d;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class b implements IHeartbeat, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Session f1792a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f1793b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f1794c = false;

    /* renamed from: d, reason: collision with root package name */
    private long f1795d = 0;

    b() {
    }

    private void a(long j2) {
        try {
            this.f1793b = System.currentTimeMillis() + j2;
            ThreadPoolExecutorFactory.submitScheduledTask(this, j2 + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task failed.", this.f1792a.p, e2, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f1793b = System.currentTimeMillis() + this.f1795d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1794c) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.f1793b - 1000) {
            a(this.f1793b - jCurrentTimeMillis);
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            Session session = this.f1792a;
            ALog.e("awcn.DefaultHeartbeatImpl", "close session in background", session.p, d.aw, session);
            this.f1792a.close(false);
        } else {
            if (ALog.isPrintLog(1)) {
                Session session2 = this.f1792a;
                ALog.d("awcn.DefaultHeartbeatImpl", "heartbeat", session2.p, d.aw, session2);
            }
            this.f1792a.ping(true);
            a(this.f1795d);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.f1792a = session;
        this.f1795d = session.getConnStrategy().getHeartbeat();
        if (this.f1795d <= 0) {
            this.f1795d = 45000L;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat start", session.p, d.aw, session, bh.aX, Long.valueOf(this.f1795d));
        a(this.f1795d);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session = this.f1792a;
        if (session == null) {
            return;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat stop", session.p, d.aw, session);
        this.f1794c = true;
    }
}

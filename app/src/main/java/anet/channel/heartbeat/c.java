package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c implements IHeartbeat, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Session f1796a = null;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f1797b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f1798c = System.currentTimeMillis();

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f1798c = System.currentTimeMillis() + 45000;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1797b) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.f1798c - 1000) {
            ThreadPoolExecutorFactory.submitScheduledTask(this, this.f1798c - jCurrentTimeMillis, TimeUnit.MILLISECONDS);
        } else {
            this.f1796a.close(false);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.f1796a = session;
        this.f1798c = System.currentTimeMillis() + 45000;
        ThreadPoolExecutorFactory.submitScheduledTask(this, 45000L, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.f1797b = true;
    }
}

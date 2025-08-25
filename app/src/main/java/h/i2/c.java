package h.i2;

import com.umeng.analytics.AnalyticsConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.m2.f;
import h.n0;
import h.q2.e;
import h.q2.s.l;
import h.y;
import h.y1;
import i.c.a.d;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Timer.kt */
@e(name = "TimersKt")
@y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aJ\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001aL\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aJ\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001aL\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a$\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a0\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a0\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b\u001a8\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\b¨\u0006\u0016"}, d2 = {"fixedRateTimer", "Ljava/util/Timer;", CommonNetImpl.NAME, "", "daemon", "", "startAt", "Ljava/util/Date;", AnalyticsConfig.RTD_PERIOD, "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class c {

    /* compiled from: Timer.kt */
    public static final class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f16231a;

        public a(l lVar) {
            this.f16231a = lVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f16231a.invoke(this);
        }
    }

    @f
    private static final TimerTask a(@d Timer timer, long j2, l<? super TimerTask, y1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, j2);
        return aVar;
    }

    @f
    private static final TimerTask b(@d Timer timer, long j2, long j3, l<? super TimerTask, y1> lVar) {
        a aVar = new a(lVar);
        timer.scheduleAtFixedRate(aVar, j2, j3);
        return aVar;
    }

    @f
    private static final TimerTask a(@d Timer timer, Date date, l<? super TimerTask, y1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, date);
        return aVar;
    }

    @f
    private static final TimerTask b(@d Timer timer, Date date, long j2, l<? super TimerTask, y1> lVar) {
        a aVar = new a(lVar);
        timer.scheduleAtFixedRate(aVar, date, j2);
        return aVar;
    }

    @f
    private static final TimerTask a(@d Timer timer, long j2, long j3, l<? super TimerTask, y1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, j2, j3);
        return aVar;
    }

    @f
    private static final Timer b(String str, boolean z, long j2, long j3, l<? super TimerTask, y1> lVar) {
        Timer timerA = a(str, z);
        timerA.schedule(new a(lVar), j2, j3);
        return timerA;
    }

    @f
    private static final TimerTask a(@d Timer timer, Date date, long j2, l<? super TimerTask, y1> lVar) {
        a aVar = new a(lVar);
        timer.schedule(aVar, date, j2);
        return aVar;
    }

    @f
    private static final Timer b(String str, boolean z, Date date, long j2, l<? super TimerTask, y1> lVar) {
        Timer timerA = a(str, z);
        timerA.schedule(new a(lVar), date, j2);
        return timerA;
    }

    @n0
    @d
    public static final Timer a(@i.c.a.e String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    static /* synthetic */ Timer b(String str, boolean z, long j2, long j3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Timer timerA = a(str, z);
        timerA.schedule(new a(lVar), j2, j3);
        return timerA;
    }

    @f
    private static final Timer a(String str, boolean z, long j2, long j3, l<? super TimerTask, y1> lVar) {
        Timer timerA = a(str, z);
        timerA.scheduleAtFixedRate(new a(lVar), j2, j3);
        return timerA;
    }

    static /* synthetic */ Timer b(String str, boolean z, Date date, long j2, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer timerA = a(str, z);
        timerA.schedule(new a(lVar), date, j2);
        return timerA;
    }

    @f
    private static final Timer a(String str, boolean z, Date date, long j2, l<? super TimerTask, y1> lVar) {
        Timer timerA = a(str, z);
        timerA.scheduleAtFixedRate(new a(lVar), date, j2);
        return timerA;
    }

    @f
    private static final TimerTask a(l<? super TimerTask, y1> lVar) {
        return new a(lVar);
    }

    static /* synthetic */ Timer a(String str, boolean z, long j2, long j3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Timer timerA = a(str, z);
        timerA.scheduleAtFixedRate(new a(lVar), j2, j3);
        return timerA;
    }

    static /* synthetic */ Timer a(String str, boolean z, Date date, long j2, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer timerA = a(str, z);
        timerA.scheduleAtFixedRate(new a(lVar), date, j2);
        return timerA;
    }
}

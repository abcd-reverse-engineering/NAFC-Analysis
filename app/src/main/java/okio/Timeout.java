package okio;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import h.q2.c;
import h.q2.s.a;
import h.q2.t.f0;
import h.q2.t.i0;
import h.q2.t.v;
import h.y;
import h.y1;
import i.c.a.d;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0086\bJ\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "", DispatchConstants.OTHER, "block", "Lkotlin/Function0;", "throwIfReached", "timeout", "waitUntilNotified", Constants.KEY_MONIROT, "Companion", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class Timeout {
    public static final Companion Companion = new Companion(null);

    @c
    @d
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout$Companion$NONE$1
        @Override // okio.Timeout
        @d
        public Timeout deadlineNanoTime(long j2) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() {
        }

        @Override // okio.Timeout
        @d
        public Timeout timeout(long j2, @d TimeUnit timeUnit) {
            i0.f(timeUnit, "unit");
            return this;
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* compiled from: Timeout.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "okio"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final long minTimeout(long j2, long j3) {
            return (j2 != 0 && (j3 == 0 || j2 < j3)) ? j2 : j3;
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }
    }

    @d
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @d
    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @d
    public final Timeout deadline(long j2, @d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        if (j2 > 0) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j2));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j2).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(@d Timeout timeout, @d a<y1> aVar) {
        i0.f(timeout, DispatchConstants.OTHER);
        i0.f(aVar, "block");
        long jTimeoutNanos = timeoutNanos();
        timeout(Companion.minTimeout(timeout.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
        if (!hasDeadline()) {
            if (timeout.hasDeadline()) {
                deadlineNanoTime(timeout.deadlineNanoTime());
            }
            try {
                aVar.invoke();
                return;
            } finally {
                f0.b(1);
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                f0.a(1);
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (timeout.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), timeout.deadlineNanoTime()));
        }
        try {
            aVar.invoke();
        } finally {
            f0.b(1);
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            f0.a(1);
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @d
    public Timeout timeout(long j2, @d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        if (j2 >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j2);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j2).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@d Object obj) throws InterruptedException, InterruptedIOException {
        i0.f(obj, Constants.KEY_MONIROT);
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j2 = jTimeoutNanos / 1000000;
                Long.signum(j2);
                obj.wait(j2, (int) (jTimeoutNanos - (1000000 * j2)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    @d
    public Timeout deadlineNanoTime(long j2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j2;
        return this;
    }
}

package okio;

import h.q2.e;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0001H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u00020\u00018\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0003¨\u0006\u0012"}, d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "clearDeadline", "clearTimeout", "deadlineNanoTime", "", "hasDeadline", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class ForwardingTimeout extends Timeout {

    @d
    private Timeout delegate;

    public ForwardingTimeout(@d Timeout timeout) {
        i0.f(timeout, "delegate");
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    @d
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    @d
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @e(name = "delegate")
    @d
    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    /* renamed from: setDelegate, reason: collision with other method in class */
    public final /* synthetic */ void m801setDelegate(@d Timeout timeout) {
        i0.f(timeout, "<set-?>");
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    @d
    public Timeout timeout(long j2, @d TimeUnit timeUnit) {
        i0.f(timeUnit, "unit");
        return this.delegate.timeout(j2, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    @d
    public Timeout deadlineNanoTime(long j2) {
        return this.delegate.deadlineNanoTime(j2);
    }

    @d
    public final ForwardingTimeout setDelegate(@d Timeout timeout) {
        i0.f(timeout, "delegate");
        this.delegate = timeout;
        return this;
    }
}

package okio;

import androidx.exifinterface.media.ExifInterface;
import h.n0;
import h.q2.s.a;
import h.q2.t.f0;
import h.q2.t.i0;
import h.q2.t.v;
import h.y;
import h.y1;
import i.c.a.d;
import i.c.a.e;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\"\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\b¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* compiled from: AsyncTimeout.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                    if (asyncTimeout2.next == asyncTimeout) {
                        asyncTimeout2.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout asyncTimeout, long j2, boolean z) {
            synchronized (AsyncTimeout.class) {
                if (AsyncTimeout.head == null) {
                    AsyncTimeout.head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long jNanoTime = System.nanoTime();
                if (j2 != 0 && z) {
                    asyncTimeout.timeoutAt = Math.min(j2, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (j2 != 0) {
                    asyncTimeout.timeoutAt = j2 + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                }
                long jRemainingNanos = asyncTimeout.remainingNanos(jNanoTime);
                AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                if (asyncTimeout2 == null) {
                    i0.f();
                }
                while (asyncTimeout2.next != null) {
                    AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                    if (asyncTimeout3 == null) {
                        i0.f();
                    }
                    if (jRemainingNanos < asyncTimeout3.remainingNanos(jNanoTime)) {
                        break;
                    }
                    asyncTimeout2 = asyncTimeout2.next;
                    if (asyncTimeout2 == null) {
                        i0.f();
                    }
                }
                asyncTimeout.next = asyncTimeout2.next;
                asyncTimeout2.next = asyncTimeout;
                if (asyncTimeout2 == AsyncTimeout.head) {
                    AsyncTimeout.class.notify();
                }
                y1 y1Var = y1.f16671a;
            }
        }

        @e
        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            if (asyncTimeout == null) {
                i0.f();
            }
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                if (asyncTimeout3 == null) {
                    i0.f();
                }
                if (asyncTimeout3.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jRemainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                long j2 = jRemainingNanos / 1000000;
                AsyncTimeout.class.wait(j2, (int) (jRemainingNanos - (1000000 * j2)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            if (asyncTimeout4 == null) {
                i0.f();
            }
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }
    }

    /* compiled from: AsyncTimeout.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k = 1, mv = {1, 1, 16})
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout asyncTimeoutAwaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        asyncTimeoutAwaitTimeout$okio = AsyncTimeout.Companion.awaitTimeout$okio();
                        if (asyncTimeoutAwaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        y1 y1Var = y1.f16671a;
                    }
                    if (asyncTimeoutAwaitTimeout$okio != null) {
                        asyncTimeoutAwaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j2) {
        return this.timeoutAt - j2;
    }

    @n0
    @d
    public final IOException access$newTimeoutException(@e IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        if (!(!this.inQueue)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            Companion.scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return Companion.cancelScheduledTimeout(this);
    }

    @d
    protected IOException newTimeoutException(@e IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @d
    public final Sink sink(@d final Sink sink) {
        i0.f(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout.sink.1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    sink.close();
                    y1 y1Var = y1.f16671a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.exit()) {
                        throw e2;
                    }
                    throw asyncTimeout.access$newTimeoutException(e2);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    sink.flush();
                    y1 y1Var = y1.f16671a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.exit()) {
                        throw e2;
                    }
                    throw asyncTimeout.access$newTimeoutException(e2);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @d
            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(@d Buffer buffer, long j2) throws IOException {
                i0.f(buffer, "source");
                Util.checkOffsetAndCount(buffer.size(), 0L, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    Segment segment = buffer.head;
                    if (segment == null) {
                        i0.f();
                    }
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += segment.limit - segment.pos;
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        } else {
                            segment = segment.next;
                            if (segment == null) {
                                i0.f();
                            }
                        }
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    asyncTimeout.enter();
                    try {
                        sink.write(buffer, j3);
                        y1 y1Var = y1.f16671a;
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                        j2 -= j3;
                    } catch (IOException e2) {
                        if (!asyncTimeout.exit()) {
                            throw e2;
                        }
                        throw asyncTimeout.access$newTimeoutException(e2);
                    } finally {
                        asyncTimeout.exit();
                    }
                }
            }

            @Override // okio.Sink
            @d
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    @d
    public final Source source(@d final Source source) {
        i0.f(source, "source");
        return new Source() { // from class: okio.AsyncTimeout.source.1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    source.close();
                    y1 y1Var = y1.f16671a;
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!asyncTimeout.exit()) {
                        throw e2;
                    }
                    throw asyncTimeout.access$newTimeoutException(e2);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(@d Buffer buffer, long j2) throws IOException {
                i0.f(buffer, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                asyncTimeout.enter();
                try {
                    long j3 = source.read(buffer, j2);
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                    return j3;
                } catch (IOException e2) {
                    if (asyncTimeout.exit()) {
                        throw asyncTimeout.access$newTimeoutException(e2);
                    }
                    throw e2;
                } finally {
                    asyncTimeout.exit();
                }
            }

            @d
            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }

            @Override // okio.Source
            @d
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    protected void timedOut() {
    }

    public final <T> T withTimeout(@d a<? extends T> aVar) throws IOException {
        i0.f(aVar, "block");
        enter();
        try {
            try {
                T tInvoke = aVar.invoke();
                f0.b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                f0.a(1);
                return tInvoke;
            } catch (IOException e2) {
                if (exit()) {
                    throw access$newTimeoutException(e2);
                }
                throw e2;
            }
        } catch (Throwable th) {
            f0.b(1);
            exit();
            f0.a(1);
            throw th;
        }
    }
}

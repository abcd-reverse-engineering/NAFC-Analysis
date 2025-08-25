package okio;

import h.c;
import h.o0;
import h.q2.e;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.IOException;

/* compiled from: ForwardingSink.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0012"}, d2 = {"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "(Lokio/Sink;)V", "()Lokio/Sink;", "close", "", "-deprecated_delegate", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public abstract class ForwardingSink implements Sink {

    @d
    private final Sink delegate;

    public ForwardingSink(@d Sink sink) {
        i0.f(sink, "delegate");
        this.delegate = sink;
    }

    @e(name = "-deprecated_delegate")
    @c(level = h.d.ERROR, message = "moved to val", replaceWith = @o0(expression = "delegate", imports = {}))
    @d
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Sink m799deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @e(name = "delegate")
    @d
    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    @d
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @d
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // okio.Sink
    public void write(@d Buffer buffer, long j2) throws IOException {
        i0.f(buffer, "source");
        this.delegate.write(buffer, j2);
    }
}

package okio;

import h.c;
import h.o0;
import h.q2.e;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.IOException;

/* compiled from: ForwardingSource.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0011"}, d2 = {"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "(Lokio/Source;)V", "()Lokio/Source;", "close", "", "-deprecated_delegate", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "toString", "", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {

    @d
    private final Source delegate;

    public ForwardingSource(@d Source source) {
        i0.f(source, "delegate");
        this.delegate = source;
    }

    @e(name = "-deprecated_delegate")
    @c(level = h.d.ERROR, message = "moved to val", replaceWith = @o0(expression = "delegate", imports = {}))
    @d
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m800deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @e(name = "delegate")
    @d
    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(@d Buffer buffer, long j2) throws IOException {
        i0.f(buffer, "sink");
        return this.delegate.read(buffer, j2);
    }

    @Override // okio.Source
    @d
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @d
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}

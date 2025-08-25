package okio;

import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: JvmOkio.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "close", "", "flush", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(@d OutputStream outputStream, @d Timeout timeout) {
        i0.f(outputStream, "out");
        i0.f(timeout, "timeout");
        this.out = outputStream;
        this.timeout = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // okio.Sink
    @d
    public Timeout timeout() {
        return this.timeout;
    }

    @d
    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // okio.Sink
    public void write(@d Buffer buffer, long j2) throws IOException {
        i0.f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0L, j2);
        while (j2 > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            if (segment == null) {
                i0.f();
            }
            int iMin = (int) Math.min(j2, segment.limit - segment.pos);
            this.out.write(segment.data, segment.pos, iMin);
            segment.pos += iMin;
            long j3 = iMin;
            j2 -= j3;
            buffer.setSize$okio(buffer.size() - j3);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }
}

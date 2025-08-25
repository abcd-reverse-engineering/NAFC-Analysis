package okio;

import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: JvmOkio.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(@d InputStream inputStream, @d Timeout timeout) {
        i0.f(inputStream, "input");
        i0.f(timeout, "timeout");
        this.input = inputStream;
        this.timeout = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // okio.Source
    public long read(@d Buffer buffer, long j2) throws IOException {
        i0.f(buffer, "sink");
        if (j2 == 0) {
            return 0L;
        }
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        try {
            this.timeout.throwIfReached();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int i2 = this.input.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j2, 8192 - segmentWritableSegment$okio.limit));
            if (i2 != -1) {
                segmentWritableSegment$okio.limit += i2;
                long j3 = i2;
                buffer.setSize$okio(buffer.size() + j3);
                return j3;
            }
            if (segmentWritableSegment$okio.pos != segmentWritableSegment$okio.limit) {
                return -1L;
            }
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.INSTANCE.recycle(segmentWritableSegment$okio);
            return -1L;
        } catch (AssertionError e2) {
            if (Okio.isAndroidGetsocknameError(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    @Override // okio.Source
    @d
    public Timeout timeout() {
        return this.timeout;
    }

    @d
    public String toString() {
        return "source(" + this.input + ')';
    }
}

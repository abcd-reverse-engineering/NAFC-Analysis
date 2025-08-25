package okio;

import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "refill", "releaseInflatedBytes", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(@d BufferedSource bufferedSource, @d Inflater inflater) {
        i0.f(bufferedSource, "source");
        i0.f(inflater, "inflater");
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    private final void releaseInflatedBytes() throws IOException {
        int i2 = this.bufferBytesHeldByInflater;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(@d Buffer buffer, long j2) throws DataFormatException, IOException {
        boolean zRefill;
        i0.f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        do {
            zRefill = refill();
            try {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                int iInflate = this.inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j2, 8192 - segmentWritableSegment$okio.limit));
                if (iInflate > 0) {
                    segmentWritableSegment$okio.limit += iInflate;
                    long j3 = iInflate;
                    buffer.setSize$okio(buffer.size() + j3);
                    return j3;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (segmentWritableSegment$okio.pos != segmentWritableSegment$okio.limit) {
                    return -1L;
                }
                buffer.head = segmentWritableSegment$okio.pop();
                SegmentPool.INSTANCE.recycle(segmentWritableSegment$okio);
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!zRefill);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (!(this.inflater.getRemaining() == 0)) {
            throw new IllegalStateException("?".toString());
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        if (segment == null) {
            i0.f();
        }
        int i2 = segment.limit;
        int i3 = segment.pos;
        this.bufferBytesHeldByInflater = i2 - i3;
        this.inflater.setInput(segment.data, i3, this.bufferBytesHeldByInflater);
        return false;
    }

    @Override // okio.Source
    @d
    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(@d Source source, @d Inflater inflater) {
        this(Okio.buffer(source), inflater);
        i0.f(source, "source");
        i0.f(inflater, "inflater");
    }
}

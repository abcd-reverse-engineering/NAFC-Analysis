package okio.internal;

import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: RealBufferedSink.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0080\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0080\b¨\u0006*"}, d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", bh.aF, "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", bh.aE, "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RealBufferedSinkKt {
    public static final void commonClose(@d RealBufferedSink realBufferedSink) throws Throwable {
        i0.f(realBufferedSink, "$this$commonClose");
        if (realBufferedSink.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (realBufferedSink.bufferField.size() > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            realBufferedSink.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        realBufferedSink.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @d
    public static final BufferedSink commonEmit(@d RealBufferedSink realBufferedSink) throws IOException {
        i0.f(realBufferedSink, "$this$commonEmit");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = realBufferedSink.bufferField.size();
        if (size > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, size);
        }
        return realBufferedSink;
    }

    @d
    public static final BufferedSink commonEmitCompleteSegments(@d RealBufferedSink realBufferedSink) throws IOException {
        i0.f(realBufferedSink, "$this$commonEmitCompleteSegments");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long jCompleteSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, jCompleteSegmentByteCount);
        }
        return realBufferedSink;
    }

    public static final void commonFlush(@d RealBufferedSink realBufferedSink) throws IOException {
        i0.f(realBufferedSink, "$this$commonFlush");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSink.bufferField.size() > 0) {
            Sink sink = realBufferedSink.sink;
            Buffer buffer = realBufferedSink.bufferField;
            sink.write(buffer, buffer.size());
        }
        realBufferedSink.sink.flush();
    }

    @d
    public static final Timeout commonTimeout(@d RealBufferedSink realBufferedSink) {
        i0.f(realBufferedSink, "$this$commonTimeout");
        return realBufferedSink.sink.timeout();
    }

    @d
    public static final String commonToString(@d RealBufferedSink realBufferedSink) {
        i0.f(realBufferedSink, "$this$commonToString");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final void commonWrite(@d RealBufferedSink realBufferedSink, @d Buffer buffer, long j2) throws IOException {
        i0.f(realBufferedSink, "$this$commonWrite");
        i0.f(buffer, "source");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(buffer, j2);
        realBufferedSink.emitCompleteSegments();
    }

    public static final long commonWriteAll(@d RealBufferedSink realBufferedSink, @d Source source) throws IOException {
        i0.f(realBufferedSink, "$this$commonWriteAll");
        i0.f(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(realBufferedSink.bufferField, 8192);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
            realBufferedSink.emitCompleteSegments();
        }
    }

    @d
    public static final BufferedSink commonWriteByte(@d RealBufferedSink realBufferedSink, int i2) {
        i0.f(realBufferedSink, "$this$commonWriteByte");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeByte(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteDecimalLong(@d RealBufferedSink realBufferedSink, long j2) {
        i0.f(realBufferedSink, "$this$commonWriteDecimalLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeDecimalLong(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@d RealBufferedSink realBufferedSink, long j2) {
        i0.f(realBufferedSink, "$this$commonWriteHexadecimalUnsignedLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteInt(@d RealBufferedSink realBufferedSink, int i2) {
        i0.f(realBufferedSink, "$this$commonWriteInt");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeInt(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteIntLe(@d RealBufferedSink realBufferedSink, int i2) {
        i0.f(realBufferedSink, "$this$commonWriteIntLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeIntLe(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteLong(@d RealBufferedSink realBufferedSink, long j2) {
        i0.f(realBufferedSink, "$this$commonWriteLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLong(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteLongLe(@d RealBufferedSink realBufferedSink, long j2) {
        i0.f(realBufferedSink, "$this$commonWriteLongLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLongLe(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteShort(@d RealBufferedSink realBufferedSink, int i2) {
        i0.f(realBufferedSink, "$this$commonWriteShort");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShort(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteShortLe(@d RealBufferedSink realBufferedSink, int i2) {
        i0.f(realBufferedSink, "$this$commonWriteShortLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShortLe(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteUtf8(@d RealBufferedSink realBufferedSink, @d String str) {
        i0.f(realBufferedSink, "$this$commonWriteUtf8");
        i0.f(str, "string");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8(str);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWriteUtf8CodePoint(@d RealBufferedSink realBufferedSink, int i2) {
        i0.f(realBufferedSink, "$this$commonWriteUtf8CodePoint");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8CodePoint(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @d
    public static final BufferedSink commonWrite(@d RealBufferedSink realBufferedSink, @d ByteString byteString) {
        i0.f(realBufferedSink, "$this$commonWrite");
        i0.f(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @d
    public static final BufferedSink commonWriteUtf8(@d RealBufferedSink realBufferedSink, @d String str, int i2, int i3) {
        i0.f(realBufferedSink, "$this$commonWriteUtf8");
        i0.f(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i2, i3);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @d
    public static final BufferedSink commonWrite(@d RealBufferedSink realBufferedSink, @d ByteString byteString, int i2, int i3) {
        i0.f(realBufferedSink, "$this$commonWrite");
        i0.f(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i2, i3);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @d
    public static final BufferedSink commonWrite(@d RealBufferedSink realBufferedSink, @d byte[] bArr) {
        i0.f(realBufferedSink, "$this$commonWrite");
        i0.f(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @d
    public static final BufferedSink commonWrite(@d RealBufferedSink realBufferedSink, @d byte[] bArr, int i2, int i3) {
        i0.f(realBufferedSink, "$this$commonWrite");
        i0.f(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i2, i3);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @d
    public static final BufferedSink commonWrite(@d RealBufferedSink realBufferedSink, @d Source source, long j2) throws IOException {
        i0.f(realBufferedSink, "$this$commonWrite");
        i0.f(source, "source");
        while (j2 > 0) {
            long j3 = source.read(realBufferedSink.bufferField, j2);
            if (j3 != -1) {
                j2 -= j3;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}

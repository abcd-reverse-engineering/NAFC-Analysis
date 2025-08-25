package okio;

import com.umeng.analytics.pro.bh;
import h.q2.c;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSink.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001eH\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0018\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u000206H\u0016J(\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0019H\u0016J \u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0016J\u0010\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "emit", "emitCompleteSegments", "flush", "isOpen", "outputStream", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "toString", "", "write", "", "source", "Ljava/nio/ByteBuffer;", "", "offset", "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", bh.aF, "writeIntLe", "writeLong", "writeLongLe", "writeShort", bh.aE, "writeShortLe", "writeString", "string", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RealBufferedSink implements BufferedSink {

    @c
    @d
    public final Buffer bufferField;

    @c
    public boolean closed;

    @c
    @d
    public final Sink sink;

    public RealBufferedSink(@d Sink sink) {
        i0.f(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void buffer$annotations() {
    }

    @Override // okio.BufferedSink
    @d
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (this.bufferField.size() > 0) {
                this.sink.write(this.bufferField, this.bufferField.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink emit() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = this.bufferField.size();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink emitCompleteSegments() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.bufferField, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    @Override // okio.BufferedSink
    @d
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    @d
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.RealBufferedSink.outputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws Throwable {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            @d
            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i2) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.bufferField.writeByte((int) ((byte) i2));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(@d byte[] bArr, int i2, int i3) throws IOException {
                i0.f(bArr, "data");
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.write(bArr, i2, i3);
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Sink
    @d
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @d
    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@d ByteBuffer byteBuffer) throws IOException {
        i0.f(byteBuffer, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.bufferField.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public long writeAll(@d Source source) throws IOException {
        i0.f(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(this.bufferField, 8192);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeByte(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeByte(i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeDecimalLong(long j2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeDecimalLong(j2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeHexadecimalUnsignedLong(long j2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeHexadecimalUnsignedLong(j2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeInt(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeInt(i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeIntLe(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeIntLe(i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeLong(long j2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLong(j2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeLongLe(long j2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeLongLe(j2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeShort(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShort(i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeShortLe(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShortLe(i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeString(@d String str, @d Charset charset) {
        i0.f(str, "string");
        i0.f(charset, "charset");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeUtf8(@d String str) {
        i0.f(str, "string");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeUtf8CodePoint(int i2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8CodePoint(i2);
        return emitCompleteSegments();
    }

    @Override // okio.Sink
    public void write(@d Buffer buffer, long j2) throws IOException {
        i0.f(buffer, "source");
        if (!this.closed) {
            this.bufferField.write(buffer, j2);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeString(@d String str, int i2, int i3, @d Charset charset) {
        i0.f(str, "string");
        i0.f(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, i2, i3, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink writeUtf8(@d String str, int i2, int i3) {
        i0.f(str, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(str, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink write(@d ByteString byteString) {
        i0.f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink write(@d ByteString byteString, int i2, int i3) {
        i0.f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink write(@d byte[] bArr) {
        i0.f(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink write(@d byte[] bArr, int i2, int i3) {
        i0.f(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @d
    public BufferedSink write(@d Source source, long j2) throws IOException {
        i0.f(source, "source");
        while (j2 > 0) {
            long j3 = source.read(this.bufferField, j2);
            if (j3 != -1) {
                j2 -= j3;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}

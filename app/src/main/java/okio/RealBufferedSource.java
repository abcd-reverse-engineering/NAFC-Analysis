package okio;

import com.tencent.open.SocialConstants;
import h.f1;
import h.q2.c;
import h.q2.t.i0;
import h.q2.t.m0;
import h.y;
import i.c.a.d;
import i.c.a.e;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.internal.BufferKt;

/* compiled from: RealBufferedSource.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", SocialConstants.TYPE_REQUEST, "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RealBufferedSource implements BufferedSource {

    @c
    @d
    public final Buffer bufferField;

    @c
    public boolean closed;

    @c
    @d
    public final Source source;

    public RealBufferedSource(@d Source source) {
        i0.f(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void buffer$annotations() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @d
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (!this.closed) {
            return this.bufferField.exhausted() && this.source.read(this.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @d
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, m0.f16408b);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@d ByteString byteString) {
        i0.f(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    @d
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource.inputStream.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.bufferField.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                if (realBufferedSource.bufferField.size() == 0) {
                    RealBufferedSource realBufferedSource2 = RealBufferedSource.this;
                    if (realBufferedSource2.source.read(realBufferedSource2.bufferField, 8192) == -1) {
                        return -1;
                    }
                }
                return RealBufferedSource.this.bufferField.readByte() & f1.f16099c;
            }

            @d
            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@d byte[] bArr, int i2, int i3) throws IOException {
                i0.f(bArr, "data");
                if (!RealBufferedSource.this.closed) {
                    Util.checkOffsetAndCount(bArr.length, i2, i3);
                    if (RealBufferedSource.this.bufferField.size() == 0) {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                            return -1;
                        }
                    }
                    return RealBufferedSource.this.bufferField.read(bArr, i2, i3);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    @d
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, @d ByteString byteString) {
        i0.f(byteString, "bytes");
        return rangeEquals(j2, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public int read(@d byte[] bArr) {
        i0.f(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public long readAll(@d Sink sink) throws IOException {
        i0.f(sink, "sink");
        long j2 = 0;
        while (this.source.read(this.bufferField, 8192) != -1) {
            long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j2 += jCompleteSegmentByteCount;
                sink.write(this.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j2;
        }
        long size = j2 + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    @d
    public byte[] readByteArray() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    @d
    public ByteString readByteString() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        byte b2;
        require(1L);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!request(j3)) {
                break;
            }
            b2 = this.bufferField.getByte(j2);
            if ((b2 < ((byte) 48) || b2 > ((byte) 57)) && !(j2 == 0 && b2 == ((byte) 45))) {
                break;
            }
            j2 = j3;
        }
        if (j2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9] or '-' character but was 0x");
            String string = Integer.toString(b2, h.z2.d.a(h.z2.d.a(16)));
            i0.a((Object) string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(@d byte[] bArr) throws EOFException {
        i0.f(bArr, "sink");
        try {
            require(bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int i3 = buffer.read(bArr, i2, (int) buffer.size());
                if (i3 == -1) {
                    throw new AssertionError();
                }
                i2 += i3;
            }
            throw e2;
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        byte b2;
        require(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request(i3)) {
                break;
            }
            b2 = this.bufferField.getByte(i2);
            if ((b2 < ((byte) 48) || b2 > ((byte) 57)) && ((b2 < ((byte) 97) || b2 > ((byte) 102)) && (b2 < ((byte) 65) || b2 > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(b2, h.z2.d.a(h.z2.d.a(16)));
            i0.a((Object) string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    @d
    public String readString(long j2, @d Charset charset) throws EOFException {
        i0.f(charset, "charset");
        require(j2);
        return this.bufferField.readString(j2, charset);
    }

    @Override // okio.BufferedSource
    @d
    public String readUtf8() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        require(1L);
        byte b2 = this.bufferField.getByte(0L);
        if ((b2 & 224) == 192) {
            require(2L);
        } else if ((b2 & 240) == 224) {
            require(3L);
        } else if ((b2 & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    @e
    public String readUtf8Line() {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @d
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(m0.f16408b);
    }

    @Override // okio.BufferedSource
    public boolean request(long j2) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.size() < j2) {
            if (this.source.read(this.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void require(long j2) throws EOFException {
        if (!request(j2)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@d Options options) throws EOFException {
        i0.f(options, "options");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iSelectPrefix = BufferKt.selectPrefix(this.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                this.bufferField.skip(options.getByteStrings$okio()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (this.source.read(this.bufferField, 8192) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    public void skip(long j2) throws EOFException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, this.bufferField.size());
            this.bufferField.skip(jMin);
            j2 -= jMin;
        }
    }

    @Override // okio.Source
    @d
    public Timeout timeout() {
        return this.source.timeout();
    }

    @d
    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2) {
        return indexOf(b2, j2, m0.f16408b);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@d ByteString byteString, long j2) {
        i0.f(byteString, "targetBytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = this.bufferField.indexOfElement(byteString, j2);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
    }

    @Override // okio.Source
    public long read(@d Buffer buffer, long j2) {
        i0.f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(true ^ this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1L;
        }
        return this.bufferField.read(buffer, Math.min(j2, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    @d
    public String readUtf8LineStrict(long j2) throws EOFException {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = j2 == m0.f16408b ? Long.MAX_VALUE : j2 + 1;
        byte b2 = (byte) 10;
        long jIndexOf = indexOf(b2, 0L, j3);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (j3 < m0.f16408b && request(j3) && this.bufferField.getByte(j3 - 1) == ((byte) 13) && request(1 + j3) && this.bufferField.getByte(j3) == b2) {
            return BufferKt.readUtf8Line(this.bufferField, j3);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j2) + " content=" + buffer.readByteString().hex() + "…");
    }

    @Override // okio.BufferedSource
    public long indexOf(@d ByteString byteString) {
        i0.f(byteString, "bytes");
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, @d ByteString byteString, int i2, int i3) {
        i0.f(byteString, "bytes");
        if (!this.closed) {
            if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = i4 + j2;
                if (!request(1 + j3) || this.bufferField.getByte(j3) != byteString.getByte(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2, long j3) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        while (j2 < j3) {
            long jIndexOf = this.bufferField.indexOf(b2, j2, j3);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (size >= j3 || this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    @d
    public String readString(@d Charset charset) throws IOException {
        i0.f(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    @d
    public byte[] readByteArray(long j2) throws EOFException {
        require(j2);
        return this.bufferField.readByteArray(j2);
    }

    @Override // okio.BufferedSource
    @d
    public ByteString readByteString(long j2) throws EOFException {
        require(j2);
        return this.bufferField.readByteString(j2);
    }

    @Override // okio.BufferedSource
    @d
    public String readUtf8(long j2) throws EOFException {
        require(j2);
        return this.bufferField.readUtf8(j2);
    }

    @Override // okio.BufferedSource
    public void readFully(@d Buffer buffer, long j2) throws IOException {
        i0.f(buffer, "sink");
        try {
            require(j2);
            this.bufferField.readFully(buffer, j2);
        } catch (EOFException e2) {
            buffer.writeAll(this.bufferField);
            throw e2;
        }
    }

    @Override // okio.BufferedSource
    public int read(@d byte[] bArr, int i2, int i3) {
        i0.f(bArr, "sink");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i2, (int) Math.min(j2, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    public long indexOf(@d ByteString byteString, long j2) throws IOException {
        i0.f(byteString, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = this.bufferField.indexOf(byteString, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (size - byteString.size()) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@d ByteBuffer byteBuffer) {
        i0.f(byteBuffer, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(byteBuffer);
    }
}

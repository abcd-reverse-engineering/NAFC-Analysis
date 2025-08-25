package okio;

import com.umeng.analytics.pro.bh;
import h.c;
import h.d;
import h.o0;
import h.y;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSink.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0000H&J\b\u0010\b\u001a\u00020\u0000H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&J \u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010\r\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0011H&J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011H&J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011H&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0011H&J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0011H&J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&J(\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)H&J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'H&J \u0010,\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H&J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0011H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006/"}, d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "emit", "emitCompleteSegments", "flush", "", "outputStream", "Ljava/io/OutputStream;", "write", "source", "", "offset", "", "byteCount", "byteString", "Lokio/ByteString;", "Lokio/Source;", "", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", bh.aF, "writeIntLe", "writeLong", "writeLongLe", "writeShort", bh.aE, "writeShortLe", "writeString", "string", "", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @c(level = d.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @o0(expression = "buffer", imports = {}))
    @i.c.a.d
    Buffer buffer();

    @i.c.a.d
    BufferedSink emit() throws IOException;

    @i.c.a.d
    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    @i.c.a.d
    Buffer getBuffer();

    @i.c.a.d
    OutputStream outputStream();

    @i.c.a.d
    BufferedSink write(@i.c.a.d ByteString byteString) throws IOException;

    @i.c.a.d
    BufferedSink write(@i.c.a.d ByteString byteString, int i2, int i3) throws IOException;

    @i.c.a.d
    BufferedSink write(@i.c.a.d Source source, long j2) throws IOException;

    @i.c.a.d
    BufferedSink write(@i.c.a.d byte[] bArr) throws IOException;

    @i.c.a.d
    BufferedSink write(@i.c.a.d byte[] bArr, int i2, int i3) throws IOException;

    long writeAll(@i.c.a.d Source source) throws IOException;

    @i.c.a.d
    BufferedSink writeByte(int i2) throws IOException;

    @i.c.a.d
    BufferedSink writeDecimalLong(long j2) throws IOException;

    @i.c.a.d
    BufferedSink writeHexadecimalUnsignedLong(long j2) throws IOException;

    @i.c.a.d
    BufferedSink writeInt(int i2) throws IOException;

    @i.c.a.d
    BufferedSink writeIntLe(int i2) throws IOException;

    @i.c.a.d
    BufferedSink writeLong(long j2) throws IOException;

    @i.c.a.d
    BufferedSink writeLongLe(long j2) throws IOException;

    @i.c.a.d
    BufferedSink writeShort(int i2) throws IOException;

    @i.c.a.d
    BufferedSink writeShortLe(int i2) throws IOException;

    @i.c.a.d
    BufferedSink writeString(@i.c.a.d String str, int i2, int i3, @i.c.a.d Charset charset) throws IOException;

    @i.c.a.d
    BufferedSink writeString(@i.c.a.d String str, @i.c.a.d Charset charset) throws IOException;

    @i.c.a.d
    BufferedSink writeUtf8(@i.c.a.d String str) throws IOException;

    @i.c.a.d
    BufferedSink writeUtf8(@i.c.a.d String str, int i2, int i3) throws IOException;

    @i.c.a.d
    BufferedSink writeUtf8CodePoint(int i2) throws IOException;
}

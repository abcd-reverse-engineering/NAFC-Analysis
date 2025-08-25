package okio;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.heytap.mcssdk.constant.a;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.cw;
import h.d;
import h.e1;
import h.f1;
import h.g2.q;
import h.o0;
import h.q2.c;
import h.q2.f;
import h.q2.t.i0;
import h.q2.t.m0;
import h.q2.t.m1;
import h.q2.t.n;
import h.y;
import h.z2.h0;
import i.c.a.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.internal.BufferKt;

/* compiled from: Buffer.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0090\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u007f\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0016J$\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0091\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", DispatchConstants.OTHER, "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", SocialConstants.TYPE_REQUEST, "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", bh.aF, "writeIntLe", "writeLong", "writeLongLe", "writeShort", bh.aE, "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @c
    @e
    public Segment head;
    private long size;

    /* compiled from: Buffer.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k = 1, mv = {1, 1, 16})
    public static final class UnsafeCursor implements Closeable {

        @c
        @e
        public Buffer buffer;

        @c
        @e
        public byte[] data;

        @c
        public boolean readWrite;
        private Segment segment;

        @c
        public long offset = -1;

        @c
        public int start = -1;

        @c
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i2) {
            if (!(i2 > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i2).toString());
            }
            if (!(i2 <= 8192)) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i2).toString());
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
            int i3 = 8192 - segmentWritableSegment$okio.limit;
            segmentWritableSegment$okio.limit = 8192;
            long j2 = i3;
            buffer.setSize$okio(size + j2);
            this.segment = segmentWritableSegment$okio;
            this.offset = size;
            this.data = segmentWritableSegment$okio.data;
            this.start = 8192 - i3;
            this.end = 8192;
            return j2;
        }

        public final int next() {
            long j2 = this.offset;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                i0.f();
            }
            if (!(j2 != buffer.size())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j3 = this.offset;
            return seek(j3 == -1 ? 0L : j3 + (this.end - this.start));
        }

        public final long resizeBuffer(long j2) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long size = buffer.size();
            int i2 = 1;
            if (j2 <= size) {
                if (!(j2 >= 0)) {
                    throw new IllegalArgumentException(("newSize < 0: " + j2).toString());
                }
                long j3 = size - j2;
                while (true) {
                    if (j3 > 0) {
                        Segment segment = buffer.head;
                        if (segment == null) {
                            i0.f();
                        }
                        Segment segment2 = segment.prev;
                        if (segment2 == null) {
                            i0.f();
                        }
                        int i3 = segment2.limit;
                        long j4 = i3 - segment2.pos;
                        if (j4 > j3) {
                            segment2.limit = i3 - ((int) j3);
                            break;
                        }
                        buffer.head = segment2.pop();
                        SegmentPool.INSTANCE.recycle(segment2);
                        j3 -= j4;
                    } else {
                        break;
                    }
                }
                this.segment = null;
                this.offset = j2;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j2 > size) {
                long j5 = j2 - size;
                boolean z = true;
                while (j5 > 0) {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
                    int iMin = (int) Math.min(j5, 8192 - segmentWritableSegment$okio.limit);
                    segmentWritableSegment$okio.limit += iMin;
                    j5 -= iMin;
                    if (z) {
                        this.segment = segmentWritableSegment$okio;
                        this.offset = size;
                        this.data = segmentWritableSegment$okio.data;
                        int i4 = segmentWritableSegment$okio.limit;
                        this.start = i4 - iMin;
                        this.end = i4;
                        z = false;
                    }
                    i2 = 1;
                }
            }
            buffer.setSize$okio(j2);
            return size;
        }

        public final int seek(long j2) {
            Segment segmentPush;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j2 < -1 || j2 > buffer.size()) {
                m1 m1Var = m1.f16412a;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(buffer.size())};
                String str = String.format("offset=%s > size=%s", Arrays.copyOf(objArr, objArr.length));
                i0.a((Object) str, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(str);
            }
            if (j2 == -1 || j2 == buffer.size()) {
                this.segment = null;
                this.offset = j2;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long j3 = 0;
            long size = buffer.size();
            Segment segment = buffer.head;
            Segment segment2 = this.segment;
            if (segment2 != null) {
                long j4 = this.offset;
                int i2 = this.start;
                if (segment2 == null) {
                    i0.f();
                }
                long j5 = j4 - (i2 - segment2.pos);
                if (j5 > j2) {
                    segment = this.segment;
                    size = j5;
                    segmentPush = segment;
                } else {
                    segmentPush = this.segment;
                    j3 = j5;
                }
            } else {
                segmentPush = segment;
            }
            if (size - j2 > j2 - j3) {
                while (true) {
                    if (segmentPush == null) {
                        i0.f();
                    }
                    int i3 = segmentPush.limit;
                    int i4 = segmentPush.pos;
                    if (j2 < (i3 - i4) + j3) {
                        break;
                    }
                    j3 += i3 - i4;
                    segmentPush = segmentPush.next;
                }
            } else {
                j3 = size;
                segmentPush = segment;
                while (j3 > j2) {
                    if (segmentPush == null) {
                        i0.f();
                    }
                    segmentPush = segmentPush.prev;
                    if (segmentPush == null) {
                        i0.f();
                    }
                    j3 -= segmentPush.limit - segmentPush.pos;
                }
            }
            if (this.readWrite) {
                if (segmentPush == null) {
                    i0.f();
                }
                if (segmentPush.shared) {
                    Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                    if (buffer.head == segmentPush) {
                        buffer.head = segmentUnsharedCopy;
                    }
                    segmentPush = segmentPush.push(segmentUnsharedCopy);
                    Segment segment3 = segmentPush.prev;
                    if (segment3 == null) {
                        i0.f();
                    }
                    segment3.pop();
                }
            }
            this.segment = segmentPush;
            this.offset = j2;
            if (segmentPush == null) {
                i0.f();
            }
            this.data = segmentPush.data;
            this.start = segmentPush.pos + ((int) (j2 - j3));
            this.end = segmentPush.limit;
            return this.end - this.start;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j2, long j3, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            j3 = buffer.size - j4;
        }
        return buffer.copyTo(outputStream, j4, j3);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return buffer.copyTo(buffer2, j2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return buffer.copyTo(buffer2, j2, j3);
    }

    private final ByteString digest(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            messageDigest.update(bArr, i2, segment.limit - i2);
            Segment segment2 = segment.next;
            if (segment2 == null) {
                i0.f();
            }
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i3 = segment2.pos;
                messageDigest.update(bArr2, i3, segment2.limit - i3);
                segment2 = segment2.next;
                if (segment2 == null) {
                    i0.f();
                }
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        i0.a((Object) bArrDigest, "messageDigest.digest()");
        return new ByteString(bArrDigest);
    }

    private final ByteString hmac(String str, ByteString byteString) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                Segment segment2 = segment.next;
                if (segment2 == null) {
                    i0.f();
                }
                while (segment2 != segment) {
                    mac.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    if (segment2 == null) {
                        i0.f();
                    }
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            i0.a((Object) bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = buffer.size;
        }
        return buffer.writeTo(outputStream, j2);
    }

    @h.q2.e(name = "-deprecated_getByte")
    @h.c(level = d.ERROR, message = "moved to operator function", replaceWith = @o0(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m787deprecated_getByte(long j2) {
        return getByte(j2);
    }

    @h.q2.e(name = "-deprecated_size")
    @h.c(level = d.ERROR, message = "moved to val", replaceWith = @o0(expression = "size", imports = {}))
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final long m788deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @i.c.a.d
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        if (segment == null) {
            i0.f();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            i0.f();
        }
        if (segment2.limit < 8192 && segment2.owner) {
            size -= r3 - segment2.pos;
        }
        return size;
    }

    @i.c.a.d
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            if (segment == null) {
                i0.f();
            }
            Segment segmentSharedCopy = segment.sharedCopy();
            buffer.head = segmentSharedCopy;
            segmentSharedCopy.prev = buffer.head;
            segmentSharedCopy.next = segmentSharedCopy.prev;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = segmentSharedCopy.prev;
                if (segment3 == null) {
                    i0.f();
                }
                if (segment2 == null) {
                    i0.f();
                }
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @f
    @i.c.a.d
    public final Buffer copyTo(@i.c.a.d OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    @f
    @i.c.a.d
    public final Buffer copyTo(@i.c.a.d OutputStream outputStream, long j2) throws IOException {
        return copyTo$default(this, outputStream, j2, 0L, 4, (Object) null);
    }

    @f
    @i.c.a.d
    public final Buffer copyTo(@i.c.a.d OutputStream outputStream, long j2, long j3) throws IOException {
        i0.f(outputStream, "out");
        Util.checkOffsetAndCount(this.size, j2, j3);
        if (j3 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            if (segment == null) {
                i0.f();
            }
            int i2 = segment.limit;
            int i3 = segment.pos;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= i2 - i3;
            segment = segment.next;
        }
        while (j3 > 0) {
            if (segment == null) {
                i0.f();
            }
            int iMin = (int) Math.min(segment.limit - r10, j3);
            outputStream.write(segment.data, (int) (segment.pos + j2), iMin);
            j3 -= iMin;
            segment = segment.next;
            j2 = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(@e Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() != 0) {
                Segment segment = this.head;
                if (segment == null) {
                    i0.f();
                }
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    i0.f();
                }
                int i2 = segment.pos;
                int i3 = segment2.pos;
                Segment segment3 = segment2;
                Segment segment4 = segment;
                int i4 = i3;
                int i5 = i2;
                long j2 = 0;
                while (j2 < size()) {
                    long jMin = Math.min(segment4.limit - i5, segment3.limit - i4);
                    long j3 = 0;
                    while (j3 < jMin) {
                        int i6 = i5 + 1;
                        int i7 = i4 + 1;
                        if (segment4.data[i5] != segment3.data[i4]) {
                            return false;
                        }
                        j3++;
                        i5 = i6;
                        i4 = i7;
                    }
                    if (i5 == segment4.limit) {
                        segment4 = segment4.next;
                        if (segment4 == null) {
                            i0.f();
                        }
                        i5 = segment4.pos;
                    }
                    if (i4 == segment3.limit) {
                        segment3 = segment3.next;
                        if (segment3 == null) {
                            i0.f();
                        }
                        i4 = segment3.pos;
                    }
                    j2 += jMin;
                }
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @i.c.a.d
    public Buffer getBuffer() {
        return this;
    }

    @h.q2.e(name = "getByte")
    public final byte getByte(long j2) {
        Util.checkOffsetAndCount(size(), j2, 1L);
        Segment segment = this.head;
        if (segment == null) {
            Segment segment2 = null;
            i0.f();
            return segment2.data[(int) ((segment2.pos + j2) - (-1))];
        }
        if (size() - j2 < j2) {
            long size = size();
            while (size > j2) {
                segment = segment.prev;
                if (segment == null) {
                    i0.f();
                }
                size -= segment.limit - segment.pos;
            }
            if (segment == null) {
                i0.f();
            }
            return segment.data[(int) ((segment.pos + j2) - size)];
        }
        long j3 = 0;
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
            j3 = j4;
        }
        if (segment == null) {
            i0.f();
        }
        return segment.data[(int) ((segment.pos + j2) - j3)];
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.limit;
            for (int i4 = segment.pos; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.data[i4];
            }
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
        } while (segment != this.head);
        return i2;
    }

    @i.c.a.d
    public final ByteString hmacSha1(@i.c.a.d ByteString byteString) {
        i0.f(byteString, "key");
        return hmac("HmacSHA1", byteString);
    }

    @i.c.a.d
    public final ByteString hmacSha256(@i.c.a.d ByteString byteString) {
        i0.f(byteString, "key");
        return hmac("HmacSHA256", byteString);
    }

    @i.c.a.d
    public final ByteString hmacSha512(@i.c.a.d ByteString byteString) {
        i0.f(byteString, "key");
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, m0.f16408b);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@i.c.a.d ByteString byteString) {
        i0.f(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.inputStream.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & f1.f16099c;
                }
                return -1;
            }

            @i.c.a.d
            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@i.c.a.d byte[] bArr, int i2, int i3) {
                i0.f(bArr, "sink");
                return Buffer.this.read(bArr, i2, i3);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @i.c.a.d
    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.outputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @i.c.a.d
            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i2) {
                Buffer.this.writeByte(i2);
            }

            @Override // java.io.OutputStream
            public void write(@i.c.a.d byte[] bArr, int i2, int i3) {
                i0.f(bArr, "data");
                Buffer.this.write(bArr, i2, i3);
            }
        };
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, @i.c.a.d ByteString byteString) {
        i0.f(byteString, "bytes");
        return rangeEquals(j2, byteString, 0, byteString.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@i.c.a.d ByteBuffer byteBuffer) throws IOException {
        i0.f(byteBuffer, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        segment.pos += iMin;
        this.size -= iMin;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public long readAll(@i.c.a.d Sink sink) throws IOException {
        i0.f(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @f
    @i.c.a.d
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @f
    @i.c.a.d
    public final UnsafeCursor readAndWriteUnsafe(@i.c.a.d UnsafeCursor unsafeCursor) {
        i0.f(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i0.f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        int i4 = i2 + 1;
        byte b2 = segment.data[i2];
        setSize$okio(size() - 1);
        if (i4 == i3) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return b2;
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c5 A[EDGE_INSN: B:54:0x00c5->B:44:0x00c5 BREAK  A[LOOP:0: B:5:0x0012->B:56:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @i.c.a.d
    public final Buffer readFrom(@i.c.a.d InputStream inputStream) throws IOException {
        i0.f(inputStream, "input");
        readFrom(inputStream, m0.f16408b, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(@i.c.a.d Buffer buffer, long j2) throws EOFException {
        i0.f(buffer, "sink");
        if (size() >= j2) {
            buffer.write(this, j2);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2 A[EDGE_INSN: B:46:0x00b2->B:40:0x00b2 BREAK  A[LOOP:0: B:5:0x000d->B:48:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lbc
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L14
            h.q2.t.i0.f()
        L14:
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1a:
            if (r8 >= r9) goto L9c
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L2b
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L2b
            int r11 = r10 - r11
            goto L45
        L2b:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3a
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3a
        L35:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L45
        L3a:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7d
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7d
            goto L35
        L45:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L55
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1a
        L55:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7d:
            if (r0 == 0) goto L81
            r1 = 1
            goto L9c
        L81:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.Util.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9c:
            if (r8 != r9) goto Laa
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool r7 = okio.SegmentPool.INSTANCE
            r7.recycle(r6)
            goto Lac
        Laa:
            r6.pos = r8
        Lac:
            if (r1 != 0) goto Lb2
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Ld
        Lb2:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lbc:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i0.f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 4) {
            return ((readByte() & f1.f16099c) << 24) | ((readByte() & f1.f16099c) << 16) | ((readByte() & f1.f16099c) << 8) | (readByte() & f1.f16099c);
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & f1.f16099c) << 24) | ((bArr[i4] & f1.f16099c) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & f1.f16099c) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & f1.f16099c);
        setSize$okio(size() - 4);
        if (i9 == i3) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i9;
        }
        return i10;
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i0.f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        long j2 = (bArr[i2] & 255) << 56;
        long j3 = j2 | ((bArr[r6] & 255) << 48);
        long j4 = j3 | ((bArr[r1] & 255) << 40);
        int i4 = i2 + 1 + 1 + 1 + 1;
        long j5 = ((bArr[r6] & 255) << 32) | j4;
        long j6 = j5 | ((bArr[i4] & 255) << 24);
        long j7 = j6 | ((bArr[r8] & 255) << 16);
        long j8 = j7 | ((bArr[r1] & 255) << 8);
        int i5 = i4 + 1 + 1 + 1 + 1;
        long j9 = j8 | (bArr[r8] & 255);
        setSize$okio(size() - 8);
        if (i5 == i3) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return j9;
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i0.f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 2) {
            return (short) (((readByte() & f1.f16099c) << 8) | (readByte() & f1.f16099c));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & f1.f16099c) << 8) | (bArr[i4] & f1.f16099c);
        setSize$okio(size() - 2);
        if (i5 == i3) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public String readString(@i.c.a.d Charset charset) {
        i0.f(charset, "charset");
        return readString(this.size, charset);
    }

    @f
    @i.c.a.d
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @f
    @i.c.a.d
    public final UnsafeCursor readUnsafe(@i.c.a.d UnsafeCursor unsafeCursor) {
        i0.f(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public String readUtf8() {
        return readString(this.size, h.z2.f.f16682a);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b2 = getByte(0L);
        if ((b2 & n.f16413a) == 0) {
            i2 = b2 & n.f16414b;
            i3 = 1;
            i4 = 0;
        } else if ((b2 & 224) == 192) {
            i2 = b2 & 31;
            i3 = 2;
            i4 = 128;
        } else if ((b2 & 240) == 224) {
            i2 = b2 & cw.f10303m;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((b2 & 248) != 240) {
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = b2 & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j2 = i3;
        if (size() < j2) {
            throw new EOFException("size < " + i3 + ": " + size() + " (to read code point prefixed 0x" + Util.toHexString(b2) + ')');
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j3 = i5;
            byte b3 = getByte(j3);
            if ((b3 & 192) != 128) {
                skip(j3);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = (i2 << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
        }
        skip(j2);
        return i2 > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i2 && 57343 >= i2) || i2 < i4) ? Utf8.REPLACEMENT_CODE_POINT : i2;
    }

    @Override // okio.BufferedSource
    @e
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(m0.f16408b);
    }

    @Override // okio.BufferedSource
    public boolean request(long j2) {
        return this.size >= j2;
    }

    @Override // okio.BufferedSource
    public void require(long j2) throws EOFException {
        if (this.size < j2) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@i.c.a.d Options options) throws EOFException {
        i0.f(options, "options");
        int iSelectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public final void setSize$okio(long j2) {
        this.size = j2;
    }

    @i.c.a.d
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @i.c.a.d
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @i.c.a.d
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    @h.q2.e(name = "size")
    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, segment.limit - segment.pos);
            long j3 = iMin;
            setSize$okio(size() - j3);
            j2 -= j3;
            segment.pos += iMin;
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }

    @i.c.a.d
    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // okio.Source
    @i.c.a.d
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @i.c.a.d
    public String toString() {
        return snapshot().toString();
    }

    @i.c.a.d
    public final Segment writableSegment$okio(int i2) {
        if (!(i2 >= 1 && i2 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.INSTANCE.take();
            this.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        if (segment == null) {
            i0.f();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            i0.f();
        }
        return (segment2.limit + i2 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.INSTANCE.take()) : segment2;
    }

    @Override // okio.BufferedSink
    public long writeAll(@i.c.a.d Source source) throws IOException {
        i0.f(source, "source");
        long j2 = 0;
        while (true) {
            long j3 = source.read(this, 8192);
            if (j3 == -1) {
                return j2;
            }
            j2 += j3;
        }
    }

    @f
    @i.c.a.d
    public final Buffer writeTo(@i.c.a.d OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    @f
    @i.c.a.d
    public final Buffer writeTo(@i.c.a.d OutputStream outputStream, long j2) throws IOException {
        i0.f(outputStream, "out");
        Util.checkOffsetAndCount(this.size, 0L, j2);
        Segment segment = this.head;
        while (j2 > 0) {
            if (segment == null) {
                i0.f();
            }
            int iMin = (int) Math.min(j2, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, iMin);
            segment.pos += iMin;
            long j3 = iMin;
            this.size -= j3;
            j2 -= j3;
            if (segment.pos == segment.limit) {
                Segment segmentPop = segment.pop();
                this.head = segmentPop;
                SegmentPool.INSTANCE.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @i.c.a.d
    public Buffer clone() {
        return copy();
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2) {
        return indexOf(b2, j2, m0.f16408b);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@i.c.a.d ByteString byteString, long j2) {
        int i2;
        int i3;
        i0.f(byteString, "targetBytes");
        long size = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j2 < j2) {
            size = size();
            while (size > j2) {
                segment = segment.prev;
                if (segment == null) {
                    i0.f();
                }
                size -= segment.limit - segment.pos;
            }
            if (segment == null) {
                return -1L;
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (size < size()) {
                    byte[] bArr = segment.data;
                    i2 = (int) ((segment.pos + j2) - size);
                    int i4 = segment.limit;
                    while (i2 < i4) {
                        byte b4 = bArr[i2];
                        if (b4 == b2 || b4 == b3) {
                            i3 = segment.pos;
                        } else {
                            i2++;
                        }
                    }
                    j2 = (segment.limit - segment.pos) + size;
                    segment = segment.next;
                    if (segment == null) {
                        i0.f();
                    }
                    size = j2;
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = byteString.internalArray$okio();
            while (size < size()) {
                byte[] bArr2 = segment.data;
                i2 = (int) ((segment.pos + j2) - size);
                int i5 = segment.limit;
                while (i2 < i5) {
                    byte b5 = bArr2[i2];
                    for (byte b6 : bArrInternalArray$okio) {
                        if (b5 == b6) {
                            i3 = segment.pos;
                        }
                    }
                    i2++;
                }
                j2 = (segment.limit - segment.pos) + size;
                segment = segment.next;
                if (segment == null) {
                    i0.f();
                }
                size = j2;
            }
            return -1L;
        }
        while (true) {
            long j3 = (segment.limit - segment.pos) + size;
            if (j3 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
            size = j3;
        }
        if (segment == null) {
            return -1L;
        }
        if (byteString.size() == 2) {
            byte b7 = byteString.getByte(0);
            byte b8 = byteString.getByte(1);
            while (size < size()) {
                byte[] bArr3 = segment.data;
                i2 = (int) ((segment.pos + j2) - size);
                int i6 = segment.limit;
                while (i2 < i6) {
                    byte b9 = bArr3[i2];
                    if (b9 == b7 || b9 == b8) {
                        i3 = segment.pos;
                    } else {
                        i2++;
                    }
                }
                j2 = (segment.limit - segment.pos) + size;
                segment = segment.next;
                if (segment == null) {
                    i0.f();
                }
                size = j2;
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
        while (size < size()) {
            byte[] bArr4 = segment.data;
            i2 = (int) ((segment.pos + j2) - size);
            int i7 = segment.limit;
            while (i2 < i7) {
                byte b10 = bArr4[i2];
                for (byte b11 : bArrInternalArray$okio2) {
                    if (b10 == b11) {
                        i3 = segment.pos;
                    }
                }
                i2++;
            }
            j2 = (segment.limit - segment.pos) + size;
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
            size = j2;
        }
        return -1L;
        return (i2 - i3) + size;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, @i.c.a.d ByteString byteString, int i2, int i3) {
        i0.f(byteString, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || size() - j2 < i3 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (getByte(i4 + j2) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public byte[] readByteArray(long j2) throws EOFException {
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (size() < j2) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j2];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public ByteString readByteString(long j2) throws EOFException {
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (size() < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new ByteString(readByteArray(j2));
        }
        ByteString byteStringSnapshot = snapshot((int) j2);
        skip(j2);
        return byteStringSnapshot;
    }

    @i.c.a.d
    public final Buffer readFrom(@i.c.a.d InputStream inputStream, long j2) throws IOException {
        i0.f(inputStream, "input");
        if (j2 >= 0) {
            readFrom(inputStream, j2, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public String readString(long j2, @i.c.a.d Charset charset) throws EOFException {
        i0.f(charset, "charset");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (this.size < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        Segment segment = this.head;
        if (segment == null) {
            i0.f();
        }
        int i2 = segment.pos;
        if (i2 + j2 > segment.limit) {
            return new String(readByteArray(j2), charset);
        }
        int i3 = (int) j2;
        String str = new String(segment.data, i2, i3, charset);
        segment.pos += i3;
        this.size -= j2;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public String readUtf8(long j2) throws EOFException {
        return readString(j2, h.z2.f.f16682a);
    }

    @Override // okio.BufferedSource
    @i.c.a.d
    public String readUtf8LineStrict(long j2) throws EOFException {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = m0.f16408b;
        if (j2 != m0.f16408b) {
            j3 = j2 + 1;
        }
        byte b2 = (byte) 10;
        long jIndexOf = indexOf(b2, 0L, j3);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (j3 < size() && getByte(j3 - 1) == ((byte) 13) && getByte(j3) == b2) {
            return BufferKt.readUtf8Line(this, j3);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j2) + " content=" + buffer.readByteString().hex() + h0.E);
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeByte(int i2) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i3 + 1;
        bArr[i3] = (byte) i2;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeDecimalLong(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= a.q) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment segmentWritableSegment$okio = writableSegment$okio(i2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit + i2;
        while (j2 != 0) {
            long j3 = 10;
            i3--;
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i2;
        setSize$okio(size() + i2);
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeHexadecimalUnsignedLong(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        Segment segmentWritableSegment$okio = writableSegment$okio(i2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        segmentWritableSegment$okio.limit += i2;
        setSize$okio(size() + i2);
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeInt(int i2) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        segmentWritableSegment$okio.limit = i6 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeIntLe(int i2) {
        return writeInt(Util.reverseBytes(i2));
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeLong(long j2) {
        Segment segmentWritableSegment$okio = writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        segmentWritableSegment$okio.limit = i9 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeLongLe(long j2) {
        return writeLong(Util.reverseBytes(j2));
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeShort(int i2) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i3 = segmentWritableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        segmentWritableSegment$okio.limit = i4 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeShortLe(int i2) {
        return writeShort((int) Util.reverseBytes((short) i2));
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeUtf8CodePoint(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i3 = segmentWritableSegment$okio.limit;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            segmentWritableSegment$okio.limit = i3 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            writeByte(63);
        } else if (i2 < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i4 = segmentWritableSegment$okio2.limit;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            segmentWritableSegment$okio2.limit = i4 + 3;
            setSize$okio(size() + 3);
        } else {
            if (i2 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i2));
            }
            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i5 = segmentWritableSegment$okio3.limit;
            bArr3[i5] = (byte) ((i2 >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            segmentWritableSegment$okio3.limit = i5 + 4;
            setSize$okio(size() + 4);
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@i.c.a.d ByteString byteString) throws IOException {
        i0.f(byteString, "bytes");
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeString(@i.c.a.d String str, @i.c.a.d Charset charset) {
        i0.f(str, "string");
        i0.f(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeUtf8(@i.c.a.d String str) {
        i0.f(str, "string");
        return writeUtf8(str, 0, str.length());
    }

    private final void readFrom(InputStream inputStream, long j2, boolean z) throws IOException {
        while (true) {
            if (j2 <= 0 && !z) {
                return;
            }
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int i2 = inputStream.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j2, 8192 - segmentWritableSegment$okio.limit));
            if (i2 == -1) {
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    this.head = segmentWritableSegment$okio.pop();
                    SegmentPool.INSTANCE.recycle(segmentWritableSegment$okio);
                }
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            segmentWritableSegment$okio.limit += i2;
            long j3 = i2;
            this.size += j3;
            j2 -= j3;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2, long j3) {
        Segment segment;
        int i2;
        long size = 0;
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        if (j3 > size()) {
            j3 = size();
        }
        if (j2 == j3 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j2 < j2) {
            size = size();
            while (size > j2) {
                segment = segment.prev;
                if (segment == null) {
                    i0.f();
                }
                size -= segment.limit - segment.pos;
            }
            if (segment == null) {
                return -1L;
            }
            while (size < j3) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (segment.pos + j3) - size);
                i2 = (int) ((segment.pos + j2) - size);
                while (i2 < iMin) {
                    if (bArr[i2] != b2) {
                        i2++;
                    }
                }
                j2 = (segment.limit - segment.pos) + size;
                segment = segment.next;
                if (segment == null) {
                    i0.f();
                }
                size = j2;
            }
            return -1L;
        }
        while (true) {
            long j4 = (segment.limit - segment.pos) + size;
            if (j4 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
            size = j4;
        }
        if (segment == null) {
            return -1L;
        }
        while (size < j3) {
            byte[] bArr2 = segment.data;
            int iMin2 = (int) Math.min(segment.limit, (segment.pos + j3) - size);
            i2 = (int) ((segment.pos + j2) - size);
            while (i2 < iMin2) {
                if (bArr2[i2] != b2) {
                    i2++;
                }
            }
            j2 = (segment.limit - segment.pos) + size;
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
            size = j2;
        }
        return -1L;
        return (i2 - segment.pos) + size;
    }

    @i.c.a.d
    public final ByteString snapshot(int i2) {
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0L, i2);
        int i3 = 0;
        Segment segment = this.head;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            if (segment == null) {
                i0.f();
            }
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        Segment segment2 = this.head;
        int i8 = 0;
        while (i3 < i2) {
            if (segment2 == null) {
                i0.f();
            }
            bArr[i8] = segment2.data;
            i3 += segment2.limit - segment2.pos;
            iArr[i8] = Math.min(i3, i2);
            iArr[bArr.length + i8] = segment2.pos;
            segment2.shared = true;
            i8++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeString(@i.c.a.d String str, int i2, int i3, @i.c.a.d Charset charset) {
        i0.f(str, "string");
        i0.f(charset, "charset");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (i3 <= str.length()) {
                if (i0.a(charset, h.z2.f.f16682a)) {
                    return writeUtf8(str, i2, i3);
                }
                String strSubstring = str.substring(i2, i3);
                i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (strSubstring != null) {
                    byte[] bytes = strSubstring.getBytes(charset);
                    i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
                throw new e1("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer writeUtf8(@i.c.a.d String str, int i2, int i3) {
        i0.f(str, "string");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (!(i3 <= str.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < 128) {
                    Segment segmentWritableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = segmentWritableSegment$okio.data;
                    int i4 = segmentWritableSegment$okio.limit - i2;
                    int iMin = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) cCharAt;
                    while (i5 < iMin) {
                        char cCharAt2 = str.charAt(i5);
                        if (cCharAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) cCharAt2;
                        i5++;
                    }
                    int i6 = segmentWritableSegment$okio.limit;
                    int i7 = (i4 + i5) - i6;
                    segmentWritableSegment$okio.limit = i6 + i7;
                    setSize$okio(size() + i7);
                    i2 = i5;
                } else {
                    if (cCharAt < 2048) {
                        Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = segmentWritableSegment$okio2.data;
                        int i8 = segmentWritableSegment$okio2.limit;
                        bArr2[i8] = (byte) ((cCharAt >> 6) | 192);
                        bArr2[i8 + 1] = (byte) ((cCharAt & '?') | 128);
                        segmentWritableSegment$okio2.limit = i8 + 2;
                        setSize$okio(size() + 2);
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i9 = i2 + 1;
                        char cCharAt3 = i9 < i3 ? str.charAt(i9) : (char) 0;
                        if (cCharAt <= 56319 && 56320 <= cCharAt3 && 57343 >= cCharAt3) {
                            int i10 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = segmentWritableSegment$okio3.data;
                            int i11 = segmentWritableSegment$okio3.limit;
                            bArr3[i11] = (byte) ((i10 >> 18) | 240);
                            bArr3[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr3[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            bArr3[i11 + 3] = (byte) ((i10 & 63) | 128);
                            segmentWritableSegment$okio3.limit = i11 + 4;
                            setSize$okio(size() + 4);
                            i2 += 2;
                        } else {
                            writeByte(63);
                            i2 = i9;
                        }
                    } else {
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i12 = segmentWritableSegment$okio4.limit;
                        bArr4[i12] = (byte) ((cCharAt >> '\f') | 224);
                        bArr4[i12 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                        bArr4[i12 + 2] = (byte) ((cCharAt & '?') | 128);
                        segmentWritableSegment$okio4.limit = i12 + 3;
                        setSize$okio(size() + 3);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(@i.c.a.d byte[] bArr) throws EOFException {
        i0.f(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = read(bArr, i2, bArr.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@i.c.a.d ByteBuffer byteBuffer) throws IOException {
        i0.f(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i2, 8192 - segmentWritableSegment$okio.limit);
            byteBuffer.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i2 -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSource
    public int read(@i.c.a.d byte[] bArr) {
        i0.f(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @i.c.a.d
    public final Buffer copyTo(@i.c.a.d Buffer buffer, long j2) {
        i0.f(buffer, "out");
        return copyTo(buffer, j2, this.size - j2);
    }

    @Override // okio.BufferedSource
    public int read(@i.c.a.d byte[] bArr, int i2, int i3) {
        i0.f(bArr, "sink");
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i3, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i4 = segment.pos;
        q.a(bArr2, bArr, i2, i4, i4 + iMin);
        segment.pos += iMin;
        setSize$okio(size() - iMin);
        if (segment.pos != segment.limit) {
            return iMin;
        }
        this.head = segment.pop();
        SegmentPool.INSTANCE.recycle(segment);
        return iMin;
    }

    @i.c.a.d
    public final Buffer copyTo(@i.c.a.d Buffer buffer, long j2, long j3) {
        i0.f(buffer, "out");
        Util.checkOffsetAndCount(size(), j2, j3);
        if (j3 != 0) {
            buffer.setSize$okio(buffer.size() + j3);
            Segment segment = this.head;
            while (true) {
                if (segment == null) {
                    i0.f();
                }
                int i2 = segment.limit;
                int i3 = segment.pos;
                if (j2 < i2 - i3) {
                    break;
                }
                j2 -= i2 - i3;
                segment = segment.next;
            }
            while (j3 > 0) {
                if (segment == null) {
                    i0.f();
                }
                Segment segmentSharedCopy = segment.sharedCopy();
                segmentSharedCopy.pos += (int) j2;
                segmentSharedCopy.limit = Math.min(segmentSharedCopy.pos + ((int) j3), segmentSharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy.prev;
                    buffer.head = segmentSharedCopy.next;
                } else {
                    if (segment2 == null) {
                        i0.f();
                    }
                    Segment segment3 = segment2.prev;
                    if (segment3 == null) {
                        i0.f();
                    }
                    segment3.push(segmentSharedCopy);
                }
                j3 -= segmentSharedCopy.limit - segmentSharedCopy.pos;
                segment = segment.next;
                j2 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer write(@i.c.a.d ByteString byteString) {
        i0.f(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer write(@i.c.a.d ByteString byteString, int i2, int i3) {
        i0.f(byteString, "byteString");
        byteString.write$okio(this, i2, i3);
        return this;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer write(@i.c.a.d byte[] bArr) {
        i0.f(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer write(@i.c.a.d byte[] bArr, int i2, int i3) {
        i0.f(bArr, "source");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i4 - i2, 8192 - segmentWritableSegment$okio.limit);
            int i5 = i2 + iMin;
            q.a(bArr, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i2, i5);
            segmentWritableSegment$okio.limit += iMin;
            i2 = i5;
        }
        setSize$okio(size() + j2);
        return this;
    }

    @Override // okio.Source
    public long read(@i.c.a.d Buffer buffer, long j2) {
        i0.f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j2 > size()) {
            j2 = size();
        }
        buffer.write(this, j2);
        return j2;
    }

    @Override // okio.BufferedSink
    @i.c.a.d
    public Buffer write(@i.c.a.d Source source, long j2) throws IOException {
        i0.f(source, "source");
        while (j2 > 0) {
            long j3 = source.read(this, j2);
            if (j3 == -1) {
                throw new EOFException();
            }
            j2 -= j3;
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@i.c.a.d ByteString byteString, long j2) throws IOException {
        long j3;
        long j4 = j2;
        i0.f(byteString, "bytes");
        if (!(byteString.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j5 = 0;
        if (j4 >= 0) {
            Segment segment = this.head;
            if (segment != null) {
                if (size() - j4 < j4) {
                    long size = size();
                    while (size > j4) {
                        segment = segment.prev;
                        if (segment == null) {
                            i0.f();
                        }
                        size -= segment.limit - segment.pos;
                    }
                    if (segment != null) {
                        byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                        byte b2 = bArrInternalArray$okio[0];
                        int size2 = byteString.size();
                        long size3 = (size() - size2) + 1;
                        while (size < size3) {
                            byte[] bArr = segment.data;
                            long j6 = size;
                            int iMin = (int) Math.min(segment.limit, (segment.pos + size3) - size);
                            for (int i2 = (int) ((segment.pos + j4) - j6); i2 < iMin; i2++) {
                                if (bArr[i2] == b2 && BufferKt.rangeEquals(segment, i2 + 1, bArrInternalArray$okio, 1, size2)) {
                                    j3 = (i2 - segment.pos) + j6;
                                    return j3;
                                }
                            }
                            j4 = j6 + (segment.limit - segment.pos);
                            segment = segment.next;
                            if (segment == null) {
                                i0.f();
                            }
                            size = j4;
                        }
                    }
                } else {
                    while (true) {
                        long j7 = (segment.limit - segment.pos) + j5;
                        if (j7 > j4) {
                            break;
                        }
                        segment = segment.next;
                        if (segment == null) {
                            i0.f();
                        }
                        j5 = j7;
                    }
                    if (segment != null) {
                        byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
                        byte b3 = bArrInternalArray$okio2[0];
                        int size4 = byteString.size();
                        long size5 = (size() - size4) + 1;
                        while (j5 < size5) {
                            byte[] bArr2 = segment.data;
                            long j8 = size5;
                            int iMin2 = (int) Math.min(segment.limit, (segment.pos + size5) - j5);
                            for (int i3 = (int) ((segment.pos + j4) - j5); i3 < iMin2; i3++) {
                                if (bArr2[i3] == b3 && BufferKt.rangeEquals(segment, i3 + 1, bArrInternalArray$okio2, 1, size4)) {
                                    j3 = (i3 - segment.pos) + j5;
                                    return j3;
                                }
                            }
                            j4 = (segment.limit - segment.pos) + j5;
                            segment = segment.next;
                            if (segment == null) {
                                i0.f();
                            }
                            j5 = j4;
                            size5 = j8;
                        }
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j4).toString());
    }

    @Override // okio.Sink
    public void write(@i.c.a.d Buffer buffer, long j2) {
        Segment segment;
        i0.f(buffer, "source");
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size(), 0L, j2);
            while (j2 > 0) {
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    i0.f();
                }
                int i2 = segment2.limit;
                if (buffer.head == null) {
                    i0.f();
                }
                if (j2 < i2 - r2.pos) {
                    Segment segment3 = this.head;
                    if (segment3 != null) {
                        if (segment3 == null) {
                            i0.f();
                        }
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j2) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = buffer.head;
                            if (segment4 == null) {
                                i0.f();
                            }
                            segment4.writeTo(segment, (int) j2);
                            buffer.setSize$okio(buffer.size() - j2);
                            setSize$okio(size() + j2);
                            return;
                        }
                    }
                    Segment segment5 = buffer.head;
                    if (segment5 == null) {
                        i0.f();
                    }
                    buffer.head = segment5.split((int) j2);
                }
                Segment segment6 = buffer.head;
                if (segment6 == null) {
                    i0.f();
                }
                long j3 = segment6.limit - segment6.pos;
                buffer.head = segment6.pop();
                Segment segment7 = this.head;
                if (segment7 == null) {
                    this.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6.prev;
                } else {
                    if (segment7 == null) {
                        i0.f();
                    }
                    Segment segment8 = segment7.prev;
                    if (segment8 == null) {
                        i0.f();
                    }
                    segment8.push(segment6).compact();
                }
                buffer.setSize$okio(buffer.size() - j3);
                setSize$okio(size() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}

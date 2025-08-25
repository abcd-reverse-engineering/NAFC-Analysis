package okio;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.umeng.analytics.pro.cw;
import h.e1;
import h.g2.q;
import h.o0;
import h.q2.c;
import h.q2.h;
import h.q2.t.i0;
import h.q2.t.v;
import h.y;
import h.z2.b0;
import h.z2.f;
import i.c.a.d;
import i.c.a.e;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.internal.ByteStringKt;

/* compiled from: ByteString.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 Z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001ZB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000J\u0013\u0010!\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b&J\u0015\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0007¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\tH\u0010¢\u0006\u0002\b)J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u001d\u0010+\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0000H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\r\u00103\u001a\u00020\u0004H\u0010¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\tH\u0010¢\u0006\u0002\b7J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\b\u00109\u001a\u00020\u0000H\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\u0000H\u0016J\b\u0010C\u001a\u00020\u0000H\u0016J\b\u0010D\u001a\u00020\u0000H\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bEJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016J\u001c\u0010K\u001a\u00020\u00002\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\tH\u0017J\b\u0010N\u001a\u00020\u0000H\u0016J\b\u0010O\u001a\u00020\u0000H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020TH\u0016J%\u0010R\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\u0006\u0010;\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020?2\u0006\u0010S\u001a\u00020YH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006["}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", DispatchConstants.OTHER, "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", RequestParameters.PREFIX, "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);

    @c
    @d
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @d
    private final byte[] data;
    private transient int hashCode;

    @e
    private transient String utf8;

    /* compiled from: ByteString.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charset = f.f16682a;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return companion.of(bArr, i2, i3);
        }

        @h.q2.e(name = "-deprecated_decodeBase64")
        @h.c(level = h.d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @e
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m792deprecated_decodeBase64(@d String str) {
            i0.f(str, "string");
            return decodeBase64(str);
        }

        @h.q2.e(name = "-deprecated_decodeHex")
        @h.c(level = h.d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @d
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m793deprecated_decodeHex(@d String str) {
            i0.f(str, "string");
            return decodeHex(str);
        }

        @h.q2.e(name = "-deprecated_encodeString")
        @h.c(level = h.d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @d
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m794deprecated_encodeString(@d String str, @d Charset charset) {
            i0.f(str, "string");
            i0.f(charset, "charset");
            return encodeString(str, charset);
        }

        @h.q2.e(name = "-deprecated_encodeUtf8")
        @h.c(level = h.d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @d
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m795deprecated_encodeUtf8(@d String str) {
            i0.f(str, "string");
            return encodeUtf8(str);
        }

        @h.q2.e(name = "-deprecated_of")
        @h.c(level = h.d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @d
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m796deprecated_of(@d ByteBuffer byteBuffer) {
            i0.f(byteBuffer, "buffer");
            return of(byteBuffer);
        }

        @h.q2.e(name = "-deprecated_read")
        @h.c(level = h.d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @d
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m798deprecated_read(@d InputStream inputStream, int i2) {
            i0.f(inputStream, "inputstream");
            return read(inputStream, i2);
        }

        @e
        @h
        public final ByteString decodeBase64(@d String str) {
            i0.f(str, "$this$decodeBase64");
            byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        @h
        @d
        public final ByteString decodeHex(@d String str) {
            i0.f(str, "$this$decodeHex");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            byte[] bArr = new byte[str.length() / 2];
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((ByteStringKt.decodeHexDigit(str.charAt(i3)) << 4) + ByteStringKt.decodeHexDigit(str.charAt(i3 + 1)));
            }
            return new ByteString(bArr);
        }

        @h.q2.e(name = "encodeString")
        @h
        @d
        public final ByteString encodeString(@d String str, @d Charset charset) {
            i0.f(str, "$this$encode");
            i0.f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @h
        @d
        public final ByteString encodeUtf8(@d String str) {
            i0.f(str, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @h.q2.e(name = "of")
        @h
        @d
        public final ByteString of(@d ByteBuffer byteBuffer) {
            i0.f(byteBuffer, "$this$toByteString");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @h.q2.e(name = "read")
        @h
        @d
        public final ByteString read(@d InputStream inputStream, int i2) throws IOException {
            i0.f(inputStream, "$this$readByteString");
            int i3 = 0;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i2).toString());
            }
            byte[] bArr = new byte[i2];
            while (i3 < i2) {
                int i4 = inputStream.read(bArr, i3, i2 - i3);
                if (i4 == -1) {
                    throw new EOFException();
                }
                i3 += i4;
            }
            return new ByteString(bArr);
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @h.q2.e(name = "-deprecated_of")
        @h.c(level = h.d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @d
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m797deprecated_of(@d byte[] bArr, int i2, int i3) {
            i0.f(bArr, "array");
            return of(bArr, i2, i3);
        }

        @h
        @d
        public final ByteString of(@d byte... bArr) {
            i0.f(bArr, "data");
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(bArrCopyOf);
        }

        @h.q2.e(name = "of")
        @h
        @d
        public final ByteString of(@d byte[] bArr, int i2, int i3) {
            i0.f(bArr, "$this$toByteString");
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            return new ByteString(q.a(bArr, i2, i3 + i2));
        }
    }

    public ByteString(@d byte[] bArr) {
        i0.f(bArr, "data");
        this.data = bArr;
    }

    @e
    @h
    public static final ByteString decodeBase64(@d String str) {
        return Companion.decodeBase64(str);
    }

    @h
    @d
    public static final ByteString decodeHex(@d String str) {
        return Companion.decodeHex(str);
    }

    @h.q2.e(name = "encodeString")
    @h
    @d
    public static final ByteString encodeString(@d String str, @d Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @h
    @d
    public static final ByteString encodeUtf8(@d String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(byteString2, i2);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(bArr, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i2);
    }

    @h.q2.e(name = "of")
    @h
    @d
    public static final ByteString of(@d ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @h
    @d
    public static final ByteString of(@d byte... bArr) {
        return Companion.of(bArr);
    }

    @h.q2.e(name = "of")
    @h
    @d
    public static final ByteString of(@d byte[] bArr, int i2, int i3) {
        return Companion.of(bArr, i2, i3);
    }

    @h.q2.e(name = "read")
    @h
    @d
    public static final ByteString read(@d InputStream inputStream, int i2) throws IOException {
        return Companion.read(inputStream, i2);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        ByteString byteString = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        i0.a((Object) declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = byteString.size();
        }
        return byteString.substring(i2, i3);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @h.q2.e(name = "-deprecated_getByte")
    @h.c(level = h.d.ERROR, message = "moved to operator function", replaceWith = @o0(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m790deprecated_getByte(int i2) {
        return getByte(i2);
    }

    @h.q2.e(name = "-deprecated_size")
    @h.c(level = h.d.ERROR, message = "moved to val", replaceWith = @o0(expression = "size", imports = {}))
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m791deprecated_size() {
        return size();
    }

    @d
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        i0.a((Object) byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @d
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @d
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    @d
    public ByteString digest$okio(@d String str) {
        i0.f(str, "algorithm");
        byte[] bArrDigest = MessageDigest.getInstance(str).digest(this.data);
        i0.a((Object) bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(bArrDigest);
    }

    public final boolean endsWith(@d ByteString byteString) {
        i0.f(byteString, "suffix");
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(@e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @h.q2.e(name = "getByte")
    public final byte getByte(int i2) {
        return internalGet$okio(i2);
    }

    @d
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @e
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    @d
    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i2 = 0;
        for (byte b2 : getData$okio()) {
            int i3 = i2 + 1;
            cArr[i2] = ByteStringKt.getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = ByteStringKt.getHEX_DIGIT_CHARS()[b2 & cw.f10303m];
        }
        return new String(cArr);
    }

    @d
    public ByteString hmac$okio(@d String str, @d ByteString byteString) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        i0.f(str, "algorithm");
        i0.f(byteString, "key");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            i0.a((Object) bArrDoFinal, "mac.doFinal(data)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @d
    public ByteString hmacSha1(@d ByteString byteString) {
        i0.f(byteString, "key");
        return hmac$okio("HmacSHA1", byteString);
    }

    @d
    public ByteString hmacSha256(@d ByteString byteString) {
        i0.f(byteString, "key");
        return hmac$okio("HmacSHA256", byteString);
    }

    @d
    public ByteString hmacSha512(@d ByteString byteString) {
        i0.f(byteString, "key");
        return hmac$okio("HmacSHA512", byteString);
    }

    @h.q2.f
    public final int indexOf(@d ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @h.q2.f
    public final int indexOf(@d ByteString byteString, int i2) {
        i0.f(byteString, DispatchConstants.OTHER);
        return indexOf(byteString.internalArray$okio(), i2);
    }

    @h.q2.f
    public int indexOf(@d byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @d
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i2) {
        return getData$okio()[i2];
    }

    @h.q2.f
    public final int lastIndexOf(@d ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @h.q2.f
    public final int lastIndexOf(@d ByteString byteString, int i2) {
        i0.f(byteString, DispatchConstants.OTHER);
        return lastIndexOf(byteString.internalArray$okio(), i2);
    }

    @h.q2.f
    public int lastIndexOf(@d byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @d
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i2, @d ByteString byteString, int i3, int i4) {
        i0.f(byteString, DispatchConstants.OTHER);
        return byteString.rangeEquals(i3, getData$okio(), i2, i4);
    }

    public final void setHashCode$okio(int i2) {
        this.hashCode = i2;
    }

    public final void setUtf8$okio(@e String str) {
        this.utf8 = str;
    }

    @d
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @d
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @d
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @h.q2.e(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@d ByteString byteString) {
        i0.f(byteString, RequestParameters.PREFIX);
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    @d
    public String string(@d Charset charset) {
        i0.f(charset, "charset");
        return new String(this.data, charset);
    }

    @h.q2.f
    @d
    public ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @h.q2.f
    @d
    public ByteString substring(int i2) {
        return substring$default(this, i2, 0, 2, null);
    }

    @h.q2.f
    @d
    public ByteString substring(int i2, int i3) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i3 <= getData$okio().length) {
            if (i3 - i2 >= 0) {
                return (i2 == 0 && i3 == getData$okio().length) ? this : new ByteString(q.a(getData$okio(), i2, i3));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    }

    @d
    public ByteString toAsciiLowercase() {
        byte b2;
        for (int i2 = 0; i2 < getData$okio().length; i2++) {
            byte b3 = getData$okio()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @d
    public ByteString toAsciiUppercase() {
        byte b2;
        for (int i2 = 0; i2 < getData$okio().length; i2++) {
            byte b3 = getData$okio()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b5 = bArrCopyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @d
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @d
    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = ByteStringKt.codePointIndexToCharIndex(getData$okio(), 64);
        if (iCodePointIndexToCharIndex == -1) {
            if (getData$okio().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(getData$okio().length);
            sb.append(" hex=");
            if (64 <= getData$okio().length) {
                sb.append((64 == getData$okio().length ? this : new ByteString(q.a(getData$okio(), 0, 64))).hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        String strUtf8 = utf8();
        if (strUtf8 == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
        i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strA = b0.a(b0.a(b0.a(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (iCodePointIndexToCharIndex >= strUtf8.length()) {
            return "[text=" + strA + ']';
        }
        return "[size=" + getData$okio().length + " text=" + strA + "…]";
    }

    @d
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@d OutputStream outputStream) throws IOException {
        i0.f(outputStream, "out");
        outputStream.write(this.data);
    }

    public void write$okio(@d Buffer buffer, int i2, int i3) {
        i0.f(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i2, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        return 1;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@i.c.a.d okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            h.q2.t.i0.f(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L33
        L2b:
            if (r0 != r1) goto L2f
            r5 = 0
            goto L33
        L2f:
            if (r0 >= r1) goto L32
            goto L33
        L32:
            r5 = 1
        L33:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@d byte[] bArr) {
        i0.f(bArr, "suffix");
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    @h.q2.f
    public int indexOf(@d byte[] bArr, int i2) {
        i0.f(bArr, DispatchConstants.OTHER);
        int length = getData$okio().length - bArr.length;
        int iMax = Math.max(i2, 0);
        if (iMax <= length) {
            while (!Util.arrayRangeEquals(getData$okio(), iMax, bArr, 0, bArr.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    @h.q2.f
    public int lastIndexOf(@d byte[] bArr, int i2) {
        i0.f(bArr, DispatchConstants.OTHER);
        for (int iMin = Math.min(i2, getData$okio().length - bArr.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(getData$okio(), iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i2, @d byte[] bArr, int i3, int i4) {
        i0.f(bArr, DispatchConstants.OTHER);
        return i2 >= 0 && i2 <= getData$okio().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && Util.arrayRangeEquals(getData$okio(), i2, bArr, i3, i4);
    }

    public final boolean startsWith(@d byte[] bArr) {
        i0.f(bArr, RequestParameters.PREFIX);
        return rangeEquals(0, bArr, 0, bArr.length);
    }
}

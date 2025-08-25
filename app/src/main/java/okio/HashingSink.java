package okio;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import h.c;
import h.o0;
import h.q2.e;
import h.q2.h;
import h.q2.t.i0;
import h.q2.t.v;
import h.y;
import i.c.a.d;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HashingSink.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", SocializeProtocolConstants.PROTOCOL_KEY_MAC, "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* compiled from: HashingSink.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        @h
        @d
        public final HashingSink hmacSha1(@d Sink sink, @d ByteString byteString) {
            i0.f(sink, "sink");
            i0.f(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA1");
        }

        @h
        @d
        public final HashingSink hmacSha256(@d Sink sink, @d ByteString byteString) {
            i0.f(sink, "sink");
            i0.f(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA256");
        }

        @h
        @d
        public final HashingSink hmacSha512(@d Sink sink, @d ByteString byteString) {
            i0.f(sink, "sink");
            i0.f(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA512");
        }

        @h
        @d
        public final HashingSink md5(@d Sink sink) {
            i0.f(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @h
        @d
        public final HashingSink sha1(@d Sink sink) {
            i0.f(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @h
        @d
        public final HashingSink sha256(@d Sink sink) {
            i0.f(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @h
        @d
        public final HashingSink sha512(@d Sink sink) {
            i0.f(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@d Sink sink, @d String str) {
        super(sink);
        i0.f(sink, "sink");
        i0.f(str, "algorithm");
        this.messageDigest = MessageDigest.getInstance(str);
        this.mac = null;
    }

    @h
    @d
    public static final HashingSink hmacSha1(@d Sink sink, @d ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @h
    @d
    public static final HashingSink hmacSha256(@d Sink sink, @d ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @h
    @d
    public static final HashingSink hmacSha512(@d Sink sink, @d ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @h
    @d
    public static final HashingSink md5(@d Sink sink) {
        return Companion.md5(sink);
    }

    @h
    @d
    public static final HashingSink sha1(@d Sink sink) {
        return Companion.sha1(sink);
    }

    @h
    @d
    public static final HashingSink sha256(@d Sink sink) {
        return Companion.sha256(sink);
    }

    @h
    @d
    public static final HashingSink sha512(@d Sink sink) {
        return Companion.sha512(sink);
    }

    @e(name = "-deprecated_hash")
    @c(level = h.d.ERROR, message = "moved to val", replaceWith = @o0(expression = "hash", imports = {}))
    @d
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m803deprecated_hash() {
        return hash();
    }

    @e(name = "hash")
    @d
    public final ByteString hash() throws IllegalStateException {
        byte[] bArrDoFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            bArrDoFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            if (mac == null) {
                i0.f();
            }
            bArrDoFinal = mac.doFinal();
        }
        i0.a((Object) bArrDoFinal, "result");
        return new ByteString(bArrDoFinal);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@d Buffer buffer, long j2) throws IllegalStateException, IOException {
        i0.f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0L, j2);
        Segment segment = buffer.head;
        if (segment == null) {
            i0.f();
        }
        long j3 = 0;
        while (j3 < j2) {
            int iMin = (int) Math.min(j2 - j3, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                Mac mac = this.mac;
                if (mac == null) {
                    i0.f();
                }
                mac.update(segment.data, segment.pos, iMin);
            }
            j3 += iMin;
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
        }
        super.write(buffer, j2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@d Sink sink, @d ByteString byteString, @d String str) throws NoSuchAlgorithmException, InvalidKeyException {
        super(sink);
        i0.f(sink, "sink");
        i0.f(byteString, "key");
        i0.f(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}

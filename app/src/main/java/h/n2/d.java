package h.n2;

import h.q2.t.i0;
import h.q2.t.j0;
import h.y;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* compiled from: Console.kt */
@h.q2.e(name = "ConsoleKt")
@y(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\u0087\b\u001a\t\u0010\u0015\u001a\u00020\nH\u0087\b\u001a\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\u0087\b\u001a\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u001a\u001a\u00020\r*\u00020\u001bH\u0002\u001a\f\u0010\u001c\u001a\u00020\n*\u00020\u001dH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\n*\u00020\u001b2\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002\u001a$\u0010\"\u001a\u00020\r*\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006'"}, d2 = {"BUFFER_SIZE", "", "LINE_SEPARATOR_MAX_LENGTH", "decoder", "Ljava/nio/charset/CharsetDecoder;", "getDecoder", "()Ljava/nio/charset/CharsetDecoder;", "decoder$delegate", "Lkotlin/Lazy;", "print", "", "message", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "inputStream", "Ljava/io/InputStream;", "endsWithLineSeparator", "Ljava/nio/CharBuffer;", "flipBack", "Ljava/nio/Buffer;", "offloadPrefixTo", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tryDecode", "byteBuffer", "Ljava/nio/ByteBuffer;", "charBuffer", "isEndOfStream", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16323a = 32;

    /* renamed from: b, reason: collision with root package name */
    private static final int f16324b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final h.s f16325c = h.v.a(a.INSTANCE);

    /* compiled from: Console.kt */
    static final class a extends j0 implements h.q2.s.a<CharsetDecoder> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        @Override // h.q2.s.a
        public final CharsetDecoder invoke() {
            return Charset.defaultCharset().newDecoder();
        }
    }

    private static final CharsetDecoder a() {
        return (CharsetDecoder) f16325c.getValue();
    }

    @h.m2.f
    private static final void a(Object obj) {
        System.out.print(obj);
    }

    @h.m2.f
    private static final void b(Object obj) {
        System.out.println(obj);
    }

    @i.c.a.e
    public static final String c() {
        InputStream inputStream = System.in;
        i0.a((Object) inputStream, "System.`in`");
        return a(inputStream, a());
    }

    @h.m2.f
    private static final void a(int i2) {
        System.out.print(i2);
    }

    @h.m2.f
    private static final void b(int i2) {
        System.out.println(i2);
    }

    @h.m2.f
    private static final void a(long j2) {
        System.out.print(j2);
    }

    @h.m2.f
    private static final void b(long j2) {
        System.out.println(j2);
    }

    @h.m2.f
    private static final void a(byte b2) {
        System.out.print(Byte.valueOf(b2));
    }

    @h.m2.f
    private static final void b(byte b2) {
        System.out.println(Byte.valueOf(b2));
    }

    @h.m2.f
    private static final void a(short s) {
        System.out.print(Short.valueOf(s));
    }

    @h.m2.f
    private static final void b(short s) {
        System.out.println(Short.valueOf(s));
    }

    @h.m2.f
    private static final void a(char c2) {
        System.out.print(c2);
    }

    @h.m2.f
    private static final void b(char c2) {
        System.out.println(c2);
    }

    @h.m2.f
    private static final void a(boolean z) {
        System.out.print(z);
    }

    @h.m2.f
    private static final void b(boolean z) {
        System.out.println(z);
    }

    @h.m2.f
    private static final void a(float f2) {
        System.out.print(f2);
    }

    @h.m2.f
    private static final void b(float f2) {
        System.out.println(f2);
    }

    @h.m2.f
    private static final void a(double d2) {
        System.out.print(d2);
    }

    @h.m2.f
    private static final void b(double d2) {
        System.out.println(d2);
    }

    @h.m2.f
    private static final void a(char[] cArr) {
        System.out.print(cArr);
    }

    @h.m2.f
    private static final void b(char[] cArr) {
        System.out.println(cArr);
    }

    @i.c.a.e
    public static final String a(@i.c.a.d InputStream inputStream, @i.c.a.d CharsetDecoder charsetDecoder) throws IOException {
        i0.f(inputStream, "inputStream");
        i0.f(charsetDecoder, "decoder");
        if (charsetDecoder.maxCharsPerByte() <= ((float) 1)) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(32);
            CharBuffer charBufferAllocate = CharBuffer.allocate(4);
            StringBuilder sb = new StringBuilder();
            int i2 = inputStream.read();
            if (i2 == -1) {
                return null;
            }
            do {
                byteBufferAllocate.put((byte) i2);
                i0.a((Object) byteBufferAllocate, "byteBuffer");
                i0.a((Object) charBufferAllocate, "charBuffer");
                if (a(charsetDecoder, byteBufferAllocate, charBufferAllocate, false)) {
                    if (a(charBufferAllocate)) {
                        break;
                    }
                    if (charBufferAllocate.remaining() < 2) {
                        a(charBufferAllocate, sb);
                    }
                    i2 = inputStream.read();
                } else {
                    i2 = inputStream.read();
                }
            } while (i2 != -1);
            a(charsetDecoder, byteBufferAllocate, charBufferAllocate, true);
            charsetDecoder.reset();
            int iPosition = charBufferAllocate.position();
            if (iPosition > 0 && charBufferAllocate.get(iPosition - 1) == '\n' && iPosition - 1 > 0 && charBufferAllocate.get(iPosition - 1) == '\r') {
                iPosition--;
            }
            charBufferAllocate.flip();
            for (int i3 = 0; i3 < iPosition; i3++) {
                sb.append(charBufferAllocate.get());
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Encodings with multiple chars per byte are not supported".toString());
    }

    @h.m2.f
    private static final void b() {
        System.out.println();
    }

    private static final boolean a(@i.c.a.d CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer, boolean z) throws CharacterCodingException {
        int iPosition = charBuffer.position();
        byteBuffer.flip();
        CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, z);
        if (coderResultDecode.isError()) {
            coderResultDecode.throwException();
        }
        boolean z2 = charBuffer.position() > iPosition;
        if (z2) {
            byteBuffer.clear();
        } else {
            a((Buffer) byteBuffer);
        }
        return z2;
    }

    private static final boolean a(@i.c.a.d CharBuffer charBuffer) {
        int iPosition = charBuffer.position();
        return iPosition > 0 && charBuffer.get(iPosition - 1) == '\n';
    }

    private static final void a(@i.c.a.d Buffer buffer) {
        buffer.position(buffer.limit());
        buffer.limit(buffer.capacity());
    }

    private static final void a(@i.c.a.d CharBuffer charBuffer, StringBuilder sb) {
        charBuffer.flip();
        int iLimit = charBuffer.limit() - 1;
        for (int i2 = 0; i2 < iLimit; i2++) {
            sb.append(charBuffer.get());
        }
        charBuffer.compact();
    }
}

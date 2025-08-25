package h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;

/* compiled from: ULong.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001mB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\rHÖ\u0001J\u0013\u0010'\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u0013\u0010)\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0005J\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001dJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u001fJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b.\u0010\u000bJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\"J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001dJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u001fJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\"J\u001b\u00107\u001a\u0002082\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001dJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u001fJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\"J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010C\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u001dJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\"J\u0010\u0010J\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\rH\u0087\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bZ\u0010\u0005J\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020`H\u0016¢\u0006\u0004\ba\u0010bJ\u0013\u0010c\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bd\u0010MJ\u0013\u0010e\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bf\u0010XJ\u0013\u0010g\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bh\u0010\u0005J\u0013\u0010i\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\bj\u0010^J\u001b\u0010k\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bl\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-impl", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@k
/* loaded from: classes2.dex */
public final class n1 implements Comparable<n1> {

    /* renamed from: b, reason: collision with root package name */
    public static final long f16313b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final long f16314c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f16315d = 8;

    /* renamed from: e, reason: collision with root package name */
    public static final int f16316e = 64;

    /* renamed from: f, reason: collision with root package name */
    public static final a f16317f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f16318a;

    /* compiled from: ULong.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    @n0
    private /* synthetic */ n1(long j2) {
        this.f16318a = j2;
    }

    @h.m2.f
    private static final int a(long j2, byte b2) {
        return b2.a(j2, c(b2 & 255));
    }

    @i.c.a.d
    public static final /* synthetic */ n1 a(long j2) {
        return new n1(j2);
    }

    public static boolean a(long j2, @i.c.a.e Object obj) {
        return (obj instanceof n1) && j2 == ((n1) obj).a();
    }

    @h.m2.f
    private int b(long j2) {
        return b(this.f16318a, j2);
    }

    @n0
    public static /* synthetic */ void b() {
    }

    @n0
    public static long c(long j2) {
        return j2;
    }

    @h.m2.f
    private static final long c(long j2, byte b2) {
        return c(j2 - c(b2 & 255));
    }

    @h.m2.f
    private static final long d(long j2, byte b2) {
        return c(j2 + c(b2 & 255));
    }

    public static final boolean d(long j2, long j3) {
        return j2 == j3;
    }

    public static int e(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    @h.m2.f
    private static final long e(long j2, long j3) {
        return c(j2 - j3);
    }

    @h.m2.f
    private static final long f(long j2, byte b2) {
        return c(j2 * c(b2 & 255));
    }

    @h.m2.f
    private static final long g(long j2, long j3) {
        return c(j2 + j3);
    }

    @h.m2.f
    private static final byte h(long j2) {
        return (byte) j2;
    }

    @h.m2.f
    private static final long h(long j2, int i2) {
        return c(j2 * c(i2 & 4294967295L));
    }

    @h.m2.f
    private static final long i(long j2, long j3) {
        return b2.c(j2, j3);
    }

    @h.m2.f
    private static final long j(long j2, long j3) {
        return c(j2 * j3);
    }

    @h.m2.f
    private static final int k(long j2) {
        return (int) j2;
    }

    @h.m2.f
    private static final long k(long j2, long j3) {
        return c(j2 ^ j3);
    }

    @h.m2.f
    private static final long l(long j2) {
        return j2;
    }

    @h.m2.f
    private static final short m(long j2) {
        return (short) j2;
    }

    @i.c.a.d
    public static String n(long j2) {
        return b2.b(j2);
    }

    @h.m2.f
    private static final byte o(long j2) {
        return f1.c((byte) j2);
    }

    @h.m2.f
    private static final int p(long j2) {
        return j1.c((int) j2);
    }

    @h.m2.f
    private static final long q(long j2) {
        return j2;
    }

    @h.m2.f
    private static final short r(long j2) {
        return t1.c((short) j2);
    }

    public final /* synthetic */ long a() {
        return this.f16318a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(n1 n1Var) {
        return b(n1Var.a());
    }

    public boolean equals(Object obj) {
        return a(this.f16318a, obj);
    }

    public int hashCode() {
        return e(this.f16318a);
    }

    @i.c.a.d
    public String toString() {
        return n(this.f16318a);
    }

    @h.m2.f
    private static final int a(long j2, short s) {
        return b2.a(j2, c(s & 65535));
    }

    @h.m2.f
    private static int b(long j2, long j3) {
        return b2.a(j2, j3);
    }

    @h.m2.f
    private static final long c(long j2, short s) {
        return c(j2 - c(s & 65535));
    }

    @h.m2.f
    private static final long d(long j2, short s) {
        return c(j2 + c(s & 65535));
    }

    @h.m2.f
    private static final long e(long j2, byte b2) {
        return b2.c(j2, c(b2 & 255));
    }

    @h.m2.f
    private static final long f(long j2, short s) {
        return c(j2 * c(s & 65535));
    }

    @h.m2.f
    private static final long g(long j2, int i2) {
        return c(j2 >>> i2);
    }

    @h.m2.f
    private static final h.v2.w h(long j2, long j3) {
        return new h.v2.w(j2, j3, null);
    }

    @h.m2.f
    private static final double i(long j2) {
        return b2.a(j2);
    }

    @h.m2.f
    private static final float j(long j2) {
        return (float) b2.a(j2);
    }

    @h.m2.f
    private static final int a(long j2, int i2) {
        return b2.a(j2, c(i2 & 4294967295L));
    }

    @h.m2.f
    private static final long b(long j2, byte b2) {
        return b2.b(j2, c(b2 & 255));
    }

    @h.m2.f
    private static final long c(long j2, int i2) {
        return c(j2 - c(i2 & 4294967295L));
    }

    @h.m2.f
    private static final long d(long j2, int i2) {
        return c(j2 + c(i2 & 4294967295L));
    }

    @h.m2.f
    private static final long e(long j2, short s) {
        return b2.c(j2, c(s & 65535));
    }

    @h.m2.f
    private static final long f(long j2) {
        return c(j2 + 1);
    }

    @h.m2.f
    private static final long g(long j2) {
        return c(~j2);
    }

    @h.m2.f
    private static final long a(long j2, long j3) {
        return c(j2 & j3);
    }

    @h.m2.f
    private static final long b(long j2, short s) {
        return b2.b(j2, c(s & 65535));
    }

    @h.m2.f
    private static final long c(long j2, long j3) {
        return b2.b(j2, j3);
    }

    @h.m2.f
    private static final long d(long j2) {
        return c(j2 - 1);
    }

    @h.m2.f
    private static final long e(long j2, int i2) {
        return b2.c(j2, c(i2 & 4294967295L));
    }

    @h.m2.f
    private static final long f(long j2, int i2) {
        return c(j2 << i2);
    }

    @h.m2.f
    private static final long b(long j2, int i2) {
        return b2.b(j2, c(i2 & 4294967295L));
    }

    @h.m2.f
    private static final long f(long j2, long j3) {
        return c(j2 | j3);
    }
}

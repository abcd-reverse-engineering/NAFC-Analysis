package h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;

/* compiled from: UByte.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u000fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0012J\u001b\u0010)\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0012J\u001b\u00100\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u000fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0012J\u001b\u00109\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0012J\u001b\u0010>\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bD\u0010\u0005J\u0010\u0010E\u001a\u00020FH\u0087\b¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020JH\u0087\b¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\rH\u0087\b¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020QH\u0087\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b]\u0010\u0005J\u0013\u0010^\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010OJ\u0013\u0010`\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\ba\u0010SJ\u0013\u0010b\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010WJ\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@k
/* loaded from: classes2.dex */
public final class f1 implements Comparable<f1> {

    /* renamed from: b, reason: collision with root package name */
    public static final byte f16098b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final byte f16099c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f16100d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f16101e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final a f16102f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final byte f16103a;

    /* compiled from: UByte.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    @n0
    private /* synthetic */ f1(byte b2) {
        this.f16103a = b2;
    }

    @h.m2.f
    private static final int a(byte b2, short s) {
        return h.q2.t.i0.a(b2 & f16099c, s & t1.f16480c);
    }

    @i.c.a.d
    public static final /* synthetic */ f1 a(byte b2) {
        return new f1(b2);
    }

    public static boolean a(byte b2, @i.c.a.e Object obj) {
        return (obj instanceof f1) && b2 == ((f1) obj).a();
    }

    @h.m2.f
    private int b(byte b2) {
        return b(this.f16103a, b2);
    }

    @n0
    public static /* synthetic */ void b() {
    }

    @n0
    public static byte c(byte b2) {
        return b2;
    }

    @h.m2.f
    private static final int c(byte b2, short s) {
        return j1.c(j1.c(b2 & f16099c) - j1.c(s & t1.f16480c));
    }

    @h.m2.f
    private static final int d(byte b2, short s) {
        return j1.c(j1.c(b2 & f16099c) + j1.c(s & t1.f16480c));
    }

    public static final boolean d(byte b2, byte b3) {
        return b2 == b3;
    }

    public static int e(byte b2) {
        return b2;
    }

    @h.m2.f
    private static final int e(byte b2, byte b3) {
        return j1.c(j1.c(b2 & f16099c) - j1.c(b3 & f16099c));
    }

    @h.m2.f
    private static final int f(byte b2, short s) {
        return j1.c(j1.c(b2 & f16099c) * j1.c(s & t1.f16480c));
    }

    @h.m2.f
    private static final int g(byte b2, byte b3) {
        return j1.c(j1.c(b2 & f16099c) + j1.c(b3 & f16099c));
    }

    @h.m2.f
    private static final byte h(byte b2) {
        return b2;
    }

    @h.m2.f
    private static final h.v2.t h(byte b2, byte b3) {
        return new h.v2.t(j1.c(b2 & f16099c), j1.c(b3 & f16099c), null);
    }

    @h.m2.f
    private static final double i(byte b2) {
        return b2 & f16099c;
    }

    @h.m2.f
    private static final int i(byte b2, byte b3) {
        return b2.c(j1.c(b2 & f16099c), j1.c(b3 & f16099c));
    }

    @h.m2.f
    private static final float j(byte b2) {
        return b2 & f16099c;
    }

    @h.m2.f
    private static final int j(byte b2, byte b3) {
        return j1.c(j1.c(b2 & f16099c) * j1.c(b3 & f16099c));
    }

    @h.m2.f
    private static final byte k(byte b2, byte b3) {
        return c((byte) (b2 ^ b3));
    }

    @h.m2.f
    private static final int k(byte b2) {
        return b2 & f16099c;
    }

    @h.m2.f
    private static final long l(byte b2) {
        return b2 & 255;
    }

    @h.m2.f
    private static final short m(byte b2) {
        return (short) (b2 & 255);
    }

    @i.c.a.d
    public static String n(byte b2) {
        return String.valueOf(b2 & f16099c);
    }

    @h.m2.f
    private static final byte o(byte b2) {
        return b2;
    }

    @h.m2.f
    private static final int p(byte b2) {
        return j1.c(b2 & f16099c);
    }

    @h.m2.f
    private static final long q(byte b2) {
        return n1.c(b2 & 255);
    }

    @h.m2.f
    private static final short r(byte b2) {
        return t1.c((short) (b2 & 255));
    }

    public final /* synthetic */ byte a() {
        return this.f16103a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(f1 f1Var) {
        return b(f1Var.a());
    }

    public boolean equals(Object obj) {
        return a(this.f16103a, obj);
    }

    public int hashCode() {
        return e(this.f16103a);
    }

    @i.c.a.d
    public String toString() {
        return n(this.f16103a);
    }

    @h.m2.f
    private static final int a(byte b2, int i2) {
        return b2.a(j1.c(b2 & f16099c), i2);
    }

    @h.m2.f
    private static int b(byte b2, byte b3) {
        return h.q2.t.i0.a(b2 & f16099c, b3 & f16099c);
    }

    @h.m2.f
    private static final int c(byte b2, int i2) {
        return j1.c(j1.c(b2 & f16099c) - i2);
    }

    @h.m2.f
    private static final int d(byte b2, int i2) {
        return j1.c(j1.c(b2 & f16099c) + i2);
    }

    @h.m2.f
    private static final int e(byte b2, short s) {
        return b2.c(j1.c(b2 & f16099c), j1.c(s & t1.f16480c));
    }

    @h.m2.f
    private static final int f(byte b2, int i2) {
        return j1.c(j1.c(b2 & f16099c) * i2);
    }

    @h.m2.f
    private static final byte g(byte b2) {
        return c((byte) (~b2));
    }

    @h.m2.f
    private static final int a(byte b2, long j2) {
        return b2.a(n1.c(b2 & 255), j2);
    }

    @h.m2.f
    private static final int b(byte b2, short s) {
        return b2.b(j1.c(b2 & f16099c), j1.c(s & t1.f16480c));
    }

    @h.m2.f
    private static final long c(byte b2, long j2) {
        return n1.c(n1.c(b2 & 255) - j2);
    }

    @h.m2.f
    private static final long d(byte b2, long j2) {
        return n1.c(n1.c(b2 & 255) + j2);
    }

    @h.m2.f
    private static final int e(byte b2, int i2) {
        return b2.c(j1.c(b2 & f16099c), i2);
    }

    @h.m2.f
    private static final long f(byte b2, long j2) {
        return n1.c(n1.c(b2 & 255) * j2);
    }

    @h.m2.f
    private static final byte a(byte b2, byte b3) {
        return c((byte) (b2 & b3));
    }

    @h.m2.f
    private static final int b(byte b2, int i2) {
        return b2.b(j1.c(b2 & f16099c), i2);
    }

    @h.m2.f
    private static final int c(byte b2, byte b3) {
        return b2.b(j1.c(b2 & f16099c), j1.c(b3 & f16099c));
    }

    @h.m2.f
    private static final byte d(byte b2) {
        return c((byte) (b2 - 1));
    }

    @h.m2.f
    private static final long e(byte b2, long j2) {
        return b2.c(n1.c(b2 & 255), j2);
    }

    @h.m2.f
    private static final byte f(byte b2) {
        return c((byte) (b2 + 1));
    }

    @h.m2.f
    private static final long b(byte b2, long j2) {
        return b2.b(n1.c(b2 & 255), j2);
    }

    @h.m2.f
    private static final byte f(byte b2, byte b3) {
        return c((byte) (b2 | b3));
    }
}

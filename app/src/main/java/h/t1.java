package h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;

/* compiled from: UShort.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0010J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0010J\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0013J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0010J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0013J\u001b\u00109\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0010J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0013J\u001b\u0010>\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020DH\u0087\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020HH\u0087\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020LH\u0087\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\rH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b]\u0010FJ\u0013\u0010^\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010QJ\u0013\u0010`\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\ba\u0010UJ\u0013\u0010b\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005J\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@k
/* loaded from: classes2.dex */
public final class t1 implements Comparable<t1> {

    /* renamed from: b, reason: collision with root package name */
    public static final short f16479b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final short f16480c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f16481d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f16482e = 16;

    /* renamed from: f, reason: collision with root package name */
    public static final a f16483f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final short f16484a;

    /* compiled from: UShort.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    @n0
    private /* synthetic */ t1(short s) {
        this.f16484a = s;
    }

    @h.m2.f
    private static final int a(short s, byte b2) {
        return h.q2.t.i0.a(s & f16480c, b2 & f1.f16099c);
    }

    @i.c.a.d
    public static final /* synthetic */ t1 a(short s) {
        return new t1(s);
    }

    public static boolean a(short s, @i.c.a.e Object obj) {
        return (obj instanceof t1) && s == ((t1) obj).a();
    }

    @h.m2.f
    private int b(short s) {
        return b(this.f16484a, s);
    }

    @n0
    public static /* synthetic */ void b() {
    }

    @h.m2.f
    private static final int c(short s, byte b2) {
        return j1.c(j1.c(s & f16480c) - j1.c(b2 & f1.f16099c));
    }

    @n0
    public static short c(short s) {
        return s;
    }

    @h.m2.f
    private static final int d(short s, byte b2) {
        return j1.c(j1.c(s & f16480c) + j1.c(b2 & f1.f16099c));
    }

    public static final boolean d(short s, short s2) {
        return s == s2;
    }

    public static int e(short s) {
        return s;
    }

    @h.m2.f
    private static final int e(short s, short s2) {
        return j1.c(j1.c(s & f16480c) - j1.c(s2 & f16480c));
    }

    @h.m2.f
    private static final int f(short s, byte b2) {
        return j1.c(j1.c(s & f16480c) * j1.c(b2 & f1.f16099c));
    }

    @h.m2.f
    private static final int g(short s, short s2) {
        return j1.c(j1.c(s & f16480c) + j1.c(s2 & f16480c));
    }

    @h.m2.f
    private static final byte h(short s) {
        return (byte) s;
    }

    @h.m2.f
    private static final h.v2.t h(short s, short s2) {
        return new h.v2.t(j1.c(s & f16480c), j1.c(s2 & f16480c), null);
    }

    @h.m2.f
    private static final double i(short s) {
        return s & f16480c;
    }

    @h.m2.f
    private static final int i(short s, short s2) {
        return b2.c(j1.c(s & f16480c), j1.c(s2 & f16480c));
    }

    @h.m2.f
    private static final float j(short s) {
        return s & f16480c;
    }

    @h.m2.f
    private static final int j(short s, short s2) {
        return j1.c(j1.c(s & f16480c) * j1.c(s2 & f16480c));
    }

    @h.m2.f
    private static final int k(short s) {
        return s & f16480c;
    }

    @h.m2.f
    private static final short k(short s, short s2) {
        return c((short) (s ^ s2));
    }

    @h.m2.f
    private static final long l(short s) {
        return s & 65535;
    }

    @h.m2.f
    private static final short m(short s) {
        return s;
    }

    @i.c.a.d
    public static String n(short s) {
        return String.valueOf(s & f16480c);
    }

    @h.m2.f
    private static final byte o(short s) {
        return f1.c((byte) s);
    }

    @h.m2.f
    private static final int p(short s) {
        return j1.c(s & f16480c);
    }

    @h.m2.f
    private static final long q(short s) {
        return n1.c(s & 65535);
    }

    @h.m2.f
    private static final short r(short s) {
        return s;
    }

    public final /* synthetic */ short a() {
        return this.f16484a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(t1 t1Var) {
        return b(t1Var.a());
    }

    public boolean equals(Object obj) {
        return a(this.f16484a, obj);
    }

    public int hashCode() {
        return e(this.f16484a);
    }

    @i.c.a.d
    public String toString() {
        return n(this.f16484a);
    }

    @h.m2.f
    private static final int a(short s, int i2) {
        return b2.a(j1.c(s & f16480c), i2);
    }

    @h.m2.f
    private static int b(short s, short s2) {
        return h.q2.t.i0.a(s & f16480c, s2 & f16480c);
    }

    @h.m2.f
    private static final int c(short s, int i2) {
        return j1.c(j1.c(s & f16480c) - i2);
    }

    @h.m2.f
    private static final int d(short s, int i2) {
        return j1.c(j1.c(s & f16480c) + i2);
    }

    @h.m2.f
    private static final int e(short s, byte b2) {
        return b2.c(j1.c(s & f16480c), j1.c(b2 & f1.f16099c));
    }

    @h.m2.f
    private static final int f(short s, int i2) {
        return j1.c(j1.c(s & f16480c) * i2);
    }

    @h.m2.f
    private static final short g(short s) {
        return c((short) (~s));
    }

    @h.m2.f
    private static final int a(short s, long j2) {
        return b2.a(n1.c(s & 65535), j2);
    }

    @h.m2.f
    private static final int b(short s, byte b2) {
        return b2.b(j1.c(s & f16480c), j1.c(b2 & f1.f16099c));
    }

    @h.m2.f
    private static final long c(short s, long j2) {
        return n1.c(n1.c(s & 65535) - j2);
    }

    @h.m2.f
    private static final long d(short s, long j2) {
        return n1.c(n1.c(s & 65535) + j2);
    }

    @h.m2.f
    private static final int e(short s, int i2) {
        return b2.c(j1.c(s & f16480c), i2);
    }

    @h.m2.f
    private static final long f(short s, long j2) {
        return n1.c(n1.c(s & 65535) * j2);
    }

    @h.m2.f
    private static final short a(short s, short s2) {
        return c((short) (s & s2));
    }

    @h.m2.f
    private static final int b(short s, int i2) {
        return b2.b(j1.c(s & f16480c), i2);
    }

    @h.m2.f
    private static final int c(short s, short s2) {
        return b2.b(j1.c(s & f16480c), j1.c(s2 & f16480c));
    }

    @h.m2.f
    private static final short d(short s) {
        return c((short) (s - 1));
    }

    @h.m2.f
    private static final long e(short s, long j2) {
        return b2.c(n1.c(s & 65535), j2);
    }

    @h.m2.f
    private static final short f(short s) {
        return c((short) (s + 1));
    }

    @h.m2.f
    private static final long b(short s, long j2) {
        return b2.b(n1.c(s & 65535), j2);
    }

    @h.m2.f
    private static final short f(short s, short s2) {
        return c((short) (s | s2));
    }
}

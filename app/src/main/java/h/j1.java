package h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;

/* compiled from: UInt.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001jB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0013\u0010#\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b$\u0010\u0005J\u0013\u0010%\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u000fJ\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u000bJ\u001b\u0010'\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u001dJ\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0016J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b-\u0010\u000bJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u000fJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000bJ\u001b\u0010.\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u001dJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0016J\u001b\u00103\u001a\u0002042\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\u000fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010\u000bJ\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u001dJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0016J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\b@\u0010\u000bJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u000fJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u000bJ\u001b\u0010A\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001dJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u0016J\u0010\u0010F\u001a\u00020GH\u0087\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020]H\u0016¢\u0006\u0004\b^\u0010_J\u0013\u0010`\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\ba\u0010IJ\u0013\u0010b\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005J\u0013\u0010d\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\be\u0010WJ\u0013\u0010f\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bg\u0010[J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bi\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006k"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@k
/* loaded from: classes2.dex */
public final class j1 implements Comparable<j1> {

    /* renamed from: b, reason: collision with root package name */
    public static final int f16232b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f16233c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f16234d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f16235e = 32;

    /* renamed from: f, reason: collision with root package name */
    public static final a f16236f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f16237a;

    /* compiled from: UInt.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    @n0
    private /* synthetic */ j1(int i2) {
        this.f16237a = i2;
    }

    @h.m2.f
    private static final int a(int i2, byte b2) {
        return b2.a(i2, c(b2 & f1.f16099c));
    }

    @i.c.a.d
    public static final /* synthetic */ j1 a(int i2) {
        return new j1(i2);
    }

    public static boolean a(int i2, @i.c.a.e Object obj) {
        return (obj instanceof j1) && i2 == ((j1) obj).a();
    }

    @h.m2.f
    private int b(int i2) {
        return b(this.f16237a, i2);
    }

    @n0
    public static /* synthetic */ void b() {
    }

    @n0
    public static int c(int i2) {
        return i2;
    }

    @h.m2.f
    private static final int c(int i2, byte b2) {
        return c(i2 - c(b2 & f1.f16099c));
    }

    @h.m2.f
    private static final int d(int i2, byte b2) {
        return c(i2 + c(b2 & f1.f16099c));
    }

    public static final boolean d(int i2, int i3) {
        return i2 == i3;
    }

    public static int e(int i2) {
        return i2;
    }

    @h.m2.f
    private static final int e(int i2, int i3) {
        return c(i2 - i3);
    }

    @h.m2.f
    private static final int f(int i2, byte b2) {
        return c(i2 * c(b2 & f1.f16099c));
    }

    @h.m2.f
    private static final int g(int i2, int i3) {
        return c(i2 + i3);
    }

    @h.m2.f
    private static final byte h(int i2) {
        return (byte) i2;
    }

    @h.m2.f
    private static final h.v2.t h(int i2, int i3) {
        return new h.v2.t(i2, i3, null);
    }

    @h.m2.f
    private static final int i(int i2, int i3) {
        return b2.c(i2, i3);
    }

    @h.m2.f
    private static final int j(int i2, int i3) {
        return c(i2 << i3);
    }

    @h.m2.f
    private static final int k(int i2) {
        return i2;
    }

    @h.m2.f
    private static final int k(int i2, int i3) {
        return c(i2 >>> i3);
    }

    @h.m2.f
    private static final int l(int i2, int i3) {
        return c(i2 * i3);
    }

    @h.m2.f
    private static final long l(int i2) {
        return i2 & 4294967295L;
    }

    @h.m2.f
    private static final int m(int i2, int i3) {
        return c(i2 ^ i3);
    }

    @h.m2.f
    private static final short m(int i2) {
        return (short) i2;
    }

    @i.c.a.d
    public static String n(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    @h.m2.f
    private static final byte o(int i2) {
        return f1.c((byte) i2);
    }

    @h.m2.f
    private static final int p(int i2) {
        return i2;
    }

    @h.m2.f
    private static final long q(int i2) {
        return n1.c(i2 & 4294967295L);
    }

    @h.m2.f
    private static final short r(int i2) {
        return t1.c((short) i2);
    }

    public final /* synthetic */ int a() {
        return this.f16237a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(j1 j1Var) {
        return b(j1Var.a());
    }

    public boolean equals(Object obj) {
        return a(this.f16237a, obj);
    }

    public int hashCode() {
        return e(this.f16237a);
    }

    @i.c.a.d
    public String toString() {
        return n(this.f16237a);
    }

    @h.m2.f
    private static final int a(int i2, short s) {
        return b2.a(i2, c(s & t1.f16480c));
    }

    @h.m2.f
    private static int b(int i2, int i3) {
        return b2.a(i2, i3);
    }

    @h.m2.f
    private static final int c(int i2, short s) {
        return c(i2 - c(s & t1.f16480c));
    }

    @h.m2.f
    private static final int d(int i2, short s) {
        return c(i2 + c(s & t1.f16480c));
    }

    @h.m2.f
    private static final int e(int i2, byte b2) {
        return b2.c(i2, c(b2 & f1.f16099c));
    }

    @h.m2.f
    private static final int f(int i2, short s) {
        return c(i2 * c(s & t1.f16480c));
    }

    @h.m2.f
    private static final int g(int i2) {
        return c(~i2);
    }

    @h.m2.f
    private static final double i(int i2) {
        return b2.a(i2);
    }

    @h.m2.f
    private static final float j(int i2) {
        return (float) b2.a(i2);
    }

    @h.m2.f
    private static final int a(int i2, long j2) {
        return b2.a(n1.c(i2 & 4294967295L), j2);
    }

    @h.m2.f
    private static final int b(int i2, byte b2) {
        return b2.b(i2, c(b2 & f1.f16099c));
    }

    @h.m2.f
    private static final long c(int i2, long j2) {
        return n1.c(n1.c(i2 & 4294967295L) - j2);
    }

    @h.m2.f
    private static final long d(int i2, long j2) {
        return n1.c(n1.c(i2 & 4294967295L) + j2);
    }

    @h.m2.f
    private static final int e(int i2, short s) {
        return b2.c(i2, c(s & t1.f16480c));
    }

    @h.m2.f
    private static final long f(int i2, long j2) {
        return n1.c(n1.c(i2 & 4294967295L) * j2);
    }

    @h.m2.f
    private static final int a(int i2, int i3) {
        return c(i2 & i3);
    }

    @h.m2.f
    private static final int b(int i2, short s) {
        return b2.b(i2, c(s & t1.f16480c));
    }

    @h.m2.f
    private static final int c(int i2, int i3) {
        return b2.b(i2, i3);
    }

    @h.m2.f
    private static final int d(int i2) {
        return c(i2 - 1);
    }

    @h.m2.f
    private static final long e(int i2, long j2) {
        return b2.c(n1.c(i2 & 4294967295L), j2);
    }

    @h.m2.f
    private static final int f(int i2) {
        return c(i2 + 1);
    }

    @h.m2.f
    private static final long b(int i2, long j2) {
        return b2.b(n1.c(i2 & 4294967295L), j2);
    }

    @h.m2.f
    private static final int f(int i2, int i3) {
        return c(i2 | i3);
    }
}

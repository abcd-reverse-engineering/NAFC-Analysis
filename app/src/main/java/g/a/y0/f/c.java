package g.a.y0.f;

import g.a.t0.g;
import g.a.y0.c.n;
import g.a.y0.j.t;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes2.dex */
public final class c<T> implements n<T> {

    /* renamed from: i, reason: collision with root package name */
    static final int f15886i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f15887j = new Object();

    /* renamed from: b, reason: collision with root package name */
    int f15889b;

    /* renamed from: c, reason: collision with root package name */
    long f15890c;

    /* renamed from: d, reason: collision with root package name */
    final int f15891d;

    /* renamed from: e, reason: collision with root package name */
    AtomicReferenceArray<Object> f15892e;

    /* renamed from: f, reason: collision with root package name */
    final int f15893f;

    /* renamed from: g, reason: collision with root package name */
    AtomicReferenceArray<Object> f15894g;

    /* renamed from: a, reason: collision with root package name */
    final AtomicLong f15888a = new AtomicLong();

    /* renamed from: h, reason: collision with root package name */
    final AtomicLong f15895h = new AtomicLong();

    public c(int i2) {
        int iB = t.b(Math.max(8, i2));
        int i3 = iB - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iB + 1);
        this.f15892e = atomicReferenceArray;
        this.f15891d = i3;
        a(iB);
        this.f15894g = atomicReferenceArray;
        this.f15893f = i3;
        this.f15890c = i3 - 1;
        b(0L);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        a(atomicReferenceArray, i2, t);
        b(j2 + 1);
        return true;
    }

    private static int b(int i2) {
        return i2;
    }

    private AtomicReferenceArray<Object> b(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int iB = b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) a(atomicReferenceArray, iB);
        a(atomicReferenceArray, iB, (Object) null);
        return atomicReferenceArray2;
    }

    private long c() {
        return this.f15895h.get();
    }

    private long d() {
        return this.f15888a.get();
    }

    private long e() {
        return this.f15895h.get();
    }

    private long f() {
        return this.f15888a.get();
    }

    @Override // g.a.y0.c.o
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return f() == e();
    }

    @Override // g.a.y0.c.o
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f15892e;
        long jD = d();
        int i2 = this.f15891d;
        int iA = a(jD, i2);
        if (jD < this.f15890c) {
            return a(atomicReferenceArray, t, jD, iA);
        }
        long j2 = this.f15889b + jD;
        if (a(atomicReferenceArray, a(j2, i2)) == null) {
            this.f15890c = j2 - 1;
            return a(atomicReferenceArray, t, jD, iA);
        }
        if (a(atomicReferenceArray, a(1 + jD, i2)) == null) {
            return a(atomicReferenceArray, t, jD, iA);
        }
        a(atomicReferenceArray, jD, iA, t, i2);
        return true;
    }

    @Override // g.a.y0.c.n, g.a.y0.c.o
    @g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f15894g;
        long jC = c();
        int i2 = this.f15893f;
        int iA = a(jC, i2);
        T t = (T) a(atomicReferenceArray, iA);
        boolean z = t == f15887j;
        if (t == null || z) {
            if (z) {
                return b(b(atomicReferenceArray, i2 + 1), jC, i2);
            }
            return null;
        }
        a(atomicReferenceArray, iA, (Object) null);
        a(jC + 1);
        return t;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f15892e = atomicReferenceArray2;
        this.f15890c = (j3 + j2) - 1;
        a(atomicReferenceArray2, i2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i2, f15887j);
        b(j2 + 1);
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f15894g = atomicReferenceArray;
        int iA = a(j2, i2);
        T t = (T) a(atomicReferenceArray, iA);
        if (t != null) {
            a(atomicReferenceArray, iA, (Object) null);
            a(j2 + 1);
        }
        return t;
    }

    public int b() {
        long jE = e();
        while (true) {
            long jF = f();
            long jE2 = e();
            if (jE == jE2) {
                return (int) (jF - jE2);
            }
            jE = jE2;
        }
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void b(long j2) {
        this.f15888a.lazySet(j2);
    }

    public T a() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f15894g;
        long jC = c();
        int i2 = this.f15893f;
        T t = (T) a(atomicReferenceArray, a(jC, i2));
        return t == f15887j ? a(b(atomicReferenceArray, i2 + 1), jC, i2) : t;
    }

    @Override // g.a.y0.c.o
    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f15892e;
        long jF = f();
        int i2 = this.f15891d;
        long j2 = 2 + jF;
        if (a(atomicReferenceArray, a(j2, i2)) == null) {
            int iA = a(jF, i2);
            a(atomicReferenceArray, iA + 1, t2);
            a(atomicReferenceArray, iA, t);
            b(j2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f15892e = atomicReferenceArray2;
        int iA2 = a(jF, i2);
        a(atomicReferenceArray2, iA2 + 1, t2);
        a(atomicReferenceArray2, iA2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, iA2, f15887j);
        b(j2);
        return true;
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f15894g = atomicReferenceArray;
        return (T) a(atomicReferenceArray, a(j2, i2));
    }

    private void a(int i2) {
        this.f15889b = Math.min(i2 / 4, f15886i);
    }

    private void a(long j2) {
        this.f15895h.lazySet(j2);
    }

    private static int a(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }
}

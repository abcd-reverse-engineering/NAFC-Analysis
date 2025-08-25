package h;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* compiled from: ULongArray.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0096\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "storage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", DispatchConstants.OTHER, "", "get", "index", "get-impl", "([JI)J", "hashCode", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "Lkotlin/collections/ULongIterator;", "iterator-impl", "([J)Lkotlin/collections/ULongIterator;", "set", "", SurveyH5Bean.VALUE, "set-k8EXiF4", "([JIJ)V", "toString", "", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@k
/* loaded from: classes2.dex */
public final class o1 implements Collection<n1>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final long[] f16358a;

    /* compiled from: ULongArray.kt */
    private static final class a extends h.g2.y1 {

        /* renamed from: a, reason: collision with root package name */
        private int f16359a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f16360b;

        public a(@i.c.a.d long[] jArr) {
            h.q2.t.i0.f(jArr, "array");
            this.f16360b = jArr;
        }

        @Override // h.g2.y1
        public long b() {
            int i2 = this.f16359a;
            long[] jArr = this.f16360b;
            if (i2 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(i2));
            }
            this.f16359a = i2 + 1;
            return n1.c(jArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16359a < this.f16360b.length;
        }
    }

    @n0
    private /* synthetic */ o1(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "storage");
        this.f16358a = jArr;
    }

    @i.c.a.d
    public static final /* synthetic */ o1 a(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "v");
        return new o1(jArr);
    }

    public static boolean a(long[] jArr, @i.c.a.e Object obj) {
        return (obj instanceof o1) && h.q2.t.i0.a(jArr, ((o1) obj).c());
    }

    public static final boolean a(@i.c.a.d long[] jArr, @i.c.a.d long[] jArr2) {
        return h.q2.t.i0.a(jArr, jArr2);
    }

    @i.c.a.d
    public static long[] a(int i2) {
        return b(new long[i2]);
    }

    @n0
    @i.c.a.d
    public static long[] b(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "storage");
        return jArr;
    }

    public static int c(long[] jArr) {
        return jArr.length;
    }

    public static int d(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    @n0
    public static /* synthetic */ void d() {
    }

    public static boolean e(long[] jArr) {
        return jArr.length == 0;
    }

    @i.c.a.d
    public static h.g2.y1 f(long[] jArr) {
        return new a(jArr);
    }

    @i.c.a.d
    public static String g(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ")";
    }

    public boolean a(long j2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(n1 n1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends n1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(long j2) {
        return a(this.f16358a, j2);
    }

    @i.c.a.d
    public final /* synthetic */ long[] c() {
        return this.f16358a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof n1) {
            return b(((n1) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@i.c.a.d Collection<? extends Object> collection) {
        return a(this.f16358a, (Collection<n1>) collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return a(this.f16358a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return d(this.f16358a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return e(this.f16358a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @i.c.a.d
    public h.g2.y1 iterator() {
        return f(this.f16358a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return h.q2.t.u.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) h.q2.t.u.a(this, tArr);
    }

    public String toString() {
        return g(this.f16358a);
    }

    public static final long a(long[] jArr, int i2) {
        return n1.c(jArr[i2]);
    }

    public int b() {
        return c(this.f16358a);
    }

    public static final void a(long[] jArr, int i2, long j2) {
        jArr[i2] = j2;
    }

    public static boolean a(long[] jArr, long j2) {
        return h.g2.r.b(jArr, j2);
    }

    public static boolean a(long[] jArr, @i.c.a.d Collection<n1> collection) {
        h.q2.t.i0.f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof n1) && h.g2.r.b(jArr, ((n1) obj).a()))) {
                return false;
            }
        }
        return true;
    }
}

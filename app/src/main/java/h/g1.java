package h;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* compiled from: UByteArray.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0096\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", "storage", "", "([B)[B", "getSize-impl", "([B)I", "storage$annotations", "()V", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", DispatchConstants.OTHER, "", "get", "index", "get-impl", "([BI)B", "hashCode", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "Lkotlin/collections/UByteIterator;", "iterator-impl", "([B)Lkotlin/collections/UByteIterator;", "set", "", SurveyH5Bean.VALUE, "set-VurrAj0", "([BIB)V", "toString", "", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@t0(version = "1.3")
@k
/* loaded from: classes2.dex */
public final class g1 implements Collection<f1>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final byte[] f16106a;

    /* compiled from: UByteArray.kt */
    private static final class a extends h.g2.u1 {

        /* renamed from: a, reason: collision with root package name */
        private int f16107a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f16108b;

        public a(@i.c.a.d byte[] bArr) {
            h.q2.t.i0.f(bArr, "array");
            this.f16108b = bArr;
        }

        @Override // h.g2.u1
        public byte b() {
            int i2 = this.f16107a;
            byte[] bArr = this.f16108b;
            if (i2 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(i2));
            }
            this.f16107a = i2 + 1;
            return f1.c(bArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16107a < this.f16108b.length;
        }
    }

    @n0
    private /* synthetic */ g1(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "storage");
        this.f16106a = bArr;
    }

    @i.c.a.d
    public static final /* synthetic */ g1 a(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "v");
        return new g1(bArr);
    }

    public static boolean a(byte[] bArr, @i.c.a.e Object obj) {
        return (obj instanceof g1) && h.q2.t.i0.a(bArr, ((g1) obj).c());
    }

    public static final boolean a(@i.c.a.d byte[] bArr, @i.c.a.d byte[] bArr2) {
        return h.q2.t.i0.a(bArr, bArr2);
    }

    @i.c.a.d
    public static byte[] a(int i2) {
        return b(new byte[i2]);
    }

    @n0
    @i.c.a.d
    public static byte[] b(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "storage");
        return bArr;
    }

    public static int c(byte[] bArr) {
        return bArr.length;
    }

    public static int d(byte[] bArr) {
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    @n0
    public static /* synthetic */ void d() {
    }

    public static boolean e(byte[] bArr) {
        return bArr.length == 0;
    }

    @i.c.a.d
    public static h.g2.u1 f(byte[] bArr) {
        return new a(bArr);
    }

    @i.c.a.d
    public static String g(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ")";
    }

    public boolean a(byte b2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(f1 f1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends f1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(byte b2) {
        return a(this.f16106a, b2);
    }

    @i.c.a.d
    public final /* synthetic */ byte[] c() {
        return this.f16106a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof f1) {
            return b(((f1) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@i.c.a.d Collection<? extends Object> collection) {
        return a(this.f16106a, (Collection<f1>) collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return a(this.f16106a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return d(this.f16106a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return e(this.f16106a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @i.c.a.d
    public h.g2.u1 iterator() {
        return f(this.f16106a);
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
        return g(this.f16106a);
    }

    public static final byte a(byte[] bArr, int i2) {
        return f1.c(bArr[i2]);
    }

    public int b() {
        return c(this.f16106a);
    }

    public static final void a(byte[] bArr, int i2, byte b2) {
        bArr[i2] = b2;
    }

    public static boolean a(byte[] bArr, byte b2) {
        return h.g2.r.b(bArr, b2);
    }

    public static boolean a(byte[] bArr, @i.c.a.d Collection<f1> collection) {
        h.q2.t.i0.f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof f1) && h.g2.r.b(bArr, ((f1) obj).a()))) {
                return false;
            }
        }
        return true;
    }
}

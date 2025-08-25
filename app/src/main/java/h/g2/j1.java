package h.g2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* compiled from: SlidingWindow.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlin/collections/RingBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class j1<T> extends d<T> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final int f16143a;

    /* renamed from: b, reason: collision with root package name */
    private int f16144b;

    /* renamed from: c, reason: collision with root package name */
    private int f16145c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f16146d;

    /* compiled from: SlidingWindow.kt */
    public static final class a extends c<T> {

        /* renamed from: c, reason: collision with root package name */
        private int f16147c;

        /* renamed from: d, reason: collision with root package name */
        private int f16148d;

        a() {
            this.f16147c = j1.this.size();
            this.f16148d = j1.this.f16144b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.g2.c
        protected void b() {
            if (this.f16147c == 0) {
                c();
                return;
            }
            b(j1.this.f16146d[this.f16148d]);
            this.f16148d = (this.f16148d + 1) % j1.this.f16143a;
            this.f16147c--;
        }
    }

    public j1(@i.c.a.d Object[] objArr, int i2) {
        h.q2.t.i0.f(objArr, "buffer");
        this.f16146d = objArr;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
        }
        if (i2 <= this.f16146d.length) {
            this.f16143a = this.f16146d.length;
            this.f16145c = i2;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + this.f16146d.length).toString());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t) {
        if (b()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f16146d[(this.f16144b + size()) % this.f16143a] = t;
        this.f16145c = size() + 1;
    }

    @Override // h.g2.d, java.util.List
    public T get(int i2) {
        d.Companion.a(i2, size());
        return (T) this.f16146d[(this.f16144b + i2) % this.f16143a];
    }

    @Override // h.g2.d, h.g2.a
    public int getSize() {
        return this.f16145c;
    }

    @Override // h.g2.d, h.g2.a, java.util.Collection, java.lang.Iterable
    @i.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // h.g2.a, java.util.Collection
    @i.c.a.d
    public <T> T[] toArray(@i.c.a.d T[] tArr) {
        h.q2.t.i0.f(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            h.q2.t.i0.a((Object) tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.f16144b; i3 < size && i4 < this.f16143a; i4++) {
            tArr[i3] = this.f16146d[i4];
            i3++;
        }
        while (i3 < size) {
            tArr[i3] = this.f16146d[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        if (tArr != null) {
            return tArr;
        }
        throw new h.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean b() {
        return size() == this.f16143a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public final j1<T> a(int i2) {
        Object[] array;
        int i3 = this.f16143a;
        int iB = h.v2.q.b(i3 + (i3 >> 1) + 1, i2);
        if (this.f16144b == 0) {
            array = Arrays.copyOf(this.f16146d, iB);
            h.q2.t.i0.a((Object) array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iB]);
        }
        return new j1<>(array, size());
    }

    public final void b(int i2) {
        if (i2 >= 0) {
            if (!(i2 <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
            }
            if (i2 > 0) {
                int i3 = this.f16144b;
                int i4 = (i3 + i2) % this.f16143a;
                if (i3 > i4) {
                    q.b(this.f16146d, (Object) null, i3, this.f16143a);
                    q.b(this.f16146d, (Object) null, 0, i4);
                } else {
                    q.b(this.f16146d, (Object) null, i3, i4);
                }
                this.f16144b = i4;
                this.f16145c = size() - i2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
    }

    public j1(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a(int i2, int i3) {
        return (i2 + i3) % this.f16143a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.g2.a, java.util.Collection
    @i.c.a.d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}

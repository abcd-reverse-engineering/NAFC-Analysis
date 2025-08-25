package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/sequences/SubSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class v<T> implements m<T>, e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16645a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16646b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16647c;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T> f16648a;

        /* renamed from: b, reason: collision with root package name */
        private int f16649b;

        a() {
            this.f16648a = v.this.f16645a.iterator();
        }

        private final void d() {
            while (this.f16649b < v.this.f16646b && this.f16648a.hasNext()) {
                this.f16648a.next();
                this.f16649b++;
            }
        }

        public final void a(int i2) {
            this.f16649b = i2;
        }

        @i.c.a.d
        public final Iterator<T> b() {
            return this.f16648a;
        }

        public final int c() {
            return this.f16649b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d();
            return this.f16649b < v.this.f16647c && this.f16648a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            d();
            if (this.f16649b >= v.this.f16647c) {
                throw new NoSuchElementException();
            }
            this.f16649b++;
            return this.f16648a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@i.c.a.d m<? extends T> mVar, int i2, int i3) {
        i0.f(mVar, "sequence");
        this.f16645a = mVar;
        this.f16646b = i2;
        this.f16647c = i3;
        if (!(this.f16646b >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + this.f16646b).toString());
        }
        if (!(this.f16647c >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + this.f16647c).toString());
        }
        if (this.f16647c >= this.f16646b) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + this.f16647c + " < " + this.f16646b).toString());
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    private final int a() {
        return this.f16647c - this.f16646b;
    }

    @Override // h.x2.e
    @i.c.a.d
    public m<T> b(int i2) {
        return i2 >= a() ? s.b() : new v(this.f16645a, this.f16646b + i2, this.f16647c);
    }

    @Override // h.x2.e
    @i.c.a.d
    public m<T> a(int i2) {
        if (i2 >= a()) {
            return this;
        }
        m<T> mVar = this.f16645a;
        int i3 = this.f16646b;
        return new v(mVar, i3, i2 + i3);
    }
}

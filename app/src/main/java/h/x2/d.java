package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import java.util.Iterator;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/DropSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class d<T> implements m<T>, e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16577a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16578b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T> f16579a;

        /* renamed from: b, reason: collision with root package name */
        private int f16580b;

        a() {
            this.f16579a = d.this.f16577a.iterator();
            this.f16580b = d.this.f16578b;
        }

        private final void d() {
            while (this.f16580b > 0 && this.f16579a.hasNext()) {
                this.f16579a.next();
                this.f16580b--;
            }
        }

        public final void a(int i2) {
            this.f16580b = i2;
        }

        @i.c.a.d
        public final Iterator<T> b() {
            return this.f16579a;
        }

        public final int c() {
            return this.f16580b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d();
            return this.f16579a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            d();
            return this.f16579a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@i.c.a.d m<? extends T> mVar, int i2) {
        i0.f(mVar, "sequence");
        this.f16577a = mVar;
        this.f16578b = i2;
        if (this.f16578b >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + this.f16578b + '.').toString());
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // h.x2.e
    @i.c.a.d
    public m<T> a(int i2) {
        int i3 = this.f16578b;
        int i4 = i3 + i2;
        return i4 < 0 ? new w(this, i2) : new v(this.f16577a, i3, i4);
    }

    @Override // h.x2.e
    @i.c.a.d
    public m<T> b(int i2) {
        int i3 = this.f16578b + i2;
        return i3 < 0 ? new d(this, i2) : new d(this.f16577a, i3);
    }
}

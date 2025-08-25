package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.g2.r0;
import h.q2.t.i0;
import java.util.Iterator;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007H\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/sequences/IndexingSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/collections/IndexedValue;", "sequence", "(Lkotlin/sequences/Sequence;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class k<T> implements m<r0<? extends T>> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16607a;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<r0<? extends T>>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T> f16608a;

        /* renamed from: b, reason: collision with root package name */
        private int f16609b;

        a() {
            this.f16608a = k.this.f16607a.iterator();
        }

        public final void a(int i2) {
            this.f16609b = i2;
        }

        public final int b() {
            return this.f16609b;
        }

        @i.c.a.d
        public final Iterator<T> c() {
            return this.f16608a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16608a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        @i.c.a.d
        public r0<T> next() {
            int i2 = this.f16609b;
            this.f16609b = i2 + 1;
            if (i2 < 0) {
                h.g2.y.f();
            }
            return new r0<>(i2, this.f16608a.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@i.c.a.d m<? extends T> mVar) {
        i0.f(mVar, "sequence");
        this.f16607a = mVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<r0<T>> iterator() {
        return new a();
    }
}

package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import java.util.Iterator;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0096\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/sequences/MergingSequence;", "T1", "T2", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class l<T1, T2, V> implements m<V> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T1> f16611a;

    /* renamed from: b, reason: collision with root package name */
    private final m<T2> f16612b;

    /* renamed from: c, reason: collision with root package name */
    private final h.q2.s.p<T1, T2, V> f16613c;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<V>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T1> f16614a;

        /* renamed from: b, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T2> f16615b;

        a() {
            this.f16614a = l.this.f16611a.iterator();
            this.f16615b = l.this.f16612b.iterator();
        }

        @i.c.a.d
        public final Iterator<T1> b() {
            return this.f16614a;
        }

        @i.c.a.d
        public final Iterator<T2> c() {
            return this.f16615b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16614a.hasNext() && this.f16615b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) l.this.f16613c.invoke(this.f16614a.next(), this.f16615b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@i.c.a.d m<? extends T1> mVar, @i.c.a.d m<? extends T2> mVar2, @i.c.a.d h.q2.s.p<? super T1, ? super T2, ? extends V> pVar) {
        i0.f(mVar, "sequence1");
        i0.f(mVar2, "sequence2");
        i0.f(pVar, "transform");
        this.f16611a = mVar;
        this.f16612b = mVar2;
        this.f16613c = pVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<V> iterator() {
        return new a();
    }
}

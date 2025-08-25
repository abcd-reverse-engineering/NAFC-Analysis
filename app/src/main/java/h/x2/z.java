package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import java.util.Iterator;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/TransformingSequence;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", ExifInterface.LONGITUDE_EAST, "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class z<T, R> implements m<R> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16667a;

    /* renamed from: b, reason: collision with root package name */
    private final h.q2.s.l<T, R> f16668b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T> f16669a;

        a() {
            this.f16669a = z.this.f16667a.iterator();
        }

        @i.c.a.d
        public final Iterator<T> b() {
            return this.f16669a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16669a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) z.this.f16668b.invoke(this.f16669a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(@i.c.a.d m<? extends T> mVar, @i.c.a.d h.q2.s.l<? super T, ? extends R> lVar) {
        i0.f(mVar, "sequence");
        i0.f(lVar, "transformer");
        this.f16667a = mVar;
        this.f16668b = lVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<R> iterator() {
        return new a();
    }

    @i.c.a.d
    public final <E> m<E> a(@i.c.a.d h.q2.s.l<? super R, ? extends Iterator<? extends E>> lVar) {
        i0.f(lVar, "iterator");
        return new i(this.f16667a, this.f16668b, lVar);
    }
}

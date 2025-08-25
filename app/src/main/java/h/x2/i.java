package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/FlatteningSequence;", ExifInterface.GPS_DIRECTION_TRUE, "R", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class i<T, R, E> implements m<E> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16596a;

    /* renamed from: b, reason: collision with root package name */
    private final h.q2.s.l<T, R> f16597b;

    /* renamed from: c, reason: collision with root package name */
    private final h.q2.s.l<R, Iterator<E>> f16598c;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<E>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T> f16599a;

        /* renamed from: b, reason: collision with root package name */
        @i.c.a.e
        private Iterator<? extends E> f16600b;

        a() {
            this.f16599a = i.this.f16596a.iterator();
        }

        private final boolean d() {
            Iterator<? extends E> it = this.f16600b;
            if (it != null && !it.hasNext()) {
                this.f16600b = null;
            }
            while (true) {
                if (this.f16600b != null) {
                    break;
                }
                if (!this.f16599a.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) i.this.f16598c.invoke(i.this.f16597b.invoke(this.f16599a.next()));
                if (it2.hasNext()) {
                    this.f16600b = it2;
                    break;
                }
            }
            return true;
        }

        public final void a(@i.c.a.e Iterator<? extends E> it) {
            this.f16600b = it;
        }

        @i.c.a.e
        public final Iterator<E> b() {
            return this.f16600b;
        }

        @i.c.a.d
        public final Iterator<T> c() {
            return this.f16599a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return d();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!d()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f16600b;
            if (it == null) {
                i0.f();
            }
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@i.c.a.d m<? extends T> mVar, @i.c.a.d h.q2.s.l<? super T, ? extends R> lVar, @i.c.a.d h.q2.s.l<? super R, ? extends Iterator<? extends E>> lVar2) {
        i0.f(mVar, "sequence");
        i0.f(lVar, "transformer");
        i0.f(lVar2, "iterator");
        this.f16596a = mVar;
        this.f16597b = lVar;
        this.f16598c = lVar2;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<E> iterator() {
        return new a();
    }
}

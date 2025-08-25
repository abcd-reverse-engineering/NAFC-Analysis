package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.e1;
import h.q2.t.i0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/GeneratorSequence;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class j<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final h.q2.s.a<T> f16602a;

    /* renamed from: b, reason: collision with root package name */
    private final h.q2.s.l<T, T> f16603b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.e
        private T f16604a;

        /* renamed from: b, reason: collision with root package name */
        private int f16605b = -2;

        a() {
        }

        private final void d() {
            T t;
            if (this.f16605b == -2) {
                t = (T) j.this.f16602a.invoke();
            } else {
                h.q2.s.l lVar = j.this.f16603b;
                T t2 = this.f16604a;
                if (t2 == null) {
                    i0.f();
                }
                t = (T) lVar.invoke(t2);
            }
            this.f16604a = t;
            this.f16605b = this.f16604a == null ? 0 : 1;
        }

        public final void a(int i2) {
            this.f16605b = i2;
        }

        @i.c.a.e
        public final T b() {
            return this.f16604a;
        }

        public final int c() {
            return this.f16605b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16605b < 0) {
                d();
            }
            return this.f16605b == 1;
        }

        @Override // java.util.Iterator
        @i.c.a.d
        public T next() {
            if (this.f16605b < 0) {
                d();
            }
            if (this.f16605b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f16604a;
            if (t == null) {
                throw new e1("null cannot be cast to non-null type T");
            }
            this.f16605b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void b(@i.c.a.e T t) {
            this.f16604a = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@i.c.a.d h.q2.s.a<? extends T> aVar, @i.c.a.d h.q2.s.l<? super T, ? extends T> lVar) {
        i0.f(aVar, "getInitialValue");
        i0.f(lVar, "getNextValue");
        this.f16602a = aVar;
        this.f16603b = lVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }
}

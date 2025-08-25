package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/FilteringSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class h<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16589a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16590b;

    /* renamed from: c, reason: collision with root package name */
    private final h.q2.s.l<T, Boolean> f16591c;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T> f16592a;

        /* renamed from: b, reason: collision with root package name */
        private int f16593b = -1;

        /* renamed from: c, reason: collision with root package name */
        @i.c.a.e
        private T f16594c;

        a() {
            this.f16592a = h.this.f16589a.iterator();
        }

        private final void e() {
            while (this.f16592a.hasNext()) {
                T next = this.f16592a.next();
                if (((Boolean) h.this.f16591c.invoke(next)).booleanValue() == h.this.f16590b) {
                    this.f16594c = next;
                    this.f16593b = 1;
                    return;
                }
            }
            this.f16593b = 0;
        }

        public final void a(int i2) {
            this.f16593b = i2;
        }

        @i.c.a.d
        public final Iterator<T> b() {
            return this.f16592a;
        }

        @i.c.a.e
        public final T c() {
            return this.f16594c;
        }

        public final int d() {
            return this.f16593b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16593b == -1) {
                e();
            }
            return this.f16593b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f16593b == -1) {
                e();
            }
            if (this.f16593b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f16594c;
            this.f16594c = null;
            this.f16593b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void b(@i.c.a.e T t) {
            this.f16594c = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@i.c.a.d m<? extends T> mVar, boolean z, @i.c.a.d h.q2.s.l<? super T, Boolean> lVar) {
        i0.f(mVar, "sequence");
        i0.f(lVar, "predicate");
        this.f16589a = mVar;
        this.f16590b = z;
        this.f16591c = lVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    public /* synthetic */ h(m mVar, boolean z, h.q2.s.l lVar, int i2, h.q2.t.v vVar) {
        this(mVar, (i2 & 2) != 0 ? true : z, lVar);
    }
}

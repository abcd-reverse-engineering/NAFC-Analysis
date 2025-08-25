package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import java.util.Iterator;

/* compiled from: Sequences.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/sequences/DropWhileSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class f<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16582a;

    /* renamed from: b, reason: collision with root package name */
    private final h.q2.s.l<T, Boolean> f16583b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final Iterator<T> f16584a;

        /* renamed from: b, reason: collision with root package name */
        private int f16585b = -1;

        /* renamed from: c, reason: collision with root package name */
        @i.c.a.e
        private T f16586c;

        a() {
            this.f16584a = f.this.f16582a.iterator();
        }

        private final void e() {
            while (this.f16584a.hasNext()) {
                T next = this.f16584a.next();
                if (!((Boolean) f.this.f16583b.invoke(next)).booleanValue()) {
                    this.f16586c = next;
                    this.f16585b = 1;
                    return;
                }
            }
            this.f16585b = 0;
        }

        public final void a(int i2) {
            this.f16585b = i2;
        }

        public final int b() {
            return this.f16585b;
        }

        @i.c.a.d
        public final Iterator<T> c() {
            return this.f16584a;
        }

        @i.c.a.e
        public final T d() {
            return this.f16586c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16585b == -1) {
                e();
            }
            return this.f16585b == 1 || this.f16584a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f16585b == -1) {
                e();
            }
            if (this.f16585b != 1) {
                return this.f16584a.next();
            }
            T t = this.f16586c;
            this.f16586c = null;
            this.f16585b = 0;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void b(@i.c.a.e T t) {
            this.f16586c = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@i.c.a.d m<? extends T> mVar, @i.c.a.d h.q2.s.l<? super T, Boolean> lVar) {
        i0.f(mVar, "sequence");
        i0.f(lVar, "predicate");
        this.f16582a = mVar;
        this.f16583b = lVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<T> iterator() {
        return new a();
    }
}

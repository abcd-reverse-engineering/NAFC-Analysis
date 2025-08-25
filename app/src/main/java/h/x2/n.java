package h.x2;

import h.q0;
import h.q2.t.i0;
import h.r0;
import h.y1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes2.dex */
final class n<T> extends o<T> implements Iterator<T>, h.k2.d<y1>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    private int f16617a;

    /* renamed from: b, reason: collision with root package name */
    private T f16618b;

    /* renamed from: c, reason: collision with root package name */
    private Iterator<? extends T> f16619c;

    /* renamed from: d, reason: collision with root package name */
    @i.c.a.e
    private h.k2.d<? super y1> f16620d;

    private final Throwable c() {
        int i2 = this.f16617a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f16617a);
    }

    private final T d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void a(@i.c.a.e h.k2.d<? super y1> dVar) {
        this.f16620d = dVar;
    }

    @i.c.a.e
    public final h.k2.d<y1> b() {
        return this.f16620d;
    }

    @Override // h.k2.d
    @i.c.a.d
    public h.k2.g getContext() {
        return h.k2.i.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i2 = this.f16617a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator<? extends T> it = this.f16619c;
                if (it == null) {
                    i0.f();
                }
                if (it.hasNext()) {
                    this.f16617a = 2;
                    return true;
                }
                this.f16619c = null;
            }
            this.f16617a = 5;
            h.k2.d<? super y1> dVar = this.f16620d;
            if (dVar == null) {
                i0.f();
            }
            this.f16620d = null;
            y1 y1Var = y1.f16671a;
            q0.a aVar = q0.Companion;
            dVar.resumeWith(q0.m772constructorimpl(y1Var));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i2 = this.f16617a;
        if (i2 == 0 || i2 == 1) {
            return d();
        }
        if (i2 == 2) {
            this.f16617a = 1;
            Iterator<? extends T> it = this.f16619c;
            if (it == null) {
                i0.f();
            }
            return it.next();
        }
        if (i2 != 3) {
            throw c();
        }
        this.f16617a = 0;
        T t = this.f16618b;
        this.f16618b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // h.k2.d
    public void resumeWith(@i.c.a.d Object obj) {
        r0.b(obj);
        this.f16617a = 4;
    }

    @Override // h.x2.o
    @i.c.a.e
    public Object a(T t, @i.c.a.d h.k2.d<? super y1> dVar) {
        this.f16618b = t;
        this.f16617a = 3;
        this.f16620d = dVar;
        Object objB = h.k2.m.d.b();
        if (objB == h.k2.m.d.b()) {
            h.k2.n.a.h.c(dVar);
        }
        return objB == h.k2.m.d.b() ? objB : y1.f16671a;
    }

    @Override // h.x2.o
    @i.c.a.e
    public Object a(@i.c.a.d Iterator<? extends T> it, @i.c.a.d h.k2.d<? super y1> dVar) {
        if (!it.hasNext()) {
            return y1.f16671a;
        }
        this.f16619c = it;
        this.f16617a = 2;
        this.f16620d = dVar;
        Object objB = h.k2.m.d.b();
        if (objB == h.k2.m.d.b()) {
            h.k2.n.a.h.c(dVar);
        }
        return objB == h.k2.m.d.b() ? objB : y1.f16671a;
    }
}

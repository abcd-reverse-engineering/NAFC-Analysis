package h.k2.l;

import bean.SurveyH5Bean;
import h.q2.t.i0;
import h.y1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes2.dex */
final class k<T> extends j<T> implements Iterator<T>, c<y1>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    private int f16265a;

    /* renamed from: b, reason: collision with root package name */
    private T f16266b;

    /* renamed from: c, reason: collision with root package name */
    private Iterator<? extends T> f16267c;

    /* renamed from: d, reason: collision with root package name */
    @i.c.a.e
    private c<? super y1> f16268d;

    private final Throwable c() {
        int i2 = this.f16265a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f16265a);
    }

    private final T d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void a(@i.c.a.e c<? super y1> cVar) {
        this.f16268d = cVar;
    }

    @i.c.a.e
    public final c<y1> b() {
        return this.f16268d;
    }

    @Override // h.k2.l.c
    @i.c.a.d
    public e getContext() {
        return g.f16257b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i2 = this.f16265a;
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
                Iterator<? extends T> it = this.f16267c;
                if (it == null) {
                    i0.f();
                }
                if (it.hasNext()) {
                    this.f16265a = 2;
                    return true;
                }
                this.f16267c = null;
            }
            this.f16265a = 5;
            c<? super y1> cVar = this.f16268d;
            if (cVar == null) {
                i0.f();
            }
            this.f16268d = null;
            cVar.resume(y1.f16671a);
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i2 = this.f16265a;
        if (i2 == 0 || i2 == 1) {
            return d();
        }
        if (i2 == 2) {
            this.f16265a = 1;
            Iterator<? extends T> it = this.f16267c;
            if (it == null) {
                i0.f();
            }
            return it.next();
        }
        if (i2 != 3) {
            throw c();
        }
        this.f16265a = 0;
        T t = this.f16266b;
        this.f16266b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // h.k2.l.c
    public void resumeWithException(@i.c.a.d Throwable th) throws Throwable {
        i0.f(th, "exception");
        throw th;
    }

    @Override // h.k2.l.j
    @i.c.a.e
    public Object a(T t, @i.c.a.d c<? super y1> cVar) {
        this.f16266b = t;
        this.f16265a = 3;
        a(h.k2.l.o.a.b.a(cVar));
        return h.k2.l.n.b.b();
    }

    @Override // h.k2.l.j
    @i.c.a.e
    public Object a(@i.c.a.d Iterator<? extends T> it, @i.c.a.d c<? super y1> cVar) {
        if (!it.hasNext()) {
            return y1.f16671a;
        }
        this.f16267c = it;
        this.f16265a = 2;
        a(h.k2.l.o.a.b.a(cVar));
        return h.k2.l.n.b.b();
    }

    @Override // h.k2.l.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void resume(@i.c.a.d y1 y1Var) {
        i0.f(y1Var, SurveyH5Bean.VALUE);
        this.f16265a = 4;
    }
}

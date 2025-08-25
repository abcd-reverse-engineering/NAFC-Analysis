package h.k2.l.o.a;

import h.e1;
import h.k2.l.c;
import h.k2.l.e;
import h.q2.t.i0;
import h.q2.t.j0;
import h.y1;
import i.c.a.d;

/* compiled from: CoroutineImpl.kt */
/* loaded from: classes2.dex */
public abstract class a extends j0<Object> implements c<Object> {
    private final e _context;
    private c<Object> _facade;

    @h.q2.c
    @i.c.a.e
    protected c<Object> completion;

    @h.q2.c
    protected int label;

    public a(int i2, @i.c.a.e c<Object> cVar) {
        super(i2);
        this.completion = cVar;
        this.label = this.completion != null ? 0 : -1;
        c<Object> cVar2 = this.completion;
        this._context = cVar2 != null ? cVar2.getContext() : null;
    }

    @d
    public c<y1> create(@d c<?> cVar) {
        i0.f(cVar, "completion");
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    @i.c.a.e
    protected abstract Object doResume(@i.c.a.e Object obj, @i.c.a.e Throwable th);

    @Override // h.k2.l.c
    @d
    public e getContext() {
        e eVar = this._context;
        if (eVar == null) {
            i0.f();
        }
        return eVar;
    }

    @d
    public final c<Object> getFacade() {
        if (this._facade == null) {
            e eVar = this._context;
            if (eVar == null) {
                i0.f();
            }
            this._facade = b.a(eVar, this);
        }
        c<Object> cVar = this._facade;
        if (cVar == null) {
            i0.f();
        }
        return cVar;
    }

    @Override // h.k2.l.c
    public void resume(@i.c.a.e Object obj) {
        c<Object> cVar = this.completion;
        if (cVar == null) {
            i0.f();
        }
        try {
            Object objDoResume = doResume(obj, null);
            if (objDoResume != h.k2.l.n.b.b()) {
                if (cVar == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                cVar.resume(objDoResume);
            }
        } catch (Throwable th) {
            cVar.resumeWithException(th);
        }
    }

    @Override // h.k2.l.c
    public void resumeWithException(@d Throwable th) {
        i0.f(th, "exception");
        c<Object> cVar = this.completion;
        if (cVar == null) {
            i0.f();
        }
        try {
            Object objDoResume = doResume(null, th);
            if (objDoResume != h.k2.l.n.b.b()) {
                if (cVar == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                cVar.resume(objDoResume);
            }
        } catch (Throwable th2) {
            cVar.resumeWithException(th2);
        }
    }

    @d
    public c<y1> create(@i.c.a.e Object obj, @d c<?> cVar) {
        i0.f(cVar, "completion");
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}

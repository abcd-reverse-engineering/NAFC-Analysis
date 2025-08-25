package h.k2.n.a;

import h.q0;
import h.q2.t.i0;
import h.r0;
import h.t0;
import h.y1;
import java.io.Serializable;

/* compiled from: ContinuationImpl.kt */
@t0(version = "1.3")
/* loaded from: classes2.dex */
public abstract class a implements h.k2.d<Object>, e, Serializable {

    @i.c.a.e
    private final h.k2.d<Object> completion;

    public a(@i.c.a.e h.k2.d<Object> dVar) {
        this.completion = dVar;
    }

    @i.c.a.d
    public h.k2.d<y1> create(@i.c.a.d h.k2.d<?> dVar) {
        i0.f(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // h.k2.n.a.e
    @i.c.a.e
    public e getCallerFrame() {
        h.k2.d<Object> dVar = this.completion;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    @i.c.a.e
    public final h.k2.d<Object> getCompletion() {
        return this.completion;
    }

    @Override // h.k2.n.a.e
    @i.c.a.e
    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    @i.c.a.e
    protected abstract Object invokeSuspend(@i.c.a.d Object obj);

    protected void releaseIntercepted() {
    }

    @Override // h.k2.d
    public final void resumeWith(@i.c.a.d Object obj) {
        Object objInvokeSuspend;
        Object objM772constructorimpl = obj;
        a aVar = this;
        while (true) {
            h.b(aVar);
            h.k2.d<Object> dVar = aVar.completion;
            if (dVar == null) {
                i0.f();
            }
            try {
                objInvokeSuspend = aVar.invokeSuspend(objM772constructorimpl);
            } catch (Throwable th) {
                q0.a aVar2 = q0.Companion;
                objM772constructorimpl = q0.m772constructorimpl(r0.a(th));
            }
            if (objInvokeSuspend == h.k2.m.d.b()) {
                return;
            }
            q0.a aVar3 = q0.Companion;
            objM772constructorimpl = q0.m772constructorimpl(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar instanceof a)) {
                dVar.resumeWith(objM772constructorimpl);
                return;
            }
            aVar = (a) dVar;
        }
    }

    @i.c.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @i.c.a.d
    public h.k2.d<y1> create(@i.c.a.e Object obj, @i.c.a.d h.k2.d<?> dVar) {
        i0.f(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}

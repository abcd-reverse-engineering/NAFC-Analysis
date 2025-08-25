package h.t2;

import bean.SurveyH5Bean;
import h.q2.t.i0;
import h.w2.m;

/* compiled from: Delegates.kt */
/* loaded from: classes2.dex */
final class b<T> implements e<Object, T> {

    /* renamed from: a, reason: collision with root package name */
    private T f16490a;

    @Override // h.t2.e
    @i.c.a.d
    public T a(@i.c.a.e Object obj, @i.c.a.d m<?> mVar) {
        i0.f(mVar, "property");
        T t = this.f16490a;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + mVar.getName() + " should be initialized before get.");
    }

    @Override // h.t2.e
    public void a(@i.c.a.e Object obj, @i.c.a.d m<?> mVar, @i.c.a.d T t) {
        i0.f(mVar, "property");
        i0.f(t, SurveyH5Bean.VALUE);
        this.f16490a = t;
    }
}

package g.a.y0.e.b;

import java.util.concurrent.TimeUnit;

/* compiled from: FlowableTimeInterval.java */
/* loaded from: classes2.dex */
public final class d4<T> extends g.a.y0.e.b.a<T, g.a.e1.c<T>> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.j0 f14176c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14177d;

    /* compiled from: FlowableTimeInterval.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super g.a.e1.c<T>> f14178a;

        /* renamed from: b, reason: collision with root package name */
        final TimeUnit f14179b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.j0 f14180c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f14181d;

        /* renamed from: e, reason: collision with root package name */
        long f14182e;

        a(i.d.c<? super g.a.e1.c<T>> cVar, TimeUnit timeUnit, g.a.j0 j0Var) {
            this.f14178a = cVar;
            this.f14180c = j0Var;
            this.f14179b = timeUnit;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14181d.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14178a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14178a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            long jA = this.f14180c.a(this.f14179b);
            long j2 = this.f14182e;
            this.f14182e = jA;
            this.f14178a.onNext(new g.a.e1.c(t, jA - j2, this.f14179b));
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14181d, dVar)) {
                this.f14182e = this.f14180c.a(this.f14179b);
                this.f14181d = dVar;
                this.f14178a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14181d.request(j2);
        }
    }

    public d4(g.a.l<T> lVar, TimeUnit timeUnit, g.a.j0 j0Var) {
        super(lVar);
        this.f14176c = j0Var;
        this.f14177d = timeUnit;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super g.a.e1.c<T>> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14177d, this.f14176c));
    }
}

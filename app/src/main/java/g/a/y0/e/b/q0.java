package g.a.y0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableElementAt.java */
/* loaded from: classes2.dex */
public final class q0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14524c;

    /* renamed from: d, reason: collision with root package name */
    final T f14525d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f14526e;

    /* compiled from: FlowableElementAt.java */
    static final class a<T> extends g.a.y0.i.f<T> implements g.a.q<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        i.d.d s;

        a(i.d.c<? super T> cVar, long j2, T t, boolean z) {
            super(cVar);
            this.index = j2;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t = this.defaultValue;
            if (t != null) {
                complete(t);
            } else if (this.errorOnFewer) {
                this.actual.onError(new NoSuchElementException());
            } else {
                this.actual.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.count;
            if (j2 != this.index) {
                this.count = j2 + 1;
                return;
            }
            this.done = true;
            this.s.cancel();
            complete(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public q0(g.a.l<T> lVar, long j2, T t, boolean z) {
        super(lVar);
        this.f14524c = j2;
        this.f14525d = t;
        this.f14526e = z;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14524c, this.f14525d, this.f14526e));
    }
}

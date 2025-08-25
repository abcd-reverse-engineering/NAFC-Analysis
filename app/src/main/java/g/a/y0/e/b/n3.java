package g.a.y0.e.b;

import java.util.ArrayDeque;

/* compiled from: FlowableSkipLast.java */
/* loaded from: classes2.dex */
public final class n3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final int f14421c;

    /* compiled from: FlowableSkipLast.java */
    static final class a<T> extends ArrayDeque<T> implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -3807491841935125653L;
        final i.d.c<? super T> actual;
        i.d.d s;
        final int skip;

        a(i.d.c<? super T> cVar, int i2) {
            super(i2);
            this.actual = cVar;
            this.skip = i2;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext(poll());
            } else {
                this.s.request(1L);
            }
            offer(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.s.request(j2);
        }
    }

    public n3(g.a.l<T> lVar, int i2) {
        super(lVar);
        this.f14421c = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14421c));
    }
}

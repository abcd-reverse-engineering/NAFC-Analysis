package g.a.d1;

import g.a.y0.i.j;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PublishProcessor.java */
/* loaded from: classes2.dex */
public final class d<T> extends c<T> {

    /* renamed from: d, reason: collision with root package name */
    static final a[] f13684d = new a[0];

    /* renamed from: e, reason: collision with root package name */
    static final a[] f13685e = new a[0];

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f13686b = new AtomicReference<>(f13685e);

    /* renamed from: c, reason: collision with root package name */
    Throwable f13687c;

    /* compiled from: PublishProcessor.java */
    static final class a<T> extends AtomicLong implements i.d.d {
        private static final long serialVersionUID = 3562861878281475070L;
        final i.d.c<? super T> actual;
        final d<T> parent;

        a(i.d.c<? super T> cVar, d<T> dVar) {
            this.actual = cVar;
            this.parent = dVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b((a) this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        boolean isFull() {
            return get() == 0;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }

        public void onNext(T t) {
            long j2 = get();
            if (j2 == Long.MIN_VALUE) {
                return;
            }
            if (j2 != 0) {
                this.actual.onNext(t);
                g.a.y0.j.d.d(this, 1L);
            } else {
                cancel();
                this.actual.onError(new g.a.v0.c("Could not emit value due to lack of requests"));
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                g.a.y0.j.d.b(this, j2);
            }
        }
    }

    d() {
    }

    @g.a.t0.d
    public static <T> d<T> Y() {
        return new d<>();
    }

    @Override // g.a.d1.c
    public Throwable T() {
        if (this.f13686b.get() == f13684d) {
            return this.f13687c;
        }
        return null;
    }

    @Override // g.a.d1.c
    public boolean U() {
        return this.f13686b.get() == f13684d && this.f13687c == null;
    }

    @Override // g.a.d1.c
    public boolean V() {
        return this.f13686b.get().length != 0;
    }

    @Override // g.a.d1.c
    public boolean W() {
        return this.f13686b.get() == f13684d && this.f13687c != null;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13686b.get();
            if (aVarArr == f13684d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f13686b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f13686b.get();
            if (aVarArr == f13684d || aVarArr == f13685e) {
                return;
            }
            int length = aVarArr.length;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f13685e;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f13686b.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        a<T> aVar = new a<>(cVar, this);
        cVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isCancelled()) {
                b((a) aVar);
            }
        } else {
            Throwable th = this.f13687c;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        }
    }

    @g.a.t0.e
    public boolean m(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        a<T>[] aVarArr = this.f13686b.get();
        for (a<T> aVar : aVarArr) {
            if (aVar.isFull()) {
                return false;
            }
        }
        for (a<T> aVar2 : aVarArr) {
            aVar2.onNext(t);
        }
        return true;
    }

    @Override // i.d.c
    public void onComplete() {
        a<T>[] aVarArr = this.f13686b.get();
        a<T>[] aVarArr2 = f13684d;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.f13686b.getAndSet(aVarArr2)) {
            aVar.onComplete();
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (this.f13686b.get() == f13684d) {
            g.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f13687c = th;
        for (a<T> aVar : this.f13686b.getAndSet(f13684d)) {
            aVar.onError(th);
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f13686b.get() == f13684d) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (a<T> aVar : this.f13686b.get()) {
            aVar.onNext(t);
        }
    }

    @Override // i.d.c, g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (this.f13686b.get() == f13684d) {
            dVar.cancel();
        } else {
            dVar.request(m0.f16408b);
        }
    }
}

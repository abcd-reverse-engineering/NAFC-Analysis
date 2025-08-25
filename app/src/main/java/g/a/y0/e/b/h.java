package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableAmb.java */
/* loaded from: classes2.dex */
public final class h<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<? extends T>[] f14259b;

    /* renamed from: c, reason: collision with root package name */
    final Iterable<? extends i.d.b<? extends T>> f14260c;

    /* compiled from: FlowableAmb.java */
    static final class b<T> extends AtomicReference<i.d.d> implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -1185974347409665484L;
        final i.d.c<? super T> actual;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i2, i.d.c<? super T> cVar) {
            this.parent = aVar;
            this.index = i2;
            this.actual = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (!this.parent.a(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                get().cancel();
                g.a.c1.a.b(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (!this.parent.a(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onNext(t);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this, this.missedRequested, dVar);
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this, this.missedRequested, j2);
        }
    }

    public h(i.d.b<? extends T>[] bVarArr, Iterable<? extends i.d.b<? extends T>> iterable) {
        this.f14259b = bVarArr;
        this.f14260c = iterable;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        int length;
        i.d.b<? extends T>[] bVarArr = this.f14259b;
        if (bVarArr == null) {
            bVarArr = new i.d.b[8];
            try {
                length = 0;
                for (i.d.b<? extends T> bVar : this.f14260c) {
                    if (bVar == null) {
                        g.a.y0.i.g.error(new NullPointerException("One of the sources is null"), cVar);
                        return;
                    }
                    if (length == bVarArr.length) {
                        i.d.b<? extends T>[] bVarArr2 = new i.d.b[(length >> 2) + length];
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        bVarArr = bVarArr2;
                    }
                    int i2 = length + 1;
                    bVarArr[length] = bVar;
                    length = i2;
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.y0.i.g.error(th, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        if (length == 0) {
            g.a.y0.i.g.complete(cVar);
        } else if (length == 1) {
            bVarArr[0].subscribe(cVar);
        } else {
            new a(cVar, length).a(bVarArr);
        }
    }

    /* compiled from: FlowableAmb.java */
    static final class a<T> implements i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14261a;

        /* renamed from: b, reason: collision with root package name */
        final b<T>[] f14262b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f14263c = new AtomicInteger();

        a(i.d.c<? super T> cVar, int i2) {
            this.f14261a = cVar;
            this.f14262b = new b[i2];
        }

        public void a(i.d.b<? extends T>[] bVarArr) {
            b<T>[] bVarArr2 = this.f14262b;
            int length = bVarArr2.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr2[i2] = new b<>(this, i3, this.f14261a);
                i2 = i3;
            }
            this.f14263c.lazySet(0);
            this.f14261a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f14263c.get() == 0; i4++) {
                bVarArr[i4].subscribe(bVarArr2[i4]);
            }
        }

        @Override // i.d.d
        public void cancel() {
            if (this.f14263c.get() != -1) {
                this.f14263c.lazySet(-1);
                for (b<T> bVar : this.f14262b) {
                    bVar.cancel();
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                int i2 = this.f14263c.get();
                if (i2 > 0) {
                    this.f14262b[i2 - 1].request(j2);
                    return;
                }
                if (i2 == 0) {
                    for (b<T> bVar : this.f14262b) {
                        bVar.request(j2);
                    }
                }
            }
        }

        public boolean a(int i2) {
            int i3 = 0;
            if (this.f14263c.get() != 0 || !this.f14263c.compareAndSet(0, i2)) {
                return false;
            }
            b<T>[] bVarArr = this.f14262b;
            int length = bVarArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i2) {
                    bVarArr[i3].cancel();
                }
                i3 = i4;
            }
            return true;
        }
    }
}

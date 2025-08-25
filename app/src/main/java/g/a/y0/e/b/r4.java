package g.a.y0.e.b;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: FlowableWithLatestFromMany.java */
/* loaded from: classes2.dex */
public final class r4<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    @g.a.t0.g
    final i.d.b<?>[] f14581c;

    /* renamed from: d, reason: collision with root package name */
    @g.a.t0.g
    final Iterable<? extends i.d.b<?>> f14582d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.o<? super Object[], R> f14583e;

    /* compiled from: FlowableWithLatestFromMany.java */
    final class a implements g.a.x0.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // g.a.x0.o
        public R apply(T t) throws Exception {
            return (R) g.a.y0.b.b.a(r4.this.f14583e.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* compiled from: FlowableWithLatestFromMany.java */
    static final class b<T, R> extends AtomicInteger implements g.a.y0.c.a<T>, i.d.d {
        private static final long serialVersionUID = 1577321883966341961L;
        final i.d.c<? super R> actual;
        final g.a.x0.o<? super Object[], R> combiner;
        volatile boolean done;
        final g.a.y0.j.c error;
        final AtomicLong requested;
        final AtomicReference<i.d.d> s;
        final c[] subscribers;
        final AtomicReferenceArray<Object> values;

        b(i.d.c<? super R> cVar, g.a.x0.o<? super Object[], R> oVar, int i2) {
            this.actual = cVar;
            this.combiner = oVar;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.subscribers = cVarArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.s = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new g.a.y0.j.c();
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.s);
            for (c cVar : this.subscribers) {
                cVar.dispose();
            }
        }

        void cancelAllBut(int i2) {
            c[] cVarArr = this.subscribers;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].dispose();
                }
            }
        }

        void innerComplete(int i2, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            g.a.y0.i.j.cancel(this.s);
            cancelAllBut(i2);
            g.a.y0.j.l.a(this.actual, this, this.error);
        }

        void innerError(int i2, Throwable th) {
            this.done = true;
            g.a.y0.i.j.cancel(this.s);
            cancelAllBut(i2);
            g.a.y0.j.l.a((i.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            g.a.y0.j.l.a(this.actual, this, this.error);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            g.a.y0.j.l.a((i.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.done) {
                return;
            }
            this.s.get().request(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }

        void subscribe(i.d.b<?>[] bVarArr, int i2) {
            c[] cVarArr = this.subscribers;
            AtomicReference<i.d.d> atomicReference = this.s;
            for (int i3 = 0; i3 < i2 && !g.a.y0.i.j.isCancelled(atomicReference.get()); i3++) {
                bVarArr[i3].subscribe(cVarArr[i3]);
            }
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t;
            int i2 = 0;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return false;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                g.a.y0.j.l.a(this.actual, g.a.y0.b.b.a(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    /* compiled from: FlowableWithLatestFromMany.java */
    static final class c extends AtomicReference<i.d.d> implements g.a.q<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        void dispose() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // i.d.c
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public r4(@g.a.t0.f g.a.l<T> lVar, @g.a.t0.f i.d.b<?>[] bVarArr, g.a.x0.o<? super Object[], R> oVar) {
        super(lVar);
        this.f14581c = bVarArr;
        this.f14582d = null;
        this.f14583e = oVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        int length;
        i.d.b<?>[] bVarArr = this.f14581c;
        if (bVarArr == null) {
            bVarArr = new i.d.b[8];
            try {
                length = 0;
                for (i.d.b<?> bVar : this.f14582d) {
                    if (length == bVarArr.length) {
                        bVarArr = (i.d.b[]) Arrays.copyOf(bVarArr, (length >> 1) + length);
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
            new y1(this.f14110b, new a()).d((i.d.c) cVar);
            return;
        }
        b bVar2 = new b(cVar, this.f14583e, length);
        cVar.onSubscribe(bVar2);
        bVar2.subscribe(bVarArr, length);
        this.f14110b.a((g.a.q) bVar2);
    }

    public r4(@g.a.t0.f g.a.l<T> lVar, @g.a.t0.f Iterable<? extends i.d.b<?>> iterable, @g.a.t0.f g.a.x0.o<? super Object[], R> oVar) {
        super(lVar);
        this.f14581c = null;
        this.f14582d = iterable;
        this.f14583e = oVar;
    }
}

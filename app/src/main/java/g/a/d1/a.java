package g.a.d1;

import h.q2.t.m0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AsyncProcessor.java */
/* loaded from: classes2.dex */
public final class a<T> extends c<T> {

    /* renamed from: e, reason: collision with root package name */
    static final C0170a[] f13669e = new C0170a[0];

    /* renamed from: f, reason: collision with root package name */
    static final C0170a[] f13670f = new C0170a[0];

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<C0170a<T>[]> f13671b = new AtomicReference<>(f13669e);

    /* renamed from: c, reason: collision with root package name */
    Throwable f13672c;

    /* renamed from: d, reason: collision with root package name */
    T f13673d;

    /* compiled from: AsyncProcessor.java */
    /* renamed from: g.a.d1.a$a, reason: collision with other inner class name */
    static final class C0170a<T> extends g.a.y0.i.f<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final a<T> parent;

        C0170a(i.d.c<? super T> cVar, a<T> aVar) {
            super(cVar);
            this.parent = aVar;
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.b((C0170a) this);
            }
        }

        void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isCancelled()) {
                g.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    a() {
    }

    @g.a.t0.f
    @g.a.t0.d
    public static <T> a<T> c0() {
        return new a<>();
    }

    @Override // g.a.d1.c
    public Throwable T() {
        if (this.f13671b.get() == f13670f) {
            return this.f13672c;
        }
        return null;
    }

    @Override // g.a.d1.c
    public boolean U() {
        return this.f13671b.get() == f13670f && this.f13672c == null;
    }

    @Override // g.a.d1.c
    public boolean V() {
        return this.f13671b.get().length != 0;
    }

    @Override // g.a.d1.c
    public boolean W() {
        return this.f13671b.get() == f13670f && this.f13672c != null;
    }

    public T Y() {
        if (this.f13671b.get() == f13670f) {
            return this.f13673d;
        }
        return null;
    }

    public Object[] Z() {
        T tY = Y();
        return tY != null ? new Object[]{tY} : new Object[0];
    }

    boolean a(C0170a<T> c0170a) {
        C0170a<T>[] c0170aArr;
        C0170a<T>[] c0170aArr2;
        do {
            c0170aArr = this.f13671b.get();
            if (c0170aArr == f13670f) {
                return false;
            }
            int length = c0170aArr.length;
            c0170aArr2 = new C0170a[length + 1];
            System.arraycopy(c0170aArr, 0, c0170aArr2, 0, length);
            c0170aArr2[length] = c0170a;
        } while (!this.f13671b.compareAndSet(c0170aArr, c0170aArr2));
        return true;
    }

    public boolean a0() {
        return this.f13671b.get() == f13670f && this.f13673d != null;
    }

    void b(C0170a<T> c0170a) {
        C0170a<T>[] c0170aArr;
        C0170a<T>[] c0170aArr2;
        do {
            c0170aArr = this.f13671b.get();
            int length = c0170aArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (c0170aArr[i3] == c0170a) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                c0170aArr2 = f13669e;
            } else {
                C0170a<T>[] c0170aArr3 = new C0170a[length - 1];
                System.arraycopy(c0170aArr, 0, c0170aArr3, 0, i2);
                System.arraycopy(c0170aArr, i2 + 1, c0170aArr3, i2, (length - i2) - 1);
                c0170aArr2 = c0170aArr3;
            }
        } while (!this.f13671b.compareAndSet(c0170aArr, c0170aArr2));
    }

    void b0() {
        this.f13673d = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f13672c = nullPointerException;
        for (C0170a<T> c0170a : this.f13671b.getAndSet(f13670f)) {
            c0170a.onError(nullPointerException);
        }
    }

    public T[] c(T[] tArr) {
        T tY = Y();
        if (tY == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = tY;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        C0170a<T> c0170a = new C0170a<>(cVar, this);
        cVar.onSubscribe(c0170a);
        if (a((C0170a) c0170a)) {
            if (c0170a.isCancelled()) {
                b((C0170a) c0170a);
                return;
            }
            return;
        }
        Throwable th = this.f13672c;
        if (th != null) {
            cVar.onError(th);
            return;
        }
        T t = this.f13673d;
        if (t != null) {
            c0170a.complete(t);
        } else {
            c0170a.onComplete();
        }
    }

    @Override // i.d.c
    public void onComplete() {
        C0170a<T>[] c0170aArr = this.f13671b.get();
        C0170a<T>[] c0170aArr2 = f13670f;
        if (c0170aArr == c0170aArr2) {
            return;
        }
        T t = this.f13673d;
        C0170a<T>[] andSet = this.f13671b.getAndSet(c0170aArr2);
        int i2 = 0;
        if (t == null) {
            int length = andSet.length;
            while (i2 < length) {
                andSet[i2].onComplete();
                i2++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i2 < length2) {
            andSet[i2].complete(t);
            i2++;
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        C0170a<T>[] c0170aArr = this.f13671b.get();
        C0170a<T>[] c0170aArr2 = f13670f;
        if (c0170aArr == c0170aArr2) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13673d = null;
        this.f13672c = th;
        for (C0170a<T> c0170a : this.f13671b.getAndSet(c0170aArr2)) {
            c0170a.onError(th);
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f13671b.get() == f13670f) {
            return;
        }
        if (t == null) {
            b0();
        } else {
            this.f13673d = t;
        }
    }

    @Override // i.d.c, g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (this.f13671b.get() == f13670f) {
            dVar.cancel();
        } else {
            dVar.request(m0.f16408b);
        }
    }
}

package g.a.y0.e.d;

/* compiled from: ObservableFromArray.java */
/* loaded from: classes2.dex */
public final class a1<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final T[] f14936a;

    /* compiled from: ObservableFromArray.java */
    static final class a<T> extends g.a.y0.d.c<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f14937a;

        /* renamed from: b, reason: collision with root package name */
        final T[] f14938b;

        /* renamed from: c, reason: collision with root package name */
        int f14939c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14940d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f14941e;

        a(g.a.i0<? super T> i0Var, T[] tArr) {
            this.f14937a = i0Var;
            this.f14938b = tArr;
        }

        void a() {
            T[] tArr = this.f14938b;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !isDisposed(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    this.f14937a.onError(new NullPointerException("The " + i2 + "th element is null"));
                    return;
                }
                this.f14937a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.f14937a.onComplete();
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.f14939c = this.f14938b.length;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14941e = true;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14941e;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.f14939c == this.f14938b.length;
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() {
            int i2 = this.f14939c;
            T[] tArr = this.f14938b;
            if (i2 == tArr.length) {
                return null;
            }
            this.f14939c = i2 + 1;
            return (T) g.a.y0.b.b.a((Object) tArr[i2], "The array element is null");
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f14940d = true;
            return 1;
        }
    }

    public a1(T[] tArr) {
        this.f14936a = tArr;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var, this.f14936a);
        i0Var.onSubscribe(aVar);
        if (aVar.f14940d) {
            return;
        }
        aVar.a();
    }
}

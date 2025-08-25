package g.a.y0.e.d;

/* compiled from: ObservableRange.java */
/* loaded from: classes2.dex */
public final class d2 extends g.a.b0<Integer> {

    /* renamed from: a, reason: collision with root package name */
    private final int f15042a;

    /* renamed from: b, reason: collision with root package name */
    private final long f15043b;

    /* compiled from: ObservableRange.java */
    static final class a extends g.a.y0.d.b<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        final g.a.i0<? super Integer> actual;
        final long end;
        boolean fused;
        long index;

        a(g.a.i0<? super Integer> i0Var, long j2, long j3) {
            this.actual = i0Var;
            this.index = j2;
            this.end = j3;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // g.a.u0.c
        public void dispose() {
            set(1);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        void run() {
            if (this.fused) {
                return;
            }
            g.a.i0<? super Integer> i0Var = this.actual;
            long j2 = this.end;
            for (long j3 = this.index; j3 != j2 && get() == 0; j3++) {
                i0Var.onNext(Integer.valueOf((int) j3));
            }
            if (get() == 0) {
                lazySet(1);
                i0Var.onComplete();
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public Integer poll() throws Exception {
            long j2 = this.index;
            if (j2 != this.end) {
                this.index = 1 + j2;
                return Integer.valueOf((int) j2);
            }
            lazySet(1);
            return null;
        }
    }

    public d2(int i2, int i3) {
        this.f15042a = i2;
        this.f15043b = i2 + i3;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super Integer> i0Var) {
        a aVar = new a(i0Var, this.f15042a, this.f15043b);
        i0Var.onSubscribe(aVar);
        aVar.run();
    }
}

package g.a.y0.e.d;

/* compiled from: ObservableRangeLong.java */
/* loaded from: classes2.dex */
public final class e2 extends g.a.b0<Long> {

    /* renamed from: a, reason: collision with root package name */
    private final long f15087a;

    /* renamed from: b, reason: collision with root package name */
    private final long f15088b;

    /* compiled from: ObservableRangeLong.java */
    static final class a extends g.a.y0.d.b<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final g.a.i0<? super Long> actual;
        final long end;
        boolean fused;
        long index;

        a(g.a.i0<? super Long> i0Var, long j2, long j3) {
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
            g.a.i0<? super Long> i0Var = this.actual;
            long j2 = this.end;
            for (long j3 = this.index; j3 != j2 && get() == 0; j3++) {
                i0Var.onNext(Long.valueOf(j3));
            }
            if (get() == 0) {
                lazySet(1);
                i0Var.onComplete();
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public Long poll() throws Exception {
            long j2 = this.index;
            if (j2 != this.end) {
                this.index = 1 + j2;
                return Long.valueOf(j2);
            }
            lazySet(1);
            return null;
        }
    }

    public e2(long j2, long j3) {
        this.f15087a = j2;
        this.f15088b = j3;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super Long> i0Var) {
        long j2 = this.f15087a;
        a aVar = new a(i0Var, j2, j2 + this.f15088b);
        i0Var.onSubscribe(aVar);
        aVar.run();
    }
}

package g.a.y0.e.b;

/* compiled from: FlowableRange.java */
/* loaded from: classes2.dex */
public final class n2 extends g.a.l<Integer> {

    /* renamed from: b, reason: collision with root package name */
    final int f14419b;

    /* renamed from: c, reason: collision with root package name */
    final int f14420c;

    /* compiled from: FlowableRange.java */
    static abstract class a extends g.a.y0.i.d<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        a(int i2, int i3) {
            this.index = i2;
            this.end = i3;
        }

        @Override // i.d.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // g.a.y0.c.o
        public final void clear() {
            this.index = this.end;
        }

        abstract void fastPath();

        @Override // g.a.y0.c.o
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // i.d.d
        public final void request(long j2) {
            if (g.a.y0.i.j.validate(j2) && g.a.y0.j.d.a(this, j2) == 0) {
                if (j2 == h.q2.t.m0.f16408b) {
                    fastPath();
                } else {
                    slowPath(j2);
                }
            }
        }

        @Override // g.a.y0.c.k
        public final int requestFusion(int i2) {
            return i2 & 1;
        }

        abstract void slowPath(long j2);

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public final Integer poll() {
            int i2 = this.index;
            if (i2 == this.end) {
                return null;
            }
            this.index = i2 + 1;
            return Integer.valueOf(i2);
        }
    }

    /* compiled from: FlowableRange.java */
    static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final g.a.y0.c.a<? super Integer> actual;

        b(g.a.y0.c.a<? super Integer> aVar, int i2, int i3) {
            super(i2, i3);
            this.actual = aVar;
        }

        @Override // g.a.y0.e.b.n2.a
        void fastPath() {
            int i2 = this.end;
            g.a.y0.c.a<? super Integer> aVar = this.actual;
            for (int i3 = this.index; i3 != i2; i3++) {
                if (this.cancelled) {
                    return;
                }
                aVar.tryOnNext(Integer.valueOf(i3));
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        
            r9.index = r1;
            r5 = addAndGet(-r10);
         */
        @Override // g.a.y0.e.b.n2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                g.a.y0.c.a<? super java.lang.Integer> r2 = r9.actual
                r3 = 0
                r5 = r10
            L9:
                r10 = r3
            La:
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 == 0) goto L25
                if (r1 == r0) goto L25
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L15
                return
            L15:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                boolean r7 = r2.tryOnNext(r7)
                if (r7 == 0) goto L22
                r7 = 1
                long r10 = r10 + r7
            L22:
                int r1 = r1 + 1
                goto La
            L25:
                if (r1 != r0) goto L2f
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2e
                r2.onComplete()
            L2e:
                return
            L2f:
                long r5 = r9.get()
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 != 0) goto La
                r9.index = r1
                long r10 = -r10
                long r5 = r9.addAndGet(r10)
                int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r10 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.n2.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableRange.java */
    static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final i.d.c<? super Integer> actual;

        c(i.d.c<? super Integer> cVar, int i2, int i3) {
            super(i2, i3);
            this.actual = cVar;
        }

        @Override // g.a.y0.e.b.n2.a
        void fastPath() {
            int i2 = this.end;
            i.d.c<? super Integer> cVar = this.actual;
            for (int i3 = this.index; i3 != i2; i3++) {
                if (this.cancelled) {
                    return;
                }
                cVar.onNext(Integer.valueOf(i3));
            }
            if (this.cancelled) {
                return;
            }
            cVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        
            r9.index = r1;
            r5 = addAndGet(-r10);
         */
        @Override // g.a.y0.e.b.n2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                i.d.c<? super java.lang.Integer> r2 = r9.actual
                r3 = 0
                r5 = r10
            L9:
                r10 = r3
            La:
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 == 0) goto L22
                if (r1 == r0) goto L22
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L15
                return
            L15:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r2.onNext(r7)
                r7 = 1
                long r10 = r10 + r7
                int r1 = r1 + 1
                goto La
            L22:
                if (r1 != r0) goto L2c
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2b
                r2.onComplete()
            L2b:
                return
            L2c:
                long r5 = r9.get()
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 != 0) goto La
                r9.index = r1
                long r10 = -r10
                long r5 = r9.addAndGet(r10)
                int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r10 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.n2.c.slowPath(long):void");
        }
    }

    public n2(int i2, int i3) {
        this.f14419b = i2;
        this.f14420c = i2 + i3;
    }

    @Override // g.a.l
    public void d(i.d.c<? super Integer> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            cVar.onSubscribe(new b((g.a.y0.c.a) cVar, this.f14419b, this.f14420c));
        } else {
            cVar.onSubscribe(new c(cVar, this.f14419b, this.f14420c));
        }
    }
}

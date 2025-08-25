package g.a.y0.e.b;

/* compiled from: FlowableRangeLong.java */
/* loaded from: classes2.dex */
public final class o2 extends g.a.l<Long> {

    /* renamed from: b, reason: collision with root package name */
    final long f14451b;

    /* renamed from: c, reason: collision with root package name */
    final long f14452c;

    /* compiled from: FlowableRangeLong.java */
    static abstract class a extends g.a.y0.i.d<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        a(long j2, long j3) {
            this.index = j2;
            this.end = j3;
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
        public final Long poll() {
            long j2 = this.index;
            if (j2 == this.end) {
                return null;
            }
            this.index = 1 + j2;
            return Long.valueOf(j2);
        }
    }

    /* compiled from: FlowableRangeLong.java */
    static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final g.a.y0.c.a<? super Long> actual;

        b(g.a.y0.c.a<? super Long> aVar, long j2, long j3) {
            super(j2, j3);
            this.actual = aVar;
        }

        @Override // g.a.y0.e.b.o2.a
        void fastPath() {
            long j2 = this.end;
            g.a.y0.c.a<? super Long> aVar = this.actual;
            for (long j3 = this.index; j3 != j2; j3++) {
                if (this.cancelled) {
                    return;
                }
                aVar.tryOnNext(Long.valueOf(j3));
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        
            r12.index = r7;
            r2 = addAndGet(-r13);
         */
        @Override // g.a.y0.e.b.o2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r13) {
            /*
                r12 = this;
                long r0 = r12.end
                long r2 = r12.index
                g.a.y0.c.a<? super java.lang.Long> r4 = r12.actual
                r5 = 0
                r7 = r2
                r2 = r13
            La:
                r13 = r5
            Lb:
                int r9 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r9 == 0) goto L27
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 == 0) goto L27
                boolean r9 = r12.cancelled
                if (r9 == 0) goto L18
                return
            L18:
                java.lang.Long r9 = java.lang.Long.valueOf(r7)
                boolean r9 = r4.tryOnNext(r9)
                r10 = 1
                if (r9 == 0) goto L25
                long r13 = r13 + r10
            L25:
                long r7 = r7 + r10
                goto Lb
            L27:
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 != 0) goto L33
                boolean r13 = r12.cancelled
                if (r13 != 0) goto L32
                r4.onComplete()
            L32:
                return
            L33:
                long r2 = r12.get()
                int r9 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r9 != 0) goto Lb
                r12.index = r7
                long r13 = -r13
                long r2 = r12.addAndGet(r13)
                int r13 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r13 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.o2.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableRangeLong.java */
    static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final i.d.c<? super Long> actual;

        c(i.d.c<? super Long> cVar, long j2, long j3) {
            super(j2, j3);
            this.actual = cVar;
        }

        @Override // g.a.y0.e.b.o2.a
        void fastPath() {
            long j2 = this.end;
            i.d.c<? super Long> cVar = this.actual;
            for (long j3 = this.index; j3 != j2; j3++) {
                if (this.cancelled) {
                    return;
                }
                cVar.onNext(Long.valueOf(j3));
            }
            if (this.cancelled) {
                return;
            }
            cVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        
            r11.index = r7;
            r2 = addAndGet(-r12);
         */
        @Override // g.a.y0.e.b.o2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r12) {
            /*
                r11 = this;
                long r0 = r11.end
                long r2 = r11.index
                i.d.c<? super java.lang.Long> r4 = r11.actual
                r5 = 0
                r7 = r2
                r2 = r12
            La:
                r12 = r5
            Lb:
                int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
                if (r9 == 0) goto L24
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 == 0) goto L24
                boolean r9 = r11.cancelled
                if (r9 == 0) goto L18
                return
            L18:
                java.lang.Long r9 = java.lang.Long.valueOf(r7)
                r4.onNext(r9)
                r9 = 1
                long r12 = r12 + r9
                long r7 = r7 + r9
                goto Lb
            L24:
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 != 0) goto L30
                boolean r12 = r11.cancelled
                if (r12 != 0) goto L2f
                r4.onComplete()
            L2f:
                return
            L30:
                long r2 = r11.get()
                int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
                if (r9 != 0) goto Lb
                r11.index = r7
                long r12 = -r12
                long r2 = r11.addAndGet(r12)
                int r12 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r12 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.o2.c.slowPath(long):void");
        }
    }

    public o2(long j2, long j3) {
        this.f14451b = j2;
        this.f14452c = j2 + j3;
    }

    @Override // g.a.l
    public void d(i.d.c<? super Long> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            cVar.onSubscribe(new b((g.a.y0.c.a) cVar, this.f14451b, this.f14452c));
        } else {
            cVar.onSubscribe(new c(cVar, this.f14451b, this.f14452c));
        }
    }
}

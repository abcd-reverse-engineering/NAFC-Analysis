package g.a.y0.e.b;

/* compiled from: FlowableFromArray.java */
/* loaded from: classes2.dex */
public final class d1<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final T[] f14170b;

    /* compiled from: FlowableFromArray.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final g.a.y0.c.a<? super T> actual;

        a(g.a.y0.c.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.actual = aVar;
        }

        @Override // g.a.y0.e.b.d1.c
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            g.a.y0.c.a<? super T> aVar = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    aVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                aVar.tryOnNext(t);
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
        
            r10.index = r2;
            r6 = addAndGet(-r11);
         */
        @Override // g.a.y0.e.b.d1.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                g.a.y0.c.a<? super T> r3 = r10.actual
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L31
                if (r2 == r1) goto L31
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                boolean r8 = r3.tryOnNext(r8)
                if (r8 == 0) goto L2e
                r8 = 1
                long r11 = r11 + r8
            L2e:
                int r2 = r2 + 1
                goto Lb
            L31:
                if (r2 != r1) goto L3b
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L3a
                r3.onComplete()
            L3a:
                return
            L3b:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.index = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.d1.a.slowPath(long):void");
        }
    }

    /* compiled from: FlowableFromArray.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final i.d.c<? super T> actual;

        b(i.d.c<? super T> cVar, T[] tArr) {
            super(tArr);
            this.actual = cVar;
        }

        @Override // g.a.y0.e.b.d1.c
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            i.d.c<? super T> cVar = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    cVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                cVar.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            cVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        
            r10.index = r2;
            r6 = addAndGet(-r11);
         */
        @Override // g.a.y0.e.b.d1.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                i.d.c<? super T> r3 = r10.actual
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L2e
                if (r2 == r1) goto L2e
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                r3.onNext(r8)
                r8 = 1
                long r11 = r11 + r8
                int r2 = r2 + 1
                goto Lb
            L2e:
                if (r2 != r1) goto L38
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L37
                r3.onComplete()
            L37:
                return
            L38:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.index = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.d1.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableFromArray.java */
    static abstract class c<T> extends g.a.y0.i.d<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        c(T[] tArr) {
            this.array = tArr;
        }

        @Override // i.d.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // g.a.y0.c.o
        public final void clear() {
            this.index = this.array.length;
        }

        abstract void fastPath();

        @Override // g.a.y0.c.o
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public final T poll() {
            int i2 = this.index;
            T[] tArr = this.array;
            if (i2 == tArr.length) {
                return null;
            }
            this.index = i2 + 1;
            return (T) g.a.y0.b.b.a((Object) tArr[i2], "array element is null");
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
    }

    public d1(T[] tArr) {
        this.f14170b = tArr;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        if (cVar instanceof g.a.y0.c.a) {
            cVar.onSubscribe(new a((g.a.y0.c.a) cVar, this.f14170b));
        } else {
            cVar.onSubscribe(new b(cVar, this.f14170b));
        }
    }
}

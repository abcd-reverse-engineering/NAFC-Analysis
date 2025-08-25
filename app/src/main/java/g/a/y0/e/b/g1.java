package g.a.y0.e.b;

import java.util.Iterator;

/* compiled from: FlowableFromIterable.java */
/* loaded from: classes2.dex */
public final class g1<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final Iterable<? extends T> f14250b;

    /* compiled from: FlowableFromIterable.java */
    static abstract class a<T> extends g.a.y0.i.d<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        a(Iterator<? extends T> it) {
            this.it = it;
        }

        @Override // i.d.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // g.a.y0.c.o
        public final void clear() {
            this.it = null;
        }

        abstract void fastPath();

        @Override // g.a.y0.c.o
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.it;
            return it == null || !it.hasNext();
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public final T poll() {
            Iterator<? extends T> it = this.it;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) g.a.y0.b.b.a((Object) this.it.next(), "Iterator.next() returned a null value");
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

    /* compiled from: FlowableFromIterable.java */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final g.a.y0.c.a<? super T> actual;

        b(g.a.y0.c.a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.actual = aVar;
        }

        @Override // g.a.y0.e.b.g1.a
        void fastPath() {
            Iterator<? extends T> it = this.it;
            g.a.y0.c.a<? super T> aVar = this.actual;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.tryOnNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // g.a.y0.e.b.g1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                g.a.y0.c.a<? super T> r1 = r8.actual
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L54
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4c
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                boolean r6 = r1.tryOnNext(r6)
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L30
                return
            L30:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L44
                if (r7 != 0) goto L3e
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3d
                r1.onComplete()
            L3d:
                return
            L3e:
                if (r6 == 0) goto L8
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L44:
                r9 = move-exception
                g.a.v0.b.b(r9)
                r1.onError(r9)
                return
            L4c:
                r9 = move-exception
                g.a.v0.b.b(r9)
                r1.onError(r9)
                return
            L54:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.g1.b.slowPath(long):void");
        }
    }

    /* compiled from: FlowableFromIterable.java */
    static final class c<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final i.d.c<? super T> actual;

        c(i.d.c<? super T> cVar, Iterator<? extends T> it) {
            super(it);
            this.actual = cVar;
        }

        @Override // g.a.y0.e.b.g1.a
        void fastPath() {
            Iterator<? extends T> it = this.it;
            i.d.c<? super T> cVar = this.actual;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    cVar.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        cVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // g.a.y0.e.b.g1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                i.d.c<? super T> r1 = r8.actual
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L51
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L49
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                r1.onNext(r6)
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L2f
                return
            L2f:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L41
                if (r6 != 0) goto L3d
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L41:
                r9 = move-exception
                g.a.v0.b.b(r9)
                r1.onError(r9)
                return
            L49:
                r9 = move-exception
                g.a.v0.b.b(r9)
                r1.onError(r9)
                return
            L51:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.g1.c.slowPath(long):void");
        }
    }

    public g1(Iterable<? extends T> iterable) {
        this.f14250b = iterable;
    }

    public static <T> void a(i.d.c<? super T> cVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                g.a.y0.i.g.complete(cVar);
            } else if (cVar instanceof g.a.y0.c.a) {
                cVar.onSubscribe(new b((g.a.y0.c.a) cVar, it));
            } else {
                cVar.onSubscribe(new c(cVar, it));
            }
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        try {
            a((i.d.c) cVar, (Iterator) this.f14250b.iterator());
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}

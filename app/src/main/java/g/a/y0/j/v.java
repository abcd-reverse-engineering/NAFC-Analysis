package g.a.y0.j;

import g.a.i0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: QueueDrainHelper.java */
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    static final long f16064a = Long.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    static final long f16065b = Long.MAX_VALUE;

    private v() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> void a(g.a.y0.c.n<T> nVar, i.d.c<? super U> cVar, boolean z, g.a.u0.c cVar2, u<T, U> uVar) {
        int iA = 1;
        while (true) {
            boolean zC = uVar.c();
            T tPoll = nVar.poll();
            boolean z2 = tPoll == null;
            if (a(zC, z2, cVar, z, nVar, uVar)) {
                if (cVar2 != null) {
                    cVar2.dispose();
                    return;
                }
                return;
            } else if (z2) {
                iA = uVar.a(-iA);
                if (iA == 0) {
                    return;
                }
            } else {
                long jRequested = uVar.requested();
                if (jRequested == 0) {
                    nVar.clear();
                    if (cVar2 != null) {
                        cVar2.dispose();
                    }
                    cVar.onError(new g.a.v0.c("Could not emit value due to lack of requests."));
                    return;
                }
                if (uVar.a(cVar, tPoll) && jRequested != Long.MAX_VALUE) {
                    uVar.a(1L);
                }
            }
        }
    }

    public static <T> boolean b(long j2, i.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, g.a.x0.e eVar) {
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, d.a(Long.MAX_VALUE & j3, j2) | (j3 & Long.MIN_VALUE)));
        if (j3 != Long.MIN_VALUE) {
            return false;
        }
        a(j2 | Long.MIN_VALUE, cVar, queue, atomicLong, eVar);
        return true;
    }

    public static <T, U> boolean a(boolean z, boolean z2, i.d.c<?> cVar, boolean z3, g.a.y0.c.o<?> oVar, u<T, U> uVar) {
        if (uVar.d()) {
            oVar.clear();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable thA = uVar.a();
            if (thA != null) {
                cVar.onError(thA);
            } else {
                cVar.onComplete();
            }
            return true;
        }
        Throwable thA2 = uVar.a();
        if (thA2 != null) {
            oVar.clear();
            cVar.onError(thA2);
            return true;
        }
        if (!z2) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r1 = r15.a(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void a(g.a.y0.c.n<T> r11, g.a.i0<? super U> r12, boolean r13, g.a.u0.c r14, g.a.y0.j.r<T, U> r15) {
        /*
            r0 = 1
            r1 = 1
        L2:
            boolean r2 = r15.c()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = a(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.c()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = 1
            goto L24
        L22:
            r4 = 0
            r10 = 0
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = a(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.a(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.a(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.y0.j.v.a(g.a.y0.c.n, g.a.i0, boolean, g.a.u0.c, g.a.y0.j.r):void");
    }

    public static <T, U> boolean a(boolean z, boolean z2, i0<?> i0Var, boolean z3, g.a.y0.c.o<?> oVar, g.a.u0.c cVar, r<T, U> rVar) {
        if (rVar.d()) {
            oVar.clear();
            cVar.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            cVar.dispose();
            Throwable thA = rVar.a();
            if (thA != null) {
                i0Var.onError(thA);
            } else {
                i0Var.onComplete();
            }
            return true;
        }
        Throwable thA2 = rVar.a();
        if (thA2 != null) {
            oVar.clear();
            cVar.dispose();
            i0Var.onError(thA2);
            return true;
        }
        if (!z2) {
            return false;
        }
        cVar.dispose();
        i0Var.onComplete();
        return true;
    }

    public static <T> g.a.y0.c.o<T> a(int i2) {
        if (i2 < 0) {
            return new g.a.y0.f.c(-i2);
        }
        return new g.a.y0.f.b(i2);
    }

    public static void a(i.d.d dVar, int i2) {
        dVar.request(i2 < 0 ? Long.MAX_VALUE : i2);
    }

    static boolean a(g.a.x0.e eVar) {
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            return true;
        }
    }

    static <T> boolean a(long j2, i.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, g.a.x0.e eVar) {
        long j3 = j2 & Long.MIN_VALUE;
        while (true) {
            if (j3 != j2) {
                if (a(eVar)) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(tPoll);
                j3++;
            } else {
                if (a(eVar)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j2 = atomicLong.get();
                if (j2 == j3) {
                    long jAddAndGet = atomicLong.addAndGet(-(j3 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j2 = jAddAndGet;
                    j3 = jAddAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void a(i.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, g.a.x0.e eVar) {
        long j2;
        long j3;
        if (queue.isEmpty()) {
            cVar.onComplete();
            return;
        }
        if (a(atomicLong.get(), cVar, queue, atomicLong, eVar)) {
            return;
        }
        do {
            j2 = atomicLong.get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j3 = j2 | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        if (j2 != 0) {
            a(j3, cVar, queue, atomicLong, eVar);
        }
    }
}

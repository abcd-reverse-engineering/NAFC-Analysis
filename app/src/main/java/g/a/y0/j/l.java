package g.a.y0.j;

import g.a.i0;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HalfSerializer.java */
/* loaded from: classes2.dex */
public final class l {
    private l() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(i.d.c<? super T> cVar, T t, AtomicInteger atomicInteger, c cVar2) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = cVar2.terminate();
                if (thTerminate != null) {
                    cVar.onError(thTerminate);
                } else {
                    cVar.onComplete();
                }
            }
        }
    }

    public static void a(i.d.c<?> cVar, Throwable th, AtomicInteger atomicInteger, c cVar2) {
        if (cVar2.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                cVar.onError(cVar2.terminate());
                return;
            }
            return;
        }
        g.a.c1.a.b(th);
    }

    public static void a(i.d.c<?> cVar, AtomicInteger atomicInteger, c cVar2) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = cVar2.terminate();
            if (thTerminate != null) {
                cVar.onError(thTerminate);
            } else {
                cVar.onComplete();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(i0<? super T> i0Var, T t, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            i0Var.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = cVar.terminate();
                if (thTerminate != null) {
                    i0Var.onError(thTerminate);
                } else {
                    i0Var.onComplete();
                }
            }
        }
    }

    public static void a(i0<?> i0Var, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (cVar.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                i0Var.onError(cVar.terminate());
                return;
            }
            return;
        }
        g.a.c1.a.b(th);
    }

    public static void a(i0<?> i0Var, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = cVar.terminate();
            if (thTerminate != null) {
                i0Var.onError(thTerminate);
            } else {
                i0Var.onComplete();
            }
        }
    }
}

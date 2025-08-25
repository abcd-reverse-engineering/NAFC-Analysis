package g.a.y0.j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExceptionHelper.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Throwable f16046a = new a();

    /* compiled from: ExceptionHelper.java */
    static final class a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    private k() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == f16046a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new g.a.v0.a(th2, th)));
        return true;
    }

    public static <E extends Throwable> Exception b(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static RuntimeException c(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    public static <T> Throwable a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f16046a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static List<Throwable> a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(th);
        while (!arrayDeque.isEmpty()) {
            Throwable th2 = (Throwable) arrayDeque.removeFirst();
            if (th2 instanceof g.a.v0.a) {
                List<Throwable> exceptions = ((g.a.v0.a) th2).getExceptions();
                for (int size = exceptions.size() - 1; size >= 0; size--) {
                    arrayDeque.offerFirst(exceptions.get(size));
                }
            } else {
                arrayList.add(th2);
            }
        }
        return arrayList;
    }
}

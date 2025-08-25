package g.a.y0.j;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EndConsumerHelper.java */
/* loaded from: classes2.dex */
public final class i {
    private i() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(g.a.u0.c cVar, g.a.u0.c cVar2, Class<?> cls) {
        g.a.y0.b.b.a(cVar2, "next is null");
        if (cVar == null) {
            return true;
        }
        cVar2.dispose();
        if (cVar == g.a.y0.a.d.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static boolean a(AtomicReference<g.a.u0.c> atomicReference, g.a.u0.c cVar, Class<?> cls) {
        g.a.y0.b.b.a(cVar, "next is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == g.a.y0.a.d.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static boolean a(i.d.d dVar, i.d.d dVar2, Class<?> cls) {
        g.a.y0.b.b.a(dVar2, "next is null");
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        if (dVar == g.a.y0.i.j.CANCELLED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static boolean a(AtomicReference<i.d.d> atomicReference, i.d.d dVar, Class<?> cls) {
        g.a.y0.b.b.a(dVar, "next is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() == g.a.y0.i.j.CANCELLED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> cls) {
        g.a.c1.a.b(new g.a.v0.e(a(cls.getName())));
    }
}

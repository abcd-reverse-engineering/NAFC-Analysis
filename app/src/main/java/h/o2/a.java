package h.o2;

import h.m2.f;
import h.n0;
import h.q2.e;
import h.q2.s.l;
import h.q2.t.f0;
import h.t0;

/* compiled from: AutoCloseable.kt */
@e(name = "AutoCloseableKt")
/* loaded from: classes2.dex */
public final class a {
    @f
    @t0(version = "1.2")
    private static final <T extends AutoCloseable, R> R a(T t, l<? super T, ? extends R> lVar) throws Exception {
        try {
            R rInvoke = lVar.invoke(t);
            f0.b(1);
            a(t, (Throwable) null);
            f0.a(1);
            return rInvoke;
        } finally {
        }
    }

    @t0(version = "1.2")
    @n0
    public static final void a(@i.c.a.e AutoCloseable autoCloseable, @i.c.a.e Throwable th) throws Exception {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }
}

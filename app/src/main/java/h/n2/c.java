package h.n2;

import h.n0;
import h.q2.t.f0;
import h.t0;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Closeable.kt */
@h.q2.e(name = "CloseableKt")
/* loaded from: classes2.dex */
public final class c {
    @h.m2.f
    private static final <T extends Closeable, R> R a(T t, h.q2.s.l<? super T, ? extends R> lVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            R rInvoke = lVar.invoke(t);
            f0.b(1);
            if (h.m2.l.a(1, 1, 0)) {
                a(t, (Throwable) null);
            } else if (t != null) {
                t.close();
            }
            f0.a(1);
            return rInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f0.b(1);
                if (h.m2.l.a(1, 1, 0)) {
                    a(t, th);
                } else if (t != null) {
                    try {
                        t.close();
                    } catch (Throwable unused) {
                    }
                }
                f0.a(1);
                throw th2;
            }
        }
    }

    @t0(version = "1.1")
    @n0
    public static final void a(@i.c.a.e Closeable closeable, @i.c.a.e Throwable th) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            h.g.a(th, th2);
        }
    }
}

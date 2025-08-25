package h;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public class g {
    @h.m2.f
    private static final void a(@i.c.a.d Throwable th, PrintWriter printWriter) {
        if (th == null) {
            throw new e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printWriter);
    }

    @h.m2.f
    private static final void b(@i.c.a.d Throwable th) {
        if (th == null) {
            throw new e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace();
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    @h.m2.f
    private static final void a(@i.c.a.d Throwable th, PrintStream printStream) {
        if (th == null) {
            throw new e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printStream);
    }

    @i.c.a.d
    public static final StackTraceElement[] a(@i.c.a.d Throwable th) {
        h.q2.t.i0.f(th, "$this$stackTrace");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            h.q2.t.i0.f();
        }
        return stackTrace;
    }

    public static void a(@i.c.a.d Throwable th, @i.c.a.d Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        h.q2.t.i0.f(th, "$this$addSuppressed");
        h.q2.t.i0.f(th2, "exception");
        h.m2.l.f16311a.a(th, th2);
    }
}

package g.a.v0;

import g.a.y0.j.k;

/* compiled from: Exceptions.java */
/* loaded from: classes2.dex */
public final class b {
    private b() {
        throw new IllegalStateException("No instances!");
    }

    @g.a.t0.f
    public static RuntimeException a(@g.a.t0.f Throwable th) {
        throw k.c(th);
    }

    public static void b(@g.a.t0.f Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}

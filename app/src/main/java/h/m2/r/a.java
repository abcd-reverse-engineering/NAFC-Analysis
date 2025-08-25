package h.m2.r;

import h.m2.k;
import h.q2.t.i0;
import i.c.a.d;

/* compiled from: JDK7PlatformImplementations.kt */
/* loaded from: classes2.dex */
public class a extends k {
    @Override // h.m2.k
    public void a(@d Throwable th, @d Throwable th2) {
        i0.f(th, "cause");
        i0.f(th2, "exception");
        th.addSuppressed(th2);
    }
}

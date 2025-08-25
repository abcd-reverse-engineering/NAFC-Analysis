package h.y2;

import h.m2.f;
import h.q2.e;

/* compiled from: Process.kt */
@e(name = "ProcessKt")
/* loaded from: classes2.dex */
public final class a {
    @f
    private static final Void a(int i2) {
        System.exit(i2);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}

package h.q2.t;

import java.util.Arrays;
import java.util.Collections;

/* compiled from: Reflection.java */
/* loaded from: classes2.dex */
public class h1 {

    /* renamed from: a, reason: collision with root package name */
    private static final i1 f16390a;

    /* renamed from: b, reason: collision with root package name */
    static final String f16391b = " (Kotlin reflection is not available)";

    /* renamed from: c, reason: collision with root package name */
    private static final h.w2.c[] f16392c;

    static {
        i1 i1Var = null;
        try {
            i1Var = (i1) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (i1Var == null) {
            i1Var = new i1();
        }
        f16390a = i1Var;
        f16392c = new h.w2.c[0];
    }

    public static h.w2.c a(Class cls) {
        return f16390a.a(cls);
    }

    public static h.w2.c b(Class cls) {
        return f16390a.b(cls);
    }

    public static h.w2.f c(Class cls, String str) {
        return f16390a.c(cls, str);
    }

    @h.t0(version = "1.4")
    public static h.w2.q d(Class cls) {
        return f16390a.a(b(cls), Collections.emptyList(), false);
    }

    public static h.w2.c a(Class cls, String str) {
        return f16390a.a(cls, str);
    }

    public static h.w2.c b(Class cls, String str) {
        return f16390a.b(cls, str);
    }

    @h.t0(version = "1.4")
    public static h.w2.q c(Class cls) {
        return f16390a.a(b(cls), Collections.emptyList(), true);
    }

    public static h.w2.c[] a(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f16392c;
        }
        h.w2.c[] cVarArr = new h.w2.c[length];
        for (int i2 = 0; i2 < length; i2++) {
            cVarArr[i2] = b(clsArr[i2]);
        }
        return cVarArr;
    }

    @h.t0(version = "1.4")
    public static h.w2.q b(Class cls, h.w2.s sVar) {
        return f16390a.a(b(cls), Collections.singletonList(sVar), false);
    }

    @h.t0(version = "1.4")
    public static h.w2.q b(Class cls, h.w2.s sVar, h.w2.s sVar2) {
        return f16390a.a(b(cls), Arrays.asList(sVar, sVar2), false);
    }

    @h.t0(version = "1.4")
    public static h.w2.q b(Class cls, h.w2.s... sVarArr) {
        return f16390a.a(b(cls), h.g2.r.J(sVarArr), false);
    }

    @h.t0(version = "1.1")
    public static String a(j0 j0Var) {
        return f16390a.a(j0Var);
    }

    @h.t0(version = "1.3")
    public static String a(b0 b0Var) {
        return f16390a.a(b0Var);
    }

    public static h.w2.g a(d0 d0Var) {
        return f16390a.a(d0Var);
    }

    public static h.w2.n a(z0 z0Var) {
        return f16390a.a(z0Var);
    }

    public static h.w2.i a(q0 q0Var) {
        return f16390a.a(q0Var);
    }

    public static h.w2.o a(b1 b1Var) {
        return f16390a.a(b1Var);
    }

    public static h.w2.j a(s0 s0Var) {
        return f16390a.a(s0Var);
    }

    public static h.w2.p a(d1 d1Var) {
        return f16390a.a(d1Var);
    }

    public static h.w2.k a(u0 u0Var) {
        return f16390a.a(u0Var);
    }

    @h.t0(version = "1.4")
    public static h.w2.q a(Class cls, h.w2.s sVar) {
        return f16390a.a(b(cls), Collections.singletonList(sVar), true);
    }

    @h.t0(version = "1.4")
    public static h.w2.q a(Class cls, h.w2.s sVar, h.w2.s sVar2) {
        return f16390a.a(b(cls), Arrays.asList(sVar, sVar2), true);
    }

    @h.t0(version = "1.4")
    public static h.w2.q a(Class cls, h.w2.s... sVarArr) {
        return f16390a.a(b(cls), h.g2.r.J(sVarArr), true);
    }
}

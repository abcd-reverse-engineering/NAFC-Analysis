package h.q2.t;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.lang.annotation.Annotation;
import java.util.List;

/* compiled from: TypeReference.kt */
@h.t0(version = "1.4")
@h.y(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0006H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "()Z", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "equals", DispatchConstants.OTHER, "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class p1 implements h.w2.q {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final h.w2.e f16424a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final List<h.w2.s> f16425b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f16426c;

    /* compiled from: TypeReference.kt */
    static final class a extends j0 implements h.q2.s.l<h.w2.s, String> {
        a() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d h.w2.s sVar) {
            i0.f(sVar, "it");
            return p1.this.a(sVar);
        }
    }

    public p1(@i.c.a.d h.w2.e eVar, @i.c.a.d List<h.w2.s> list, boolean z) {
        i0.f(eVar, "classifier");
        i0.f(list, "arguments");
        this.f16424a = eVar;
        this.f16425b = list;
        this.f16426c = z;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (obj instanceof p1) {
            p1 p1Var = (p1) obj;
            if (i0.a(p(), p1Var.p()) && i0.a(o(), p1Var.o()) && n() == p1Var.n()) {
                return true;
            }
        }
        return false;
    }

    @Override // h.w2.a
    @i.c.a.d
    public List<Annotation> getAnnotations() {
        return h.g2.y.b();
    }

    public int hashCode() {
        return (((p().hashCode() * 31) + o().hashCode()) * 31) + Boolean.valueOf(n()).hashCode();
    }

    @Override // h.w2.q
    public boolean n() {
        return this.f16426c;
    }

    @Override // h.w2.q
    @i.c.a.d
    public List<h.w2.s> o() {
        return this.f16425b;
    }

    @Override // h.w2.q
    @i.c.a.d
    public h.w2.e p() {
        return this.f16424a;
    }

    @i.c.a.d
    public String toString() {
        return a() + " (Kotlin reflection is not available)";
    }

    private final String a() {
        h.w2.e eVarP = p();
        if (!(eVarP instanceof h.w2.c)) {
            eVarP = null;
        }
        h.w2.c cVar = (h.w2.c) eVarP;
        Class<?> clsA = cVar != null ? h.q2.a.a(cVar) : null;
        return (clsA == null ? p().toString() : clsA.isArray() ? a(clsA) : clsA.getName()) + (o().isEmpty() ? "" : h.g2.g0.a(o(), ", ", "<", ">", 0, null, new a(), 24, null)) + (n() ? "?" : "");
    }

    private final String a(@i.c.a.d Class<?> cls) {
        return i0.a(cls, boolean[].class) ? "kotlin.BooleanArray" : i0.a(cls, char[].class) ? "kotlin.CharArray" : i0.a(cls, byte[].class) ? "kotlin.ByteArray" : i0.a(cls, short[].class) ? "kotlin.ShortArray" : i0.a(cls, int[].class) ? "kotlin.IntArray" : i0.a(cls, float[].class) ? "kotlin.FloatArray" : i0.a(cls, long[].class) ? "kotlin.LongArray" : i0.a(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(@i.c.a.d h.w2.s sVar) {
        String strValueOf;
        if (sVar.d() == null) {
            return "*";
        }
        h.w2.q qVarC = sVar.c();
        if (!(qVarC instanceof p1)) {
            qVarC = null;
        }
        p1 p1Var = (p1) qVarC;
        if (p1Var == null || (strValueOf = p1Var.a()) == null) {
            strValueOf = String.valueOf(sVar.c());
        }
        h.w2.t tVarD = sVar.d();
        if (tVarD != null) {
            int i2 = o1.f16420a[tVarD.ordinal()];
            if (i2 == 1) {
                return strValueOf;
            }
            if (i2 == 2) {
                return "in " + strValueOf;
            }
            if (i2 == 3) {
                return "out " + strValueOf;
            }
        }
        throw new h.z();
    }
}

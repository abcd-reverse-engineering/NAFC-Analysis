package l.q.a;

import g.a.b0;
import g.a.j0;
import g.a.k0;
import g.a.l;
import g.a.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import l.c;
import l.m;
import l.n;

/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: classes2.dex */
public final class h extends c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final j0 f17235a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f17236b;

    private h(@Nullable j0 j0Var, boolean z) {
        this.f17235a = j0Var;
        this.f17236b = z;
    }

    public static h a() {
        return new h(null, false);
    }

    public static h b() {
        return new h(null, true);
    }

    public static h a(j0 j0Var) {
        if (j0Var != null) {
            return new h(j0Var, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // l.c.a
    public l.c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        Type typeA;
        boolean z;
        boolean z2;
        Class<?> clsA = c.a.a(type);
        if (clsA == g.a.c.class) {
            return new g(Void.class, this.f17235a, this.f17236b, false, true, false, false, false, true);
        }
        boolean z3 = clsA == l.class;
        boolean z4 = clsA == k0.class;
        boolean z5 = clsA == s.class;
        if (clsA != b0.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeA2 = c.a.a(0, (ParameterizedType) type);
        Class<?> clsA2 = c.a.a(typeA2);
        if (clsA2 == m.class) {
            if (typeA2 instanceof ParameterizedType) {
                typeA = c.a.a(0, (ParameterizedType) typeA2);
                z = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (clsA2 == e.class) {
            if (typeA2 instanceof ParameterizedType) {
                typeA = c.a.a(0, (ParameterizedType) typeA2);
                z = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            typeA = typeA2;
            z = false;
            z2 = true;
            return new g(typeA, this.f17235a, this.f17236b, z, z2, z3, z4, z5, false);
        }
        z2 = false;
        return new g(typeA, this.f17235a, this.f17236b, z, z2, z3, z4, z5, false);
    }
}

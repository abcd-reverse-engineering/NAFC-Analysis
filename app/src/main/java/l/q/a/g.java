package l.q.a;

import g.a.b0;
import g.a.j0;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: RxJava2CallAdapter.java */
/* loaded from: classes2.dex */
final class g<R> implements l.c<R, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Type f17226a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final j0 f17227b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f17228c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f17229d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f17230e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f17231f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f17232g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f17233h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f17234i;

    g(Type type, @Nullable j0 j0Var, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f17226a = type;
        this.f17227b = j0Var;
        this.f17228c = z;
        this.f17229d = z2;
        this.f17230e = z3;
        this.f17231f = z4;
        this.f17232g = z5;
        this.f17233h = z6;
        this.f17234i = z7;
    }

    @Override // l.c
    public Type a() {
        return this.f17226a;
    }

    @Override // l.c
    public Object a(l.b<R> bVar) {
        b0 bVar2 = this.f17228c ? new b(bVar) : new c(bVar);
        b0 fVar = this.f17229d ? new f(bVar2) : this.f17230e ? new a(bVar2) : bVar2;
        j0 j0Var = this.f17227b;
        if (j0Var != null) {
            fVar = fVar.c(j0Var);
        }
        return this.f17231f ? fVar.a(g.a.b.LATEST) : this.f17232g ? fVar.C() : this.f17233h ? fVar.B() : this.f17234i ? fVar.p() : fVar;
    }
}

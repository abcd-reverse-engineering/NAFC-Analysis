package h;

import com.taobao.accs.common.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
public class v {
    @i.c.a.d
    public static <T> s<T> a(@i.c.a.d h.q2.s.a<? extends T> aVar) {
        h.q2.t.i0.f(aVar, "initializer");
        return new a1(aVar, null, 2, null);
    }

    @i.c.a.d
    public static <T> s<T> a(@i.c.a.d x xVar, @i.c.a.d h.q2.s.a<? extends T> aVar) {
        h.q2.t.i0.f(xVar, Constants.KEY_MODE);
        h.q2.t.i0.f(aVar, "initializer");
        int i2 = t.f16478a[xVar.ordinal()];
        if (i2 == 1) {
            return new a1(aVar, null, 2, null);
        }
        if (i2 == 2) {
            return new s0(aVar);
        }
        if (i2 == 3) {
            return new z1(aVar);
        }
        throw new z();
    }

    @i.c.a.d
    public static final <T> s<T> a(@i.c.a.e Object obj, @i.c.a.d h.q2.s.a<? extends T> aVar) {
        h.q2.t.i0.f(aVar, "initializer");
        return new a1(aVar, obj);
    }
}

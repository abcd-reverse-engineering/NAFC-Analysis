package h.k2.n.a;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.t.i0;
import h.y;
import java.lang.reflect.Method;

/* compiled from: DebugMetadata.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class i {

    /* renamed from: b, reason: collision with root package name */
    @h.q2.c
    @i.c.a.e
    public static a f16303b;

    /* renamed from: c, reason: collision with root package name */
    public static final i f16304c = new i();

    /* renamed from: a, reason: collision with root package name */
    private static final a f16302a = new a(null, null, null);

    /* compiled from: DebugMetadata.kt */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @h.q2.c
        @i.c.a.e
        public final Method f16305a;

        /* renamed from: b, reason: collision with root package name */
        @h.q2.c
        @i.c.a.e
        public final Method f16306b;

        /* renamed from: c, reason: collision with root package name */
        @h.q2.c
        @i.c.a.e
        public final Method f16307c;

        public a(@i.c.a.e Method method, @i.c.a.e Method method2, @i.c.a.e Method method3) {
            this.f16305a = method;
            this.f16306b = method2;
            this.f16307c = method3;
        }
    }

    private i() {
    }

    private final a b(h.k2.n.a.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(CommonNetImpl.NAME, new Class[0]));
            f16303b = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f16302a;
            f16303b = aVar3;
            return aVar3;
        }
    }

    @i.c.a.e
    public final String a(@i.c.a.d h.k2.n.a.a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        i0.f(aVar, "continuation");
        a aVarB = f16303b;
        if (aVarB == null) {
            aVarB = b(aVar);
        }
        if (aVarB == f16302a || (method = aVarB.f16305a) == null || (objInvoke = method.invoke(aVar.getClass(), new Object[0])) == null || (method2 = aVarB.f16306b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVarB.f16307c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (!(objInvoke3 instanceof String)) {
            objInvoke3 = null;
        }
        return (String) objInvoke3;
    }
}

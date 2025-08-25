package h.m2;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.t.i0;
import h.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.MatchResult;

/* compiled from: PlatformImplementations.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", CommonNetImpl.NAME, "", "ReflectAddSuppressedMethod", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class k {

    /* compiled from: PlatformImplementations.kt */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @h.q2.c
        @i.c.a.e
        public static final Method f16309a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f16310b = new a();

        /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
        static {
            /*
                h.m2.k$a r0 = new h.m2.k$a
                r0.<init>()
                h.m2.k.a.f16310b = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                h.q2.t.i0.a(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                if (r4 >= r2) goto L48
                r5 = r1[r4]
                java.lang.String r6 = "it"
                h.q2.t.i0.a(r5, r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = h.q2.t.i0.a(r6, r7)
                if (r6 == 0) goto L41
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                h.q2.t.i0.a(r6, r7)
                java.lang.Object r6 = h.g2.n.H(r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = h.q2.t.i0.a(r6, r0)
                if (r6 == 0) goto L41
                r6 = 1
                goto L42
            L41:
                r6 = 0
            L42:
                if (r6 == 0) goto L45
                goto L49
            L45:
                int r4 = r4 + 1
                goto L15
            L48:
                r5 = 0
            L49:
                h.m2.k.a.f16309a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.m2.k.a.<clinit>():void");
        }

        private a() {
        }
    }

    public void a(@i.c.a.d Throwable th, @i.c.a.d Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i0.f(th, "cause");
        i0.f(th2, "exception");
        Method method = a.f16309a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    @i.c.a.e
    public h.z2.j a(@i.c.a.d MatchResult matchResult, @i.c.a.d String str) {
        i0.f(matchResult, "matchResult");
        i0.f(str, CommonNetImpl.NAME);
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @i.c.a.d
    public h.u2.f a() {
        return new h.u2.b();
    }
}

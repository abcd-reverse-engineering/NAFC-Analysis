package h.k2.n.a;

import com.umeng.analytics.pro.bh;
import h.t0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: DebugMetadata.kt */
@Target({ElementType.TYPE})
@h.f2.f(allowedTargets = {h.f2.b.CLASS})
@t0(version = "1.3")
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface f {
    @h.q2.e(name = bh.aI)
    String c() default "";

    @h.q2.e(name = "f")
    String f() default "";

    @h.q2.e(name = bh.aF)
    int[] i() default {};

    @h.q2.e(name = "l")
    int[] l() default {};

    @h.q2.e(name = "m")
    String m() default "";

    @h.q2.e(name = "n")
    String[] n() default {};

    @h.q2.e(name = bh.aE)
    String[] s() default {};

    @h.q2.e(name = "v")
    int v() default 1;
}

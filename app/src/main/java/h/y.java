package h;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Metadata.kt */
@Target({ElementType.TYPE})
@h.f2.f(allowedTargets = {h.f2.b.CLASS})
@t0(version = "1.3")
@Retention(RetentionPolicy.RUNTIME)
@h.f2.e(h.f2.a.RUNTIME)
/* loaded from: classes2.dex */
public @interface y {
    @h.q2.e(name = "bv")
    int[] bv() default {};

    @h.q2.e(name = "d1")
    String[] d1() default {};

    @h.q2.e(name = "d2")
    String[] d2() default {};

    @h.q2.e(name = "k")
    int k() default 1;

    @h.q2.e(name = "mv")
    int[] mv() default {};

    @h.q2.e(name = "pn")
    String pn() default "";

    @h.q2.e(name = "xi")
    int xi() default 0;

    @h.q2.e(name = "xs")
    String xs() default "";
}

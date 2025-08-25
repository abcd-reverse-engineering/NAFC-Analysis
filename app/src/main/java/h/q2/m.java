package h.q2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: PurelyImplements.kt */
@Target({ElementType.TYPE})
@h.f2.c
@h.f2.f(allowedTargets = {h.f2.b.CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@h.f2.e(h.f2.a.RUNTIME)
/* loaded from: classes2.dex */
public @interface m {
    String value();
}

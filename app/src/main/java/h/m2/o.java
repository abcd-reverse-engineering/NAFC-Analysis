package h.m2;

import h.t0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Annotations.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@h.f2.f(allowedTargets = {h.f2.b.CLASS, h.f2.b.FUNCTION, h.f2.b.PROPERTY, h.f2.b.CONSTRUCTOR, h.f2.b.TYPEALIAS})
@t0(version = "1.2")
@h.f2.d
@Retention(RetentionPolicy.SOURCE)
@h.f2.e(h.f2.a.SOURCE)
/* loaded from: classes2.dex */
public @interface o {
    int errorCode() default -1;

    h.d level() default h.d.ERROR;

    String message() default "";

    String version();

    p versionKind() default p.LANGUAGE_VERSION;
}

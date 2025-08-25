package h.q2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JvmPlatformAnnotations.kt */
@Target({ElementType.METHOD})
@h.f2.c
@h.f2.f(allowedTargets = {h.f2.b.FUNCTION, h.f2.b.PROPERTY_GETTER, h.f2.b.PROPERTY_SETTER, h.f2.b.FILE})
@Documented
@Retention(RetentionPolicy.CLASS)
@h.f2.e(h.f2.a.BINARY)
/* loaded from: classes2.dex */
public @interface e {
    String name();
}

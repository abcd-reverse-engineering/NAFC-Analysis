package h.f2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Annotations.kt */
@Target({ElementType.ANNOTATION_TYPE})
@c
@f(allowedTargets = {b.ANNOTATION_CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface f {
    b[] allowedTargets();
}

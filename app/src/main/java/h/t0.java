package h;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Annotations.kt */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@h.f2.c
@h.f2.f(allowedTargets = {h.f2.b.CLASS, h.f2.b.PROPERTY, h.f2.b.FIELD, h.f2.b.CONSTRUCTOR, h.f2.b.FUNCTION, h.f2.b.PROPERTY_GETTER, h.f2.b.PROPERTY_SETTER, h.f2.b.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.CLASS)
@h.f2.e(h.f2.a.BINARY)
/* loaded from: classes2.dex */
public @interface t0 {
    String version();
}

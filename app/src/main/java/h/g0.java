package h;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: OptIn.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@h.f2.f(allowedTargets = {h.f2.b.CLASS, h.f2.b.PROPERTY, h.f2.b.LOCAL_VARIABLE, h.f2.b.VALUE_PARAMETER, h.f2.b.CONSTRUCTOR, h.f2.b.FUNCTION, h.f2.b.PROPERTY_GETTER, h.f2.b.PROPERTY_SETTER, h.f2.b.EXPRESSION, h.f2.b.FILE, h.f2.b.TYPEALIAS})
@t0(version = "1.3")
@Retention(RetentionPolicy.SOURCE)
@h.f2.e(h.f2.a.SOURCE)
/* loaded from: classes2.dex */
public @interface g0 {
    Class<? extends Annotation>[] markerClass();
}

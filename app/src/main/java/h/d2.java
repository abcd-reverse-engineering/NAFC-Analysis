package h;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Experimental.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@h.f2.f(allowedTargets = {h.f2.b.CLASS, h.f2.b.PROPERTY, h.f2.b.CONSTRUCTOR, h.f2.b.FUNCTION, h.f2.b.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@h.f2.e(h.f2.a.BINARY)
/* loaded from: classes2.dex */
public @interface d2 {
    Class<? extends Annotation>[] markerClass();
}

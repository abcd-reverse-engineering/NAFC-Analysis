package h.p2;

import h.f2.b;
import h.f2.f;
import h.h0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsAnnotationsH.kt */
@h0
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@f(allowedTargets = {b.CLASS, b.FUNCTION, b.PROPERTY, b.CONSTRUCTOR, b.PROPERTY_GETTER, b.PROPERTY_SETTER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
@interface a {
    String name();
}

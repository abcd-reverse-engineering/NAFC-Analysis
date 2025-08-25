package h;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Experimental.kt */
@Target({ElementType.ANNOTATION_TYPE})
@c(message = "Please use RequiresOptIn instead.")
@Retention(RetentionPolicy.CLASS)
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009120\u0001¨\u0006\u0006"}, d2 = {"Lkotlin/Experimental;", "", "level", "Lkotlin/Experimental$Level;", "()Lkotlin/Experimental$Level;", "Level", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@h.f2.f(allowedTargets = {h.f2.b.ANNOTATION_CLASS})
@t0(version = "1.2")
@h.f2.e(h.f2.a.BINARY)
/* loaded from: classes2.dex */
public @interface h {

    /* compiled from: Experimental.kt */
    public enum a {
        WARNING,
        ERROR
    }

    a level() default a.ERROR;
}

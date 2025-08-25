package i.b.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: MagicConstant.java */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface e {
    long[] flags() default {};

    Class flagsFromClass() default void.class;

    long[] intValues() default {};

    String[] stringValues() default {};

    Class valuesFromClass() default void.class;
}

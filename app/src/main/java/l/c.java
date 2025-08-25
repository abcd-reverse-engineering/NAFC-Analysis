package l;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: CallAdapter.java */
/* loaded from: classes2.dex */
public interface c<R, T> {

    /* compiled from: CallAdapter.java */
    public static abstract class a {
        protected static Type a(int i2, ParameterizedType parameterizedType) {
            return p.a(i2, parameterizedType);
        }

        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, n nVar);

        protected static Class<?> a(Type type) {
            return p.c(type);
        }
    }

    T a(b<R> bVar);

    Type a();
}

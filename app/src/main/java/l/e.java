package l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: Converter.java */
/* loaded from: classes2.dex */
public interface e<F, T> {

    /* compiled from: Converter.java */
    public static abstract class a {
        protected static Type a(int i2, ParameterizedType parameterizedType) {
            return p.a(i2, parameterizedType);
        }

        @Nullable
        public e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
            return null;
        }

        @Nullable
        public e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
            return null;
        }

        @Nullable
        public e<?, String> b(Type type, Annotation[] annotationArr, n nVar) {
            return null;
        }

        protected static Class<?> a(Type type) {
            return p.c(type);
        }
    }

    T a(F f2) throws IOException;
}

package g.a.y0.j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: ArrayListSupplier.java */
/* loaded from: classes2.dex */
public enum b implements Callable<List<Object>>, g.a.x0.o<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> g.a.x0.o<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // g.a.x0.o
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}

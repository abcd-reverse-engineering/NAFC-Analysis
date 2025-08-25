package g.a.y0.j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: HashMapSupplier.java */
/* loaded from: classes2.dex */
public enum m implements Callable<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}

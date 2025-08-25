package g.a.y0.j;

import java.util.List;

/* compiled from: ListAddBiConsumer.java */
/* loaded from: classes2.dex */
public enum o implements g.a.x0.c<List, Object, List> {
    INSTANCE;

    public static <T> g.a.x0.c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // g.a.x0.c
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}

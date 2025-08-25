package com.huawei.hms.common.data;

import com.xiaomi.push.service.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        f.AnonymousClass3 anonymousClass3 = (ArrayList<T>) new ArrayList();
        if (iterable == null) {
            return anonymousClass3;
        }
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            anonymousClass3.add(it.next().freeze());
        }
        return anonymousClass3;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}

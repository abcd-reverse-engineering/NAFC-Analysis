package h.k2.l;

import h.t0;

/* compiled from: Coroutines.kt */
@t0(version = "1.1")
/* loaded from: classes2.dex */
public interface c<T> {
    @i.c.a.d
    e getContext();

    void resume(T t);

    void resumeWithException(@i.c.a.d Throwable th);
}

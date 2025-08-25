package g.a.y0.j;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AtomicThrowable.java */
/* loaded from: classes2.dex */
public final class c extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return k.a(this, th);
    }

    public boolean isTerminated() {
        return get() == k.f16046a;
    }

    public Throwable terminate() {
        return k.a(this);
    }
}

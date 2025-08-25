package g.a.d1;

import g.a.l;
import g.a.q;

/* compiled from: FlowableProcessor.java */
/* loaded from: classes2.dex */
public abstract class c<T> extends l<T> implements i.d.a<T, T>, q<T> {
    public abstract Throwable T();

    public abstract boolean U();

    public abstract boolean V();

    public abstract boolean W();

    @g.a.t0.f
    public final c<T> X() {
        return this instanceof f ? this : new f(this);
    }
}

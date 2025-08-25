package h.k2.n.a;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public final class c implements h.k2.d<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final c f16299a = new c();

    private c() {
    }

    @Override // h.k2.d
    @i.c.a.d
    public h.k2.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // h.k2.d
    public void resumeWith(@i.c.a.d Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @i.c.a.d
    public String toString() {
        return "This continuation is already complete";
    }
}

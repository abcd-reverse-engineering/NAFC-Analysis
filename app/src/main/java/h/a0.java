package h;

/* compiled from: Standard.kt */
/* loaded from: classes2.dex */
public final class a0 extends Error {
    public a0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(@i.c.a.d String str) {
        super(str);
        h.q2.t.i0.f(str, "message");
    }

    public /* synthetic */ a0(String str, int i2, h.q2.t.v vVar) {
        this((i2 & 1) != 0 ? "An operation is not implemented." : str);
    }
}

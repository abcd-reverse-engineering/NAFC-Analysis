package h.q2.t;

/* compiled from: FunctionReferenceImpl.java */
/* loaded from: classes2.dex */
public class e0 extends d0 {
    private final String name;
    private final h.w2.f owner;
    private final String signature;

    public e0(int i2, h.w2.f fVar, String str, String str2) {
        super(i2);
        this.owner = fVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // h.q2.t.p, h.w2.b
    public String getName() {
        return this.name;
    }

    @Override // h.q2.t.p
    public h.w2.f getOwner() {
        return this.owner;
    }

    @Override // h.q2.t.p
    public String getSignature() {
        return this.signature;
    }
}

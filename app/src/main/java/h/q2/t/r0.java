package h.q2.t;

/* compiled from: MutablePropertyReference0Impl.java */
/* loaded from: classes2.dex */
public class r0 extends q0 {
    private final String name;
    private final h.w2.f owner;
    private final String signature;

    public r0(h.w2.f fVar, String str, String str2) {
        this.owner = fVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // h.w2.n
    public Object get() {
        return getGetter().call(new Object[0]);
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

    @Override // h.w2.i
    public void set(Object obj) {
        getSetter().call(obj);
    }
}

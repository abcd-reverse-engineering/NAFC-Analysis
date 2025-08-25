package h.q2.t;

/* compiled from: MutablePropertyReference1Impl.java */
/* loaded from: classes2.dex */
public class t0 extends s0 {
    private final String name;
    private final h.w2.f owner;
    private final String signature;

    public t0(h.w2.f fVar, String str, String str2) {
        this.owner = fVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // h.w2.o
    public Object get(Object obj) {
        return getGetter().call(obj);
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

    @Override // h.w2.j
    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }
}

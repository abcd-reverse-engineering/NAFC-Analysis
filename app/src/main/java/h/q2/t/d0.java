package h.q2.t;

/* compiled from: FunctionReference.java */
/* loaded from: classes2.dex */
public class d0 extends p implements b0, h.w2.g {
    private final int arity;

    public d0(int i2) {
        this.arity = i2;
    }

    @Override // h.q2.t.p
    @h.t0(version = "1.1")
    protected h.w2.b computeReflected() {
        return h1.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0)) {
            if (obj instanceof h.w2.g) {
                return obj.equals(compute());
            }
            return false;
        }
        d0 d0Var = (d0) obj;
        if (getOwner() != null ? getOwner().equals(d0Var.getOwner()) : d0Var.getOwner() == null) {
            if (getName().equals(d0Var.getName()) && getSignature().equals(d0Var.getSignature()) && i0.a(getBoundReceiver(), d0Var.getBoundReceiver())) {
                return true;
            }
        }
        return false;
    }

    @Override // h.q2.t.b0
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // h.w2.g
    @h.t0(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // h.w2.g
    @h.t0(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // h.w2.g
    @h.t0(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // h.w2.g
    @h.t0(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // h.q2.t.p, h.w2.b, h.w2.g
    @h.t0(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        h.w2.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.q2.t.p
    @h.t0(version = "1.1")
    public h.w2.g getReflected() {
        return (h.w2.g) super.getReflected();
    }

    @h.t0(version = "1.1")
    public d0(int i2, Object obj) {
        super(obj);
        this.arity = i2;
    }
}

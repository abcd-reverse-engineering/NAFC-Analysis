package h.q2.t;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* compiled from: CallableReference.java */
/* loaded from: classes2.dex */
public abstract class p implements h.w2.b, Serializable {

    @h.t0(version = "1.1")
    public static final Object NO_RECEIVER = a.f16423a;

    /* renamed from: a, reason: collision with root package name */
    private transient h.w2.b f16421a;

    /* renamed from: receiver, reason: collision with root package name */
    @h.t0(version = "1.1")
    protected final Object f16422receiver;

    /* compiled from: CallableReference.java */
    @h.t0(version = "1.2")
    private static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final a f16423a = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f16423a;
        }
    }

    public p() {
        this(NO_RECEIVER);
    }

    @Override // h.w2.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // h.w2.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @h.t0(version = "1.1")
    public h.w2.b compute() {
        h.w2.b bVar = this.f16421a;
        if (bVar != null) {
            return bVar;
        }
        h.w2.b bVarComputeReflected = computeReflected();
        this.f16421a = bVarComputeReflected;
        return bVarComputeReflected;
    }

    protected abstract h.w2.b computeReflected();

    @Override // h.w2.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @h.t0(version = "1.1")
    public Object getBoundReceiver() {
        return this.f16422receiver;
    }

    @Override // h.w2.b
    public String getName() {
        throw new AbstractMethodError();
    }

    public h.w2.f getOwner() {
        throw new AbstractMethodError();
    }

    @Override // h.w2.b
    public List<h.w2.l> getParameters() {
        return getReflected().getParameters();
    }

    @h.t0(version = "1.1")
    protected h.w2.b getReflected() {
        h.w2.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new h.q2.l();
    }

    @Override // h.w2.b
    public h.w2.q getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override // h.w2.b
    @h.t0(version = "1.1")
    public List<h.w2.r> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // h.w2.b
    @h.t0(version = "1.1")
    public h.w2.u getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // h.w2.b
    @h.t0(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // h.w2.b
    @h.t0(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // h.w2.b
    @h.t0(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // h.w2.b, h.w2.g
    @h.t0(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @h.t0(version = "1.1")
    protected p(Object obj) {
        this.f16422receiver = obj;
    }
}

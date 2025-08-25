package com.vivo.push.b;

/* compiled from: DefaultCommand.java */
/* loaded from: classes2.dex */
public final class f extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private int f11945a;

    public f() {
        super(0);
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        if (dVar != null) {
            dVar.a("APP_CLIENT_SWITCH_FLAG", this.f11945a);
        }
    }

    public final void d() {
        this.f11945a = 3;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "DefaultCommand";
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        if (dVar != null) {
            this.f11945a = dVar.b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}

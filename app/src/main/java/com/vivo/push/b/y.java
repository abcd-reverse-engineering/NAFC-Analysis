package com.vivo.push.b;

/* compiled from: StopServiceCommand.java */
/* loaded from: classes2.dex */
public final class y extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f11984a;

    public y(String str) {
        super(2008);
        this.f11984a = str;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.f11984a);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f11984a = dVar.a("package_name");
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "StopServiceCommand";
    }

    public y() {
        super(2008);
    }
}

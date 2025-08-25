package com.vivo.push.b;

/* compiled from: OnDispatcherReceiveCommand.java */
/* loaded from: classes2.dex */
public final class l extends s {

    /* renamed from: a, reason: collision with root package name */
    private int f11954a;

    /* renamed from: b, reason: collision with root package name */
    private int f11955b;

    public l() {
        super(2016);
        this.f11954a = -1;
        this.f11955b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("key_dispatch_environment", this.f11954a);
        dVar.a("key_dispatch_area", this.f11955b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11954a = dVar.b("key_dispatch_environment", 1);
        this.f11955b = dVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.f11955b;
    }

    public final int d() {
        return this.f11954a;
    }
}
